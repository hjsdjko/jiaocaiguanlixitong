
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
 * 教材管理员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiaocaiguanli")
public class JiaocaiguanliController {
    private static final Logger logger = LoggerFactory.getLogger(JiaocaiguanliController.class);

    @Autowired
    private JiaocaiguanliService jiaocaiguanliService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private JiaoshiService jiaoshiService;


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
        PageUtils page = jiaocaiguanliService.queryPage(params);

        //字典表数据转换
        List<JiaocaiguanliView> list =(List<JiaocaiguanliView>)page.getList();
        for(JiaocaiguanliView c:list){
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
        JiaocaiguanliEntity jiaocaiguanli = jiaocaiguanliService.selectById(id);
        if(jiaocaiguanli !=null){
            //entity转view
            JiaocaiguanliView view = new JiaocaiguanliView();
            BeanUtils.copyProperties( jiaocaiguanli , view );//把实体数据重构到view中

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
    public R save(@RequestBody JiaocaiguanliEntity jiaocaiguanli, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiaocaiguanli:{}",this.getClass().getName(),jiaocaiguanli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JiaocaiguanliEntity> queryWrapper = new EntityWrapper<JiaocaiguanliEntity>()
            .eq("username", jiaocaiguanli.getUsername())
            .or()
            .eq("jiaocaiguanli_phone", jiaocaiguanli.getJiaocaiguanliPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaocaiguanliEntity jiaocaiguanliEntity = jiaocaiguanliService.selectOne(queryWrapper);
        if(jiaocaiguanliEntity==null){
            jiaocaiguanli.setCreateTime(new Date());
            jiaocaiguanli.setPassword("123456");
            jiaocaiguanliService.insert(jiaocaiguanli);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaocaiguanliEntity jiaocaiguanli, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiaocaiguanli:{}",this.getClass().getName(),jiaocaiguanli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<JiaocaiguanliEntity> queryWrapper = new EntityWrapper<JiaocaiguanliEntity>()
            .notIn("id",jiaocaiguanli.getId())
            .andNew()
            .eq("username", jiaocaiguanli.getUsername())
            .or()
            .eq("jiaocaiguanli_phone", jiaocaiguanli.getJiaocaiguanliPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaocaiguanliEntity jiaocaiguanliEntity = jiaocaiguanliService.selectOne(queryWrapper);
        if(jiaocaiguanliEntity==null){
            jiaocaiguanliService.updateById(jiaocaiguanli);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jiaocaiguanliService.deleteBatchIds(Arrays.asList(ids));
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
            List<JiaocaiguanliEntity> jiaocaiguanliList = new ArrayList<>();//上传的东西
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
                            JiaocaiguanliEntity jiaocaiguanliEntity = new JiaocaiguanliEntity();
//                            jiaocaiguanliEntity.setUsername(data.get(0));                    //账户 要改的
//                            //jiaocaiguanliEntity.setPassword("123456");//密码
//                            jiaocaiguanliEntity.setJiaocaiguanliName(data.get(0));                    //教材管理员姓名 要改的
//                            jiaocaiguanliEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            jiaocaiguanliEntity.setJiaocaiguanliPhone(data.get(0));                    //联系方式 要改的
//                            jiaocaiguanliEntity.setCreateTime(date);//时间
                            jiaocaiguanliList.add(jiaocaiguanliEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //联系方式
                                if(seachFields.containsKey("jiaocaiguanliPhone")){
                                    List<String> jiaocaiguanliPhone = seachFields.get("jiaocaiguanliPhone");
                                    jiaocaiguanliPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> jiaocaiguanliPhone = new ArrayList<>();
                                    jiaocaiguanliPhone.add(data.get(0));//要改的
                                    seachFields.put("jiaocaiguanliPhone",jiaocaiguanliPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<JiaocaiguanliEntity> jiaocaiguanliEntities_username = jiaocaiguanliService.selectList(new EntityWrapper<JiaocaiguanliEntity>().in("username", seachFields.get("username")));
                        if(jiaocaiguanliEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiaocaiguanliEntity s:jiaocaiguanliEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //联系方式
                        List<JiaocaiguanliEntity> jiaocaiguanliEntities_jiaocaiguanliPhone = jiaocaiguanliService.selectList(new EntityWrapper<JiaocaiguanliEntity>().in("jiaocaiguanli_phone", seachFields.get("jiaocaiguanliPhone")));
                        if(jiaocaiguanliEntities_jiaocaiguanliPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiaocaiguanliEntity s:jiaocaiguanliEntities_jiaocaiguanliPhone){
                                repeatFields.add(s.getJiaocaiguanliPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiaocaiguanliService.insertBatch(jiaocaiguanliList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        JiaocaiguanliEntity jiaocaiguanli = jiaocaiguanliService.selectOne(new EntityWrapper<JiaocaiguanliEntity>().eq("username", username));
        if(jiaocaiguanli==null || !jiaocaiguanli.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(jiaocaiguanli.getId(),username, "jiaocaiguanli", "教材管理员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","教材管理员");
        r.put("username",jiaocaiguanli.getJiaocaiguanliName());
        r.put("tableName","jiaocaiguanli");
        r.put("userId",jiaocaiguanli.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody JiaocaiguanliEntity jiaocaiguanli){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<JiaocaiguanliEntity> queryWrapper = new EntityWrapper<JiaocaiguanliEntity>()
            .eq("username", jiaocaiguanli.getUsername())
            .or()
            .eq("jiaocaiguanli_phone", jiaocaiguanli.getJiaocaiguanliPhone())
            ;
        JiaocaiguanliEntity jiaocaiguanliEntity = jiaocaiguanliService.selectOne(queryWrapper);
        if(jiaocaiguanliEntity != null)
            return R.error("账户或者联系方式已经被使用");
        jiaocaiguanli.setCreateTime(new Date());
        jiaocaiguanliService.insert(jiaocaiguanli);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        JiaocaiguanliEntity jiaocaiguanli = new JiaocaiguanliEntity();
        jiaocaiguanli.setPassword("123456");
        jiaocaiguanli.setId(id);
        jiaocaiguanliService.updateById(jiaocaiguanli);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        JiaocaiguanliEntity jiaocaiguanli = jiaocaiguanliService.selectOne(new EntityWrapper<JiaocaiguanliEntity>().eq("username", username));
        if(jiaocaiguanli!=null){
            jiaocaiguanli.setPassword("123456");
            boolean b = jiaocaiguanliService.updateById(jiaocaiguanli);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrJiaocaiguanli(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        JiaocaiguanliEntity jiaocaiguanli = jiaocaiguanliService.selectById(id);
        if(jiaocaiguanli !=null){
            //entity转view
            JiaocaiguanliView view = new JiaocaiguanliView();
            BeanUtils.copyProperties( jiaocaiguanli , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
