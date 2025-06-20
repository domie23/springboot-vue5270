
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
 * 物资
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fangyiwuzi")
public class FangyiwuziController {
    private static final Logger logger = LoggerFactory.getLogger(FangyiwuziController.class);

    private static final String TABLE_NAME = "fangyiwuzi";

    @Autowired
    private FangyiwuziService fangyiwuziService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    //注册表service
    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("fangyiwuziDeleteStart",1);params.put("fangyiwuziDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = fangyiwuziService.queryPage(params);

        //字典表数据转换
        List<FangyiwuziView> list =(List<FangyiwuziView>)page.getList();
        for(FangyiwuziView c:list){
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
        FangyiwuziEntity fangyiwuzi = fangyiwuziService.selectById(id);
        if(fangyiwuzi !=null){
            //entity转view
            FangyiwuziView view = new FangyiwuziView();
            BeanUtils.copyProperties( fangyiwuzi , view );//把实体数据重构到view中
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
    public R save(@RequestBody FangyiwuziEntity fangyiwuzi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangyiwuzi:{}",this.getClass().getName(),fangyiwuzi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<FangyiwuziEntity> queryWrapper = new EntityWrapper<FangyiwuziEntity>()
            .eq("fangyiwuzi_name", fangyiwuzi.getFangyiwuziName())
            .eq("fangyiwuzi_types", fangyiwuzi.getFangyiwuziTypes())
            .eq("fangyiwuzi_kucun_number", fangyiwuzi.getFangyiwuziKucunNumber())
            .eq("fangyiwuzi_delete", fangyiwuzi.getFangyiwuziDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangyiwuziEntity fangyiwuziEntity = fangyiwuziService.selectOne(queryWrapper);
        if(fangyiwuziEntity==null){
            fangyiwuzi.setFangyiwuziDelete(1);
            fangyiwuzi.setInsertTime(new Date());
            fangyiwuzi.setCreateTime(new Date());
            fangyiwuziService.insert(fangyiwuzi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangyiwuziEntity fangyiwuzi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,fangyiwuzi:{}",this.getClass().getName(),fangyiwuzi.toString());
        FangyiwuziEntity oldFangyiwuziEntity = fangyiwuziService.selectById(fangyiwuzi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<FangyiwuziEntity> queryWrapper = new EntityWrapper<FangyiwuziEntity>()
            .notIn("id",fangyiwuzi.getId())
            .andNew()
            .eq("fangyiwuzi_name", fangyiwuzi.getFangyiwuziName())
            .eq("fangyiwuzi_types", fangyiwuzi.getFangyiwuziTypes())
            .eq("fangyiwuzi_kucun_number", fangyiwuzi.getFangyiwuziKucunNumber())
            .eq("fangyiwuzi_delete", fangyiwuzi.getFangyiwuziDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangyiwuziEntity fangyiwuziEntity = fangyiwuziService.selectOne(queryWrapper);
        if("".equals(fangyiwuzi.getFangyiwuziPhoto()) || "null".equals(fangyiwuzi.getFangyiwuziPhoto())){
                fangyiwuzi.setFangyiwuziPhoto(null);
        }
        if(fangyiwuziEntity==null){
            fangyiwuziService.updateById(fangyiwuzi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<FangyiwuziEntity> oldFangyiwuziList =fangyiwuziService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<FangyiwuziEntity> list = new ArrayList<>();
        for(Integer id:ids){
            FangyiwuziEntity fangyiwuziEntity = new FangyiwuziEntity();
            fangyiwuziEntity.setId(id);
            fangyiwuziEntity.setFangyiwuziDelete(2);
            list.add(fangyiwuziEntity);
        }
        if(list != null && list.size() >0){
            fangyiwuziService.updateBatchById(list);
        }

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
            List<FangyiwuziEntity> fangyiwuziList = new ArrayList<>();//上传的东西
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
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            FangyiwuziEntity fangyiwuziEntity = new FangyiwuziEntity();
                            fangyiwuziEntity.setFangyiwuziUuidNumber(data.get(0));                    //物资编号 要改的
                            fangyiwuziEntity.setFangyiwuziName(data.get(1));                    //物资名称 要改的
                            fangyiwuziEntity.setFangyiwuziPhoto("");//详情和图片
                            fangyiwuziEntity.setFangyiwuziTypes(Integer.valueOf(data.get(2)));   //物资类型 要改的
                            fangyiwuziEntity.setFangyiwuziKucunNumber(Integer.valueOf(data.get(3)));   //物资库存 要改的
                            fangyiwuziEntity.setFangyiwuziContent("");//详情和图片
                            fangyiwuziEntity.setFangyiwuziDelete(1);//逻辑删除字段
                            fangyiwuziEntity.setInsertTime(date);//时间
                            fangyiwuziEntity.setCreateTime(date);//时间
                            fangyiwuziList.add(fangyiwuziEntity);


                            //把要查询是否重复的字段放入map中
                                //物资编号
                                if(seachFields.containsKey("fangyiwuziUuidNumber")){
                                    List<String> fangyiwuziUuidNumber = seachFields.get("fangyiwuziUuidNumber");
                                    fangyiwuziUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> fangyiwuziUuidNumber = new ArrayList<>();
                                    fangyiwuziUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("fangyiwuziUuidNumber",fangyiwuziUuidNumber);
                                }
                        }

                        //查询是否重复
                         //物资编号
                        List<FangyiwuziEntity> fangyiwuziEntities_fangyiwuziUuidNumber = fangyiwuziService.selectList(new EntityWrapper<FangyiwuziEntity>().in("fangyiwuzi_uuid_number", seachFields.get("fangyiwuziUuidNumber")).eq("fangyiwuzi_delete", 1));
                        if(fangyiwuziEntities_fangyiwuziUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FangyiwuziEntity s:fangyiwuziEntities_fangyiwuziUuidNumber){
                                repeatFields.add(s.getFangyiwuziUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [物资编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        fangyiwuziService.insertBatch(fangyiwuziList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = fangyiwuziService.queryPage(params);

        //字典表数据转换
        List<FangyiwuziView> list =(List<FangyiwuziView>)page.getList();
        for(FangyiwuziView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangyiwuziEntity fangyiwuzi = fangyiwuziService.selectById(id);
            if(fangyiwuzi !=null){


                //entity转view
                FangyiwuziView view = new FangyiwuziView();
                BeanUtils.copyProperties( fangyiwuzi , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody FangyiwuziEntity fangyiwuzi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fangyiwuzi:{}",this.getClass().getName(),fangyiwuzi.toString());
        Wrapper<FangyiwuziEntity> queryWrapper = new EntityWrapper<FangyiwuziEntity>()
            .eq("fangyiwuzi_uuid_number", fangyiwuzi.getFangyiwuziUuidNumber())
            .eq("fangyiwuzi_name", fangyiwuzi.getFangyiwuziName())
            .eq("fangyiwuzi_types", fangyiwuzi.getFangyiwuziTypes())
            .eq("fangyiwuzi_kucun_number", fangyiwuzi.getFangyiwuziKucunNumber())
            .eq("fangyiwuzi_delete", fangyiwuzi.getFangyiwuziDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangyiwuziEntity fangyiwuziEntity = fangyiwuziService.selectOne(queryWrapper);
        if(fangyiwuziEntity==null){
            fangyiwuzi.setFangyiwuziDelete(1);
            fangyiwuzi.setInsertTime(new Date());
            fangyiwuzi.setCreateTime(new Date());
        fangyiwuziService.insert(fangyiwuzi);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
