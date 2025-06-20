
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
@RequestMapping("/fangyiwuziChuruInout")
public class FangyiwuziChuruInoutController {
    private static final Logger logger = LoggerFactory.getLogger(FangyiwuziChuruInoutController.class);

    private static final String TABLE_NAME = "fangyiwuziChuruInout";

    @Autowired
    private FangyiwuziChuruInoutService fangyiwuziChuruInoutService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    //有list表
    @Autowired
    private FangyiwuziChuruInoutListService fangyiwuziChuruInoutListService;
    @Autowired
    private FangyiwuziService fangyiwuziService;
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
        CommonUtil.checkMap(params);
        PageUtils page = fangyiwuziChuruInoutService.queryPage(params);

        //字典表数据转换
        List<FangyiwuziChuruInoutView> list =(List<FangyiwuziChuruInoutView>)page.getList();
        for(FangyiwuziChuruInoutView c:list){
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
        FangyiwuziChuruInoutEntity fangyiwuziChuruInout = fangyiwuziChuruInoutService.selectById(id);
        if(fangyiwuziChuruInout !=null){
            //entity转view
            FangyiwuziChuruInoutView view = new FangyiwuziChuruInoutView();
            BeanUtils.copyProperties( fangyiwuziChuruInout , view );//把实体数据重构到view中
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
    public R save(@RequestBody FangyiwuziChuruInoutEntity fangyiwuziChuruInout, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangyiwuziChuruInout:{}",this.getClass().getName(),fangyiwuziChuruInout.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<FangyiwuziChuruInoutEntity> queryWrapper = new EntityWrapper<FangyiwuziChuruInoutEntity>()
            .eq("fangyiwuzi_churu_inout_name", fangyiwuziChuruInout.getFangyiwuziChuruInoutName())
            .eq("fangyiwuzi_churu_inout_types", fangyiwuziChuruInout.getFangyiwuziChuruInoutTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangyiwuziChuruInoutEntity fangyiwuziChuruInoutEntity = fangyiwuziChuruInoutService.selectOne(queryWrapper);
        if(fangyiwuziChuruInoutEntity==null){
            fangyiwuziChuruInout.setInsertTime(new Date());
            fangyiwuziChuruInout.setCreateTime(new Date());
            fangyiwuziChuruInoutService.insert(fangyiwuziChuruInout);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangyiwuziChuruInoutEntity fangyiwuziChuruInout, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,fangyiwuziChuruInout:{}",this.getClass().getName(),fangyiwuziChuruInout.toString());
        FangyiwuziChuruInoutEntity oldFangyiwuziChuruInoutEntity = fangyiwuziChuruInoutService.selectById(fangyiwuziChuruInout.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<FangyiwuziChuruInoutEntity> queryWrapper = new EntityWrapper<FangyiwuziChuruInoutEntity>()
            .notIn("id",fangyiwuziChuruInout.getId())
            .andNew()
            .eq("fangyiwuzi_churu_inout_name", fangyiwuziChuruInout.getFangyiwuziChuruInoutName())
            .eq("fangyiwuzi_churu_inout_types", fangyiwuziChuruInout.getFangyiwuziChuruInoutTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangyiwuziChuruInoutEntity fangyiwuziChuruInoutEntity = fangyiwuziChuruInoutService.selectOne(queryWrapper);
        if(fangyiwuziChuruInoutEntity==null){
            fangyiwuziChuruInoutService.updateById(fangyiwuziChuruInout);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 出库
    */
    @RequestMapping("/outFangyiwuziChuruInoutList")
    public R outFangyiwuziChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("outFangyiwuziChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取出入库名称并判断是否存在
        String fangyiwuziChuruInoutName = String.valueOf(params.get("fangyiwuziChuruInoutName"));
        Wrapper<FangyiwuziChuruInoutEntity> queryWrapper = new EntityWrapper<FangyiwuziChuruInoutEntity>()
            .eq("fangyiwuzi_churu_inout_name", fangyiwuziChuruInoutName)
            ;
        FangyiwuziChuruInoutEntity fangyiwuziChuruInoutSelectOne = fangyiwuziChuruInoutService.selectOne(queryWrapper);
        if(fangyiwuziChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");



        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");


        Set<String> ids = map.keySet();

        List<FangyiwuziEntity> fangyiwuziList = fangyiwuziService.selectBatchIds(ids);
        if(fangyiwuziList == null || fangyiwuziList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(FangyiwuziEntity w:fangyiwuziList){
                Integer value = w.getFangyiwuziKucunNumber()-map.get(String.valueOf(w.getId()));
                if(value <0){
                    return R.error(511,"出库数量大于库存数量");
                }
                w.setFangyiwuziKucunNumber(value);
            }
        }

        //当前表
        FangyiwuziChuruInoutEntity fangyiwuziChuruInoutEntity = new FangyiwuziChuruInoutEntity<>();
            fangyiwuziChuruInoutEntity.setFangyiwuziChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            fangyiwuziChuruInoutEntity.setFangyiwuziChuruInoutName(fangyiwuziChuruInoutName);
            fangyiwuziChuruInoutEntity.setFangyiwuziChuruInoutTypes(1);
            fangyiwuziChuruInoutEntity.setFangyiwuziChuruInoutContent("");
            fangyiwuziChuruInoutEntity.setInsertTime(new Date());
            fangyiwuziChuruInoutEntity.setCreateTime(new Date());

        boolean insertFangyiwuziChuruInout = fangyiwuziChuruInoutService.insert(fangyiwuziChuruInoutEntity);
        //list表
        ArrayList<FangyiwuziChuruInoutListEntity> fangyiwuziChuruInoutLists = new ArrayList<>();
        if(insertFangyiwuziChuruInout){
            for(String id:ids){
                FangyiwuziChuruInoutListEntity fangyiwuziChuruInoutListEntity = new FangyiwuziChuruInoutListEntity();
                    fangyiwuziChuruInoutListEntity.setFangyiwuziChuruInoutId(fangyiwuziChuruInoutEntity.getId());
                    fangyiwuziChuruInoutListEntity.setFangyiwuziId(Integer.valueOf(id));
                    fangyiwuziChuruInoutListEntity.setFangyiwuziChuruInoutListNumber(map.get(id));
                    fangyiwuziChuruInoutListEntity.setInsertTime(new Date());
                    fangyiwuziChuruInoutListEntity.setCreateTime(new Date());
                fangyiwuziChuruInoutLists.add(fangyiwuziChuruInoutListEntity);
                fangyiwuziService.updateBatchById(fangyiwuziList);
            }
            fangyiwuziChuruInoutListService.insertBatch(fangyiwuziChuruInoutLists);
        }

        return R.ok();
    }

    /**
    *入库
    */
    @RequestMapping("/inFangyiwuziChuruInoutList")
    public R inFangyiwuziChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("inFangyiwuziChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        //params:{"map":{"1":2,"2":3},"wuziOutinName":"订单1"}

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取当前表名称并判断
        String fangyiwuziChuruInoutName = String.valueOf(params.get("fangyiwuziChuruInoutName"));
        Wrapper<FangyiwuziChuruInoutEntity> queryWrapper = new EntityWrapper<FangyiwuziChuruInoutEntity>()
            .eq("fangyiwuzi_churu_inout_name", fangyiwuziChuruInoutName)
            ;
        FangyiwuziChuruInoutEntity fangyiwuziChuruInoutSelectOne = fangyiwuziChuruInoutService.selectOne(queryWrapper);
        if(fangyiwuziChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");


        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");

        Set<String> ids = map.keySet();

        List<FangyiwuziEntity> fangyiwuziList = fangyiwuziService.selectBatchIds(ids);
        if(fangyiwuziList == null || fangyiwuziList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(FangyiwuziEntity w:fangyiwuziList){
                w.setFangyiwuziKucunNumber(w.getFangyiwuziKucunNumber()+map.get(String.valueOf(w.getId())));
            }
        }

        //当前表
        FangyiwuziChuruInoutEntity fangyiwuziChuruInoutEntity = new FangyiwuziChuruInoutEntity<>();
            fangyiwuziChuruInoutEntity.setFangyiwuziChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            fangyiwuziChuruInoutEntity.setFangyiwuziChuruInoutName(fangyiwuziChuruInoutName);
            fangyiwuziChuruInoutEntity.setFangyiwuziChuruInoutTypes(2);
            fangyiwuziChuruInoutEntity.setFangyiwuziChuruInoutContent("");
            fangyiwuziChuruInoutEntity.setInsertTime(new Date());
            fangyiwuziChuruInoutEntity.setCreateTime(new Date());


        boolean insertFangyiwuziChuruInout = fangyiwuziChuruInoutService.insert(fangyiwuziChuruInoutEntity);
        //list表
        ArrayList<FangyiwuziChuruInoutListEntity> fangyiwuziChuruInoutLists = new ArrayList<>();
        if(insertFangyiwuziChuruInout){
            for(String id:ids){
                FangyiwuziChuruInoutListEntity fangyiwuziChuruInoutListEntity = new FangyiwuziChuruInoutListEntity();
                fangyiwuziChuruInoutListEntity.setFangyiwuziChuruInoutId(fangyiwuziChuruInoutEntity.getId());
                fangyiwuziChuruInoutListEntity.setFangyiwuziId(Integer.valueOf(id));
                fangyiwuziChuruInoutListEntity.setFangyiwuziChuruInoutListNumber(map.get(id));
                fangyiwuziChuruInoutListEntity.setInsertTime(new Date());
                fangyiwuziChuruInoutListEntity.setCreateTime(new Date());
                fangyiwuziChuruInoutLists.add(fangyiwuziChuruInoutListEntity);
                fangyiwuziService.updateBatchById(fangyiwuziList);
            }
            fangyiwuziChuruInoutListService.insertBatch(fangyiwuziChuruInoutLists);
        }

        return R.ok();
    }
    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<FangyiwuziChuruInoutEntity> oldFangyiwuziChuruInoutList =fangyiwuziChuruInoutService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        fangyiwuziChuruInoutService.deleteBatchIds(Arrays.asList(ids));
        fangyiwuziChuruInoutListService.delete(new EntityWrapper<FangyiwuziChuruInoutListEntity>().in("fangyiwuzi_churu_inout_id",ids));

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
            List<FangyiwuziChuruInoutEntity> fangyiwuziChuruInoutList = new ArrayList<>();//上传的东西
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
                            FangyiwuziChuruInoutEntity fangyiwuziChuruInoutEntity = new FangyiwuziChuruInoutEntity();
//                            fangyiwuziChuruInoutEntity.setFangyiwuziChuruInoutUuidNumber(data.get(0));                    //出入库流水号 要改的
//                            fangyiwuziChuruInoutEntity.setFangyiwuziChuruInoutName(data.get(0));                    //出入库名称 要改的
//                            fangyiwuziChuruInoutEntity.setFangyiwuziChuruInoutTypes(Integer.valueOf(data.get(0)));   //出入库类型 要改的
//                            fangyiwuziChuruInoutEntity.setFangyiwuziChuruInoutContent("");//详情和图片
//                            fangyiwuziChuruInoutEntity.setInsertTime(date);//时间
//                            fangyiwuziChuruInoutEntity.setCreateTime(date);//时间
                            fangyiwuziChuruInoutList.add(fangyiwuziChuruInoutEntity);


                            //把要查询是否重复的字段放入map中
                                //出入库流水号
                                if(seachFields.containsKey("fangyiwuziChuruInoutUuidNumber")){
                                    List<String> fangyiwuziChuruInoutUuidNumber = seachFields.get("fangyiwuziChuruInoutUuidNumber");
                                    fangyiwuziChuruInoutUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> fangyiwuziChuruInoutUuidNumber = new ArrayList<>();
                                    fangyiwuziChuruInoutUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("fangyiwuziChuruInoutUuidNumber",fangyiwuziChuruInoutUuidNumber);
                                }
                        }

                        //查询是否重复
                         //出入库流水号
                        List<FangyiwuziChuruInoutEntity> fangyiwuziChuruInoutEntities_fangyiwuziChuruInoutUuidNumber = fangyiwuziChuruInoutService.selectList(new EntityWrapper<FangyiwuziChuruInoutEntity>().in("fangyiwuzi_churu_inout_uuid_number", seachFields.get("fangyiwuziChuruInoutUuidNumber")));
                        if(fangyiwuziChuruInoutEntities_fangyiwuziChuruInoutUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FangyiwuziChuruInoutEntity s:fangyiwuziChuruInoutEntities_fangyiwuziChuruInoutUuidNumber){
                                repeatFields.add(s.getFangyiwuziChuruInoutUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [出入库流水号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        fangyiwuziChuruInoutService.insertBatch(fangyiwuziChuruInoutList);
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
        PageUtils page = fangyiwuziChuruInoutService.queryPage(params);

        //字典表数据转换
        List<FangyiwuziChuruInoutView> list =(List<FangyiwuziChuruInoutView>)page.getList();
        for(FangyiwuziChuruInoutView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangyiwuziChuruInoutEntity fangyiwuziChuruInout = fangyiwuziChuruInoutService.selectById(id);
            if(fangyiwuziChuruInout !=null){


                //entity转view
                FangyiwuziChuruInoutView view = new FangyiwuziChuruInoutView();
                BeanUtils.copyProperties( fangyiwuziChuruInout , view );//把实体数据重构到view中

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
    public R add(@RequestBody FangyiwuziChuruInoutEntity fangyiwuziChuruInout, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fangyiwuziChuruInout:{}",this.getClass().getName(),fangyiwuziChuruInout.toString());
        Wrapper<FangyiwuziChuruInoutEntity> queryWrapper = new EntityWrapper<FangyiwuziChuruInoutEntity>()
            .eq("fangyiwuzi_churu_inout_uuid_number", fangyiwuziChuruInout.getFangyiwuziChuruInoutUuidNumber())
            .eq("fangyiwuzi_churu_inout_name", fangyiwuziChuruInout.getFangyiwuziChuruInoutName())
            .eq("fangyiwuzi_churu_inout_types", fangyiwuziChuruInout.getFangyiwuziChuruInoutTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangyiwuziChuruInoutEntity fangyiwuziChuruInoutEntity = fangyiwuziChuruInoutService.selectOne(queryWrapper);
        if(fangyiwuziChuruInoutEntity==null){
            fangyiwuziChuruInout.setInsertTime(new Date());
            fangyiwuziChuruInout.setCreateTime(new Date());
        fangyiwuziChuruInoutService.insert(fangyiwuziChuruInout);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
