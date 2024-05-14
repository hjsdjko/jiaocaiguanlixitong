
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
 * 教师申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiaoshishenqing")
public class JiaoshishenqingController {
    private static final Logger logger = LoggerFactory.getLogger(JiaoshishenqingController.class);

    @Autowired
    private JiaoshishenqingService jiaoshishenqingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private JiaocaiService jiaocaiService;
    @Autowired
    private JiaoshiService jiaoshiService;

    @Autowired
    private YonghuService yonghuService;
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
        else if("学生".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
            params.put("banjiTypes",yonghuService.selectById((Integer)request.getSession().getAttribute("userId")).getBanjiTypes());
        }
        else if("教师".equals(role))
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        else if("教材管理员".equals(role))
            params.put("jiaocaiguanliId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = jiaoshishenqingService.queryPage(params);

        //字典表数据转换
        List<JiaoshishenqingView> list =(List<JiaoshishenqingView>)page.getList();
        for(JiaoshishenqingView c:list){
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
        JiaoshishenqingEntity jiaoshishenqing = jiaoshishenqingService.selectById(id);
        if(jiaoshishenqing !=null){
            //entity转view
            JiaoshishenqingView view = new JiaoshishenqingView();
            BeanUtils.copyProperties( jiaoshishenqing , view );//把实体数据重构到view中

                //级联表
                JiaocaiEntity jiaocai = jiaocaiService.selectById(jiaoshishenqing.getJiaocaiId());
                if(jiaocai != null){
                    BeanUtils.copyProperties( jiaocai , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiaocaiId(jiaocai.getId());
                }
                //级联表
                JiaoshiEntity jiaoshi = jiaoshiService.selectById(jiaoshishenqing.getJiaoshiId());
                if(jiaoshi != null){
                    BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiaoshiId(jiaoshi.getId());
                }
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
    public R save(@RequestBody JiaoshishenqingEntity jiaoshishenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiaoshishenqing:{}",this.getClass().getName(),jiaoshishenqing.toString());

        JiaocaiEntity jiaocaiEntity = jiaocaiService.selectById(jiaoshishenqing.getJiaocaiId());
        if(jiaoshishenqing.getJiaoshishenqingNumber() > jiaocaiEntity.getJiaocaiKucunNumber()){
            return R.error("教材数量不足");
        }
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("教材信息".equals(role))
            jiaoshishenqing.setJiaocaiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("教师".equals(role))
            jiaoshishenqing.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JiaoshishenqingEntity> queryWrapper = new EntityWrapper<JiaoshishenqingEntity>()
            .eq("jiaoshishenqing_uuid_number", jiaoshishenqing.getJiaoshishenqingUuidNumber())
            .eq("jiaocai_id", jiaoshishenqing.getJiaocaiId())
            .eq("jiaoshi_id", jiaoshishenqing.getJiaoshiId())
            .eq("jiaoshishenqing_number", jiaoshishenqing.getJiaoshishenqingNumber())
            .eq("kecheng_types", jiaoshishenqing.getKechengTypes())
            .eq("banji_types", jiaoshishenqing.getBanjiTypes())
            .eq("jiaoshishenqing_yesno_types", jiaoshishenqing.getJiaoshishenqingYesnoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaoshishenqingEntity jiaoshishenqingEntity = jiaoshishenqingService.selectOne(queryWrapper);
        if(jiaoshishenqingEntity==null){
            jiaoshishenqing.setJiaoshishenqingYesnoTypes(1);
            jiaoshishenqing.setInsertTime(new Date());
            jiaoshishenqing.setCreateTime(new Date());
            jiaoshishenqingService.insert(jiaoshishenqing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaoshishenqingEntity jiaoshishenqing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiaoshishenqing:{}",this.getClass().getName(),jiaoshishenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("教材信息".equals(role))
//            jiaoshishenqing.setJiaocaiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("教师".equals(role))
//            jiaoshishenqing.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<JiaoshishenqingEntity> queryWrapper = new EntityWrapper<JiaoshishenqingEntity>()
            .notIn("id",jiaoshishenqing.getId())
            .andNew()
            .eq("jiaoshishenqing_uuid_number", jiaoshishenqing.getJiaoshishenqingUuidNumber())
            .eq("jiaocai_id", jiaoshishenqing.getJiaocaiId())
            .eq("jiaoshi_id", jiaoshishenqing.getJiaoshiId())
            .eq("jiaoshishenqing_number", jiaoshishenqing.getJiaoshishenqingNumber())
            .eq("kecheng_types", jiaoshishenqing.getKechengTypes())
            .eq("banji_types", jiaoshishenqing.getBanjiTypes())
            .eq("jiaoshishenqing_yesno_types", jiaoshishenqing.getJiaoshishenqingYesnoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaoshishenqingEntity jiaoshishenqingEntity = jiaoshishenqingService.selectOne(queryWrapper);
        if(jiaoshishenqingEntity==null){

            if(jiaoshishenqing.getJiaoshishenqingYesnoTypes() == 2){
                JiaoshishenqingEntity jiaoshishenqingEntity1 = jiaoshishenqingService.selectById(jiaoshishenqing.getId());
                JiaocaiEntity jiaocaiEntity = jiaocaiService.selectById(jiaoshishenqingEntity1.getJiaocaiId());
                if(jiaocaiEntity.getJiaocaiKucunNumber() < jiaoshishenqingEntity1.getJiaoshishenqingNumber()){
                    return R.error("教材数量不足");
                }
                jiaocaiEntity.setJiaocaiKucunNumber(jiaocaiEntity.getJiaocaiKucunNumber() - jiaoshishenqingEntity1.getJiaoshishenqingNumber());
                jiaocaiService.updateById(jiaocaiEntity);
            }
            jiaoshishenqingService.updateById(jiaoshishenqing);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jiaoshishenqingService.deleteBatchIds(Arrays.asList(ids));
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
            List<JiaoshishenqingEntity> jiaoshishenqingList = new ArrayList<>();//上传的东西
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
                            JiaoshishenqingEntity jiaoshishenqingEntity = new JiaoshishenqingEntity();
//                            jiaoshishenqingEntity.setJiaoshishenqingUuidNumber(data.get(0));                    //申请编号 要改的
//                            jiaoshishenqingEntity.setJiaocaiId(Integer.valueOf(data.get(0)));   //教材 要改的
//                            jiaoshishenqingEntity.setJiaoshiId(Integer.valueOf(data.get(0)));   //教师 要改的
//                            jiaoshishenqingEntity.setJiaoshishenqingNumber(Integer.valueOf(data.get(0)));   //申请数量 要改的
//                            jiaoshishenqingEntity.setKechengTypes(Integer.valueOf(data.get(0)));   //课程 要改的
//                            jiaoshishenqingEntity.setBanjiTypes(Integer.valueOf(data.get(0)));   //班级 要改的
//                            jiaoshishenqingEntity.setJiaoshishenqingYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            jiaoshishenqingEntity.setJiaoshishenqingYesnoText(data.get(0));                    //申请结果 要改的
//                            jiaoshishenqingEntity.setInsertTime(date);//时间
//                            jiaoshishenqingEntity.setCreateTime(date);//时间
                            jiaoshishenqingList.add(jiaoshishenqingEntity);


                            //把要查询是否重复的字段放入map中
                                //申请编号
                                if(seachFields.containsKey("jiaoshishenqingUuidNumber")){
                                    List<String> jiaoshishenqingUuidNumber = seachFields.get("jiaoshishenqingUuidNumber");
                                    jiaoshishenqingUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiaoshishenqingUuidNumber = new ArrayList<>();
                                    jiaoshishenqingUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiaoshishenqingUuidNumber",jiaoshishenqingUuidNumber);
                                }
                        }

                        //查询是否重复
                         //申请编号
                        List<JiaoshishenqingEntity> jiaoshishenqingEntities_jiaoshishenqingUuidNumber = jiaoshishenqingService.selectList(new EntityWrapper<JiaoshishenqingEntity>().in("jiaoshishenqing_uuid_number", seachFields.get("jiaoshishenqingUuidNumber")));
                        if(jiaoshishenqingEntities_jiaoshishenqingUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiaoshishenqingEntity s:jiaoshishenqingEntities_jiaoshishenqingUuidNumber){
                                repeatFields.add(s.getJiaoshishenqingUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [申请编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiaoshishenqingService.insertBatch(jiaoshishenqingList);
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
