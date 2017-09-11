/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.allin.knowledge.business.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.allin.knowledge.business.service.KnowledgeCustomerAnswerService;
import com.allin.knowledge.model.Country;
import com.allin.knowledge.util.StringTool;
import com.comm.util.BaseResponseObject;
import net.sf.json.JSONArray;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author aubergine
 * @date 2017-9-5 21:04:14
 */
@RestController
@RequestMapping("/customer/answer")
public class KnowledgeCustomerAnswerController {

    @Autowired
    private KnowledgeCustomerAnswerService answerService;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public String getLists(@RequestParam Map paramMap) {
        List<Country> countryList = null;
        System.out.println("======" + paramMap);
        if (!paramMap.containsKey("firstResult")) {
            paramMap.put("firstResult", 0);
        } else {
            paramMap.put("firstResult", Integer.parseInt(paramMap.get("firstResult").toString()));
        }
        if (!paramMap.containsKey("maxResult")) {
            paramMap.put("maxResult", 10);
        } else {
            paramMap.put("maxResult", Integer.parseInt(paramMap.get("maxResult").toString()));

        }
        return JSON.toJSONString(answerService.getList(paramMap));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam("paramJson") String paramJson) {
        BaseResponseObject responseObject = new BaseResponseObject(Boolean.FALSE, "", "");
        JSONObject object = JSON.parseObject(paramJson);
        Object customerId = object.get("customerId");
        Object optionJson = object.get("optionJson");
        if (customerId == null) {
            responseObject.setResponseMessage("customerId不能为空");
            responseObject.setResponseStatus(true);
            return JSON.toJSONString(responseObject);
        }
        if (optionJson == null) {
            responseObject.setResponseMessage("optionJson不能为空");
            responseObject.setResponseStatus(true);
            return JSON.toJSONString(responseObject);
        }
        List<Map> optionList = null;
        optionList = JSONArray.fromObject(optionJson.toString());
        System.out.println("==========" + paramJson);
        Map saveMap;
        Map optionMap;
        int sortId = 0;
        Long examId = System.currentTimeMillis();
        if (!CollectionUtils.isEmpty(optionList)) {
            for (int i = 0; i < optionList.size(); i++) {
                saveMap = new HashMap();
                saveMap.put("sortId", sortId++);
                saveMap.put("customerId", customerId.toString());
                saveMap.put("answerId", System.currentTimeMillis());
                saveMap.put("examId", examId);
                optionMap = optionList.get(i);
                String materielId = StringTool.getMapString(optionMap, "materielId");
                String materielName = StringTool.getMapString(optionMap, "materielName");
                String optionId = StringTool.getMapString(optionMap, "optionId");
                String optionName = StringTool.getMapString(optionMap, "optionName");
                int isRightOption = 0;
                if (StringUtils.isNotEmpty(materielName) && StringUtils.isNotEmpty(optionName) && materielName.equalsIgnoreCase(optionName)) {
                    isRightOption = 1;
                }
                if (StringUtils.isNotEmpty(materielId) && StringUtils.isNotEmpty(optionId)) {
                    saveMap.put("materielId", materielId);
                    saveMap.put("materielName", materielName);
                    saveMap.put("optionId", optionId);
                    saveMap.put("optionName", optionName);
                    saveMap.put("isRightOption", isRightOption);
                    answerService.create(saveMap);
                }
            }
        }
        responseObject.setResponseMessage("SUCCESS");
        responseObject.setResponseStatus(true);
        return JSON.toJSONString(responseObject);
    }
}
