package com.haol.postman.controller;

import com.alibaba.fastjson.JSONArray;
import com.haol.postman.enmu.HttpType;
import com.haol.postman.po.ResponseMap;
import com.haol.postman.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
@RequestMapping("/http")
public class HttpController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/postman")
    public String toPage(){
        return "/postman";
    }


    @RequestMapping(value = "/http_client", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMap httpClient(@RequestParam(name = "httpType") String httpType,
                                  @RequestParam(name = "httpUrl") String httpUrl,
                                  @RequestParam(name = "httpParam")String httpParam,
                                  @RequestParam(name = "httpBody" ,required = false) String httpBody,
                                  @RequestParam(name = "httpHeader", required = false)String httpHeader){
        //处理请求头参数
        Map<String, String> headerMap = new HashMap<>();

        if (httpHeader != null || httpHeader != ""){
            JSONArray jsonArray = JSONArray.parseArray(httpHeader);

            for (int i = 0; i<jsonArray.size(); i++){
                JSONArray jsonArray1 = JSONArray.parseArray(jsonArray.get(i).toString());
                if (jsonArray1.getString(0).equals("") && jsonArray1.getString(1).equals("")){
                    System.out.println("为空，跳出循环");
                    break;
                }else{
                    headerMap.put(jsonArray1.getString(0), jsonArray1.getString(1));
                }
            }
        }

        String result;
        switch (HttpType.getByName(httpType)){
            case GET:
                logger.info("执行GET方法");
                result = HttpUtils.doGet(httpUrl+httpParam, headerMap);
                break;
            case POST:
                logger.info("执行POST方法");
                result = HttpUtils.doPost(httpUrl+httpParam, new HashMap<>(), headerMap, httpBody);
                break;
            case PUT:
                logger.info("执行PUT方法");
                result = HttpUtils.doPut(httpUrl+httpParam, headerMap, httpBody );
                break;
            case DELETE:
                logger.info("执行DELETE方法");
                result = HttpUtils.doDelete(httpUrl+httpParam, headerMap, httpBody, null);
                break;
            default:
                logger.info("执行其他方法");
                result = "没有该方法";
                break;
        }

        logger.info("请求类型：" + httpType);
        logger.info("请求地址：" + httpUrl);
        logger.info("请求参数：" + httpParam);
        logger.info("请求体:" + httpBody);
        logger.info("请求头:" + headerMap);
        logger.info(result);
        return new ResponseMap(result);
    }
}
