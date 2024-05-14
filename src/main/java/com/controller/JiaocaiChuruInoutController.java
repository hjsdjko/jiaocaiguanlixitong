
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 出入库
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiaocaiChuruInout")
public class JiaocaiChuruInoutController {
    private static final Logger logger = LoggerFactory.getLogger(JiaocaiChuruInoutController.class);

    @Autowired
    private JiaocaiChuruInoutService jiaocaiChuruInoutService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    // 列表详情的表级联service
    @Autowired
    private JiaocaiChuruInoutListService jiaocaiChuruInoutListService;
//    @Autowired
//    private YonghuService yonghuService;
    @Autowired
    private JiaocaiService jiaocaiService;
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private JiaoshiService jiaoshiService;
    @Autowired
    private JiaocaiguanliService jiaocaiguanliService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("教师".equals(role))
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        else if("教材管理员".equals(role))
            params.put("jiaocaiguanliId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = jiaocaiChuruInoutService.queryPage(params);

        //字典表数据转换
        List<JiaocaiChuruInoutView> list =(List<JiaocaiChuruInoutView>)page.getList();
        for(JiaocaiChuruInoutView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiaocaiChuruInoutEntity jiaocaiChuruInout = jiaocaiChuruInoutService.selectById(id);
        if(jiaocaiChuruInout !=null){
            //entity转view
            JiaocaiChuruInoutView view = new JiaocaiChuruInoutView();
            BeanUtils.copyProperties( jiaocaiChuruInout , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiaocaiChuruInoutEntity jiaocaiChuruInout, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiaocaiChuruInout:{}",this.getClass().getName(),jiaocaiChuruInout.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JiaocaiChuruInoutEntity> queryWrapper = new EntityWrapper<JiaocaiChuruInoutEntity>()
            .eq("jiaocai_churu_inout_uuid_number", jiaocaiChuruInout.getJiaocaiChuruInoutUuidNumber())
            .eq("jiaocai_churu_inout_name", jiaocaiChuruInout.getJiaocaiChuruInoutName())
            .eq("jiaocai_churu_inout_types", jiaocaiChuruInout.getJiaocaiChuruInoutTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaocaiChuruInoutEntity jiaocaiChuruInoutEntity = jiaocaiChuruInoutService.selectOne(queryWrapper);
        if(jiaocaiChuruInoutEntity==null){
            jiaocaiChuruInout.setInsertTime(new Date());
            jiaocaiChuruInout.setCreateTime(new Date());
            jiaocaiChuruInoutService.insert(jiaocaiChuruInout);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaocaiChuruInoutEntity jiaocaiChuruInout, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiaocaiChuruInout:{}",this.getClass().getName(),jiaocaiChuruInout.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<JiaocaiChuruInoutEntity> queryWrapper = new EntityWrapper<JiaocaiChuruInoutEntity>()
            .notIn("id",jiaocaiChuruInout.getId())
            .andNew()
            .eq("jiaocai_churu_inout_uuid_number", jiaocaiChuruInout.getJiaocaiChuruInoutUuidNumber())
            .eq("jiaocai_churu_inout_name", jiaocaiChuruInout.getJiaocaiChuruInoutName())
            .eq("jiaocai_churu_inout_types", jiaocaiChuruInout.getJiaocaiChuruInoutTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaocaiChuruInoutEntity jiaocaiChuruInoutEntity = jiaocaiChuruInoutService.selectOne(queryWrapper);
        if(jiaocaiChuruInoutEntity==null){
            jiaocaiChuruInoutService.updateById(jiaocaiChuruInout);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }
    /**
    * 出库
    */
    @RequestMapping("/outJiaocaiChuruInoutList")
    public R outJiaocaiChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("outJiaocaiChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取出入库名称并判断是否存在
        String jiaocaiChuruInoutName = String.valueOf(params.get("jiaocaiChuruInoutName"));
        Wrapper<JiaocaiChuruInoutEntity> queryWrapper = new EntityWrapper<JiaocaiChuruInoutEntity>()
            .eq("jiaocai_churu_inout_name", jiaocaiChuruInoutName)
            ;
        JiaocaiChuruInoutEntity jiaocaiChuruInoutSelectOne = jiaocaiChuruInoutService.selectOne(queryWrapper);
        if(jiaocaiChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");


    //取当前表的级联表并判断是否前台传入

        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");


        Set<String> ids = map.keySet();

        List<JiaocaiEntity> jiaocaiList = jiaocaiService.selectBatchIds(ids);
        if(jiaocaiList == null || jiaocaiList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(JiaocaiEntity w:jiaocaiList){
                Integer value = w.getJiaocaiKucunNumber()-map.get(String.valueOf(w.getId()));
                if(value <0){
                    return R.error(511,"出库数量大于库存数量");
                }
                w.setJiaocaiKucunNumber(value);
            }
        }

        //当前表
        JiaocaiChuruInoutEntity jiaocaiChuruInoutEntity = new JiaocaiChuruInoutEntity<>();
            jiaocaiChuruInoutEntity.setJiaocaiChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            jiaocaiChuruInoutEntity.setJiaocaiChuruInoutName(jiaocaiChuruInoutName);
            jiaocaiChuruInoutEntity.setJiaocaiChuruInoutTypes(1);
            jiaocaiChuruInoutEntity.setJiaocaiChuruInoutContent("");
            jiaocaiChuruInoutEntity.setInsertTime(new Date());
            jiaocaiChuruInoutEntity.setCreateTime(new Date());

        boolean insertJiaocaiChuruInout = jiaocaiChuruInoutService.insert(jiaocaiChuruInoutEntity);
        if(insertJiaocaiChuruInout){
            //级联表
            ArrayList<JiaocaiChuruInoutListEntity> jiaocaiChuruInoutLists = new ArrayList<>();
            for(String id:ids){
                JiaocaiChuruInoutListEntity jiaocaiChuruInoutListEntity = new JiaocaiChuruInoutListEntity();
                    jiaocaiChuruInoutListEntity.setJiaocaiChuruInoutId(jiaocaiChuruInoutEntity.getId());
                    jiaocaiChuruInoutListEntity.setJiaocaiId(Integer.valueOf(id));
                    jiaocaiChuruInoutListEntity.setJiaocaiChuruInoutListNumber(map.get(id));
                    jiaocaiChuruInoutListEntity.setInsertTime(new Date());
                    jiaocaiChuruInoutListEntity.setCreateTime(new Date());
                jiaocaiChuruInoutLists.add(jiaocaiChuruInoutListEntity);
                jiaocaiService.updateBatchById(jiaocaiList);
            }
            jiaocaiChuruInoutListService.insertBatch(jiaocaiChuruInoutLists);
        }
        return R.ok();
    }

    /**
    *入库
    */
    @RequestMapping("/inJiaocaiChuruInoutList")
    public R inJiaocaiChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("inJiaocaiChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        //params:{"map":{"1":2,"2":3},"wuziOutinName":"订单1"}

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取当前表名称并判断
        String jiaocaiChuruInoutName = String.valueOf(params.get("jiaocaiChuruInoutName"));
        Wrapper<JiaocaiChuruInoutEntity> queryWrapper = new EntityWrapper<JiaocaiChuruInoutEntity>()
            .eq("jiaocai_churu_inout_name", jiaocaiChuruInoutName)
            ;
        JiaocaiChuruInoutEntity jiaocaiChuruInoutSelectOne = jiaocaiChuruInoutService.selectOne(queryWrapper);
        if(jiaocaiChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");


        //取当前表的级联表并判断是否前台传入

        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");

        Set<String> ids = map.keySet();

        List<JiaocaiEntity> jiaocaiList = jiaocaiService.selectBatchIds(ids);
        if(jiaocaiList == null || jiaocaiList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(JiaocaiEntity w:jiaocaiList){
                w.setJiaocaiKucunNumber(w.getJiaocaiKucunNumber()+map.get(String.valueOf(w.getId())));
            }
        }

        //当前表
        JiaocaiChuruInoutEntity jiaocaiChuruInoutEntity = new JiaocaiChuruInoutEntity<>();
            jiaocaiChuruInoutEntity.setJiaocaiChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            jiaocaiChuruInoutEntity.setJiaocaiChuruInoutName(jiaocaiChuruInoutName);
            jiaocaiChuruInoutEntity.setJiaocaiChuruInoutTypes(2);
            jiaocaiChuruInoutEntity.setJiaocaiChuruInoutContent("");
            jiaocaiChuruInoutEntity.setInsertTime(new Date());
            jiaocaiChuruInoutEntity.setCreateTime(new Date());


        boolean insertJiaocaiChuruInout = jiaocaiChuruInoutService.insert(jiaocaiChuruInoutEntity);
        if(insertJiaocaiChuruInout){
            //级联表
            ArrayList<JiaocaiChuruInoutListEntity> jiaocaiChuruInoutLists = new ArrayList<>();
            for(String id:ids){
                JiaocaiChuruInoutListEntity jiaocaiChuruInoutListEntity = new JiaocaiChuruInoutListEntity();
                jiaocaiChuruInoutListEntity.setJiaocaiChuruInoutId(jiaocaiChuruInoutEntity.getId());
                jiaocaiChuruInoutListEntity.setJiaocaiId(Integer.valueOf(id));
                jiaocaiChuruInoutListEntity.setJiaocaiChuruInoutListNumber(map.get(id));
                jiaocaiChuruInoutListEntity.setInsertTime(new Date());
                jiaocaiChuruInoutListEntity.setCreateTime(new Date());
                jiaocaiChuruInoutLists.add(jiaocaiChuruInoutListEntity);
                jiaocaiService.updateBatchById(jiaocaiList);
            }
            jiaocaiChuruInoutListService.insertBatch(jiaocaiChuruInoutLists);
        }

        return R.ok();
    }
    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jiaocaiChuruInoutService.deleteBatchIds(Arrays.asList(ids));
        jiaocaiChuruInoutListService.delete(new EntityWrapper<JiaocaiChuruInoutListEntity>().in("jiaocai_churu_inout_id",ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<JiaocaiChuruInoutEntity> jiaocaiChuruInoutList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JiaocaiChuruInoutEntity jiaocaiChuruInoutEntity = new JiaocaiChuruInoutEntity();
//                            jiaocaiChuruInoutEntity.setJiaocaiChuruInoutUuidNumber(data.get(0));                    //出入库流水号 要改的
//                            jiaocaiChuruInoutEntity.setJiaocaiChuruInoutName(data.get(0));                    //出入库名称 要改的
//                            jiaocaiChuruInoutEntity.setJiaocaiChuruInoutTypes(Integer.valueOf(data.get(0)));   //出入库类型 要改的
//                            jiaocaiChuruInoutEntity.setJiaocaiChuruInoutContent("");//详情和图片
//                            jiaocaiChuruInoutEntity.setInsertTime(date);//时间
//                            jiaocaiChuruInoutEntity.setCreateTime(date);//时间
                            jiaocaiChuruInoutList.add(jiaocaiChuruInoutEntity);


                            //把要查询是否重复的字段放入map中
                                //出入库流水号
                                if(seachFields.containsKey("jiaocaiChuruInoutUuidNumber")){
                                    List<String> jiaocaiChuruInoutUuidNumber = seachFields.get("jiaocaiChuruInoutUuidNumber");
                                    jiaocaiChuruInoutUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiaocaiChuruInoutUuidNumber = new ArrayList<>();
                                    jiaocaiChuruInoutUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiaocaiChuruInoutUuidNumber",jiaocaiChuruInoutUuidNumber);
                                }
                        }

                        //查询是否重复
                         //出入库流水号
                        List<JiaocaiChuruInoutEntity> jiaocaiChuruInoutEntities_jiaocaiChuruInoutUuidNumber = jiaocaiChuruInoutService.selectList(new EntityWrapper<JiaocaiChuruInoutEntity>().in("jiaocai_churu_inout_uuid_number", seachFields.get("jiaocaiChuruInoutUuidNumber")));
                        if(jiaocaiChuruInoutEntities_jiaocaiChuruInoutUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiaocaiChuruInoutEntity s:jiaocaiChuruInoutEntities_jiaocaiChuruInoutUuidNumber){
                                repeatFields.add(s.getJiaocaiChuruInoutUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [出入库流水号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiaocaiChuruInoutService.insertBatch(jiaocaiChuruInoutList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
