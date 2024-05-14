
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
 * 学生申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xueshengshenqing")
public class XueshengshenqingController {
    private static final Logger logger = LoggerFactory.getLogger(XueshengshenqingController.class);

    @Autowired
    private XueshengshenqingService xueshengshenqingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private JiaoshishenqingService jiaoshishenqingService;
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
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("教师".equals(role))
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        else if("教材管理员".equals(role))
            params.put("jiaocaiguanliId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xueshengshenqingService.queryPage(params);

        //字典表数据转换
        List<XueshengshenqingView> list =(List<XueshengshenqingView>)page.getList();
        for(XueshengshenqingView c:list){
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
        XueshengshenqingEntity xueshengshenqing = xueshengshenqingService.selectById(id);
        if(xueshengshenqing !=null){
            //entity转view
            XueshengshenqingView view = new XueshengshenqingView();
            BeanUtils.copyProperties( xueshengshenqing , view );//把实体数据重构到view中

                //级联表
                JiaoshishenqingEntity jiaoshishenqing = jiaoshishenqingService.selectById(xueshengshenqing.getJiaoshishenqingId());
                if(jiaoshishenqing != null){
                    BeanUtils.copyProperties( jiaoshishenqing , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiaoshishenqingId(jiaoshishenqing.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(xueshengshenqing.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody XueshengshenqingEntity xueshengshenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xueshengshenqing:{}",this.getClass().getName(),xueshengshenqing.toString());

        JiaoshishenqingEntity jiaoshishenqingEntity = jiaoshishenqingService.selectById(xueshengshenqing.getJiaoshishenqingId());
        if(jiaoshishenqingEntity.getJiaoshishenqingNumber() < xueshengshenqing.getJiaoshishenqingNumber()){
            return R.error("教材数量不足");
        }
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            xueshengshenqing.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XueshengshenqingEntity> queryWrapper = new EntityWrapper<XueshengshenqingEntity>()
            .eq("jiaoshishenqing_id", xueshengshenqing.getJiaoshishenqingId())
            .eq("yonghu_id", xueshengshenqing.getYonghuId())
            .eq("jiaoshishenqing_number", xueshengshenqing.getJiaoshishenqingNumber())
            .eq("xueshengshenqing_yesno_types", xueshengshenqing.getXueshengshenqingYesnoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueshengshenqingEntity xueshengshenqingEntity = xueshengshenqingService.selectOne(queryWrapper);
        if(xueshengshenqingEntity==null){
            xueshengshenqing.setXueshengshenqingYesnoTypes(1);
            xueshengshenqing.setInsertTime(new Date());
            xueshengshenqing.setCreateTime(new Date());
            xueshengshenqingService.insert(xueshengshenqing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XueshengshenqingEntity xueshengshenqing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xueshengshenqing:{}",this.getClass().getName(),xueshengshenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            xueshengshenqing.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XueshengshenqingEntity> queryWrapper = new EntityWrapper<XueshengshenqingEntity>()
            .notIn("id",xueshengshenqing.getId())
            .andNew()
            .eq("jiaoshishenqing_id", xueshengshenqing.getJiaoshishenqingId())
            .eq("yonghu_id", xueshengshenqing.getYonghuId())
            .eq("jiaoshishenqing_number", xueshengshenqing.getJiaoshishenqingNumber())
            .eq("xueshengshenqing_yesno_types", xueshengshenqing.getXueshengshenqingYesnoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueshengshenqingEntity xueshengshenqingEntity = xueshengshenqingService.selectOne(queryWrapper);
        if(xueshengshenqingEntity==null){
            if(xueshengshenqing.getXueshengshenqingYesnoTypes() == 2){
                XueshengshenqingEntity xueshengshenqingEntity1 = xueshengshenqingService.selectById(xueshengshenqing.getId());
                JiaoshishenqingEntity jiaoshishenqingEntity = jiaoshishenqingService.selectById(xueshengshenqingEntity1.getJiaoshishenqingId());
                if(jiaoshishenqingEntity.getJiaoshishenqingNumber() <  xueshengshenqingEntity1.getJiaoshishenqingNumber()){
                    R.error("教材数量不足");
                }
                jiaoshishenqingEntity.setJiaoshishenqingNumber(jiaoshishenqingEntity.getJiaoshishenqingNumber() -  xueshengshenqingEntity1.getJiaoshishenqingNumber());
                jiaoshishenqingService.updateById(jiaoshishenqingEntity);
            }
            xueshengshenqingService.updateById(xueshengshenqing);//根据id更新
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
        xueshengshenqingService.deleteBatchIds(Arrays.asList(ids));
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
            List<XueshengshenqingEntity> xueshengshenqingList = new ArrayList<>();//上传的东西
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
                            XueshengshenqingEntity xueshengshenqingEntity = new XueshengshenqingEntity();
//                            xueshengshenqingEntity.setJiaoshishenqingId(Integer.valueOf(data.get(0)));   //教材 要改的
//                            xueshengshenqingEntity.setYonghuId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            xueshengshenqingEntity.setJiaoshishenqingNumber(Integer.valueOf(data.get(0)));   //申请数量 要改的
//                            xueshengshenqingEntity.setXueshengshenqingYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            xueshengshenqingEntity.setXueshengshenqingYesnoText(data.get(0));                    //申请结果 要改的
//                            xueshengshenqingEntity.setInsertTime(date);//时间
//                            xueshengshenqingEntity.setCreateTime(date);//时间
                            xueshengshenqingList.add(xueshengshenqingEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        xueshengshenqingService.insertBatch(xueshengshenqingList);
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
