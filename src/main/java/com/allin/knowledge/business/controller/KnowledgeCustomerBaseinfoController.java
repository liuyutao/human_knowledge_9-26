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
import com.allin.knowledge.business.service.KnowledgeCustomerBaseinfoService;
import com.allin.knowledge.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author aubergine
 * @date 2017-9-5 21:04:14
 */
@RestController
    @RequestMapping("/customer/baseinfo")
public class KnowledgeCustomerBaseinfoController {

    @Autowired
    private KnowledgeCustomerBaseinfoService baseinfoService;

    @RequestMapping(value = "/getLists", method = RequestMethod.GET)
    public String getLists(@RequestParam Map paramMap) {
        List<Country> countryList = null;
        System.out.println("======" + paramMap);
        if (!paramMap.containsKey("firstResult")) {
            paramMap.put("firstResult", 0);
        }else{
            paramMap.put("firstResult", Integer.parseInt(paramMap.get("firstResult").toString()));
        }
        if (!paramMap.containsKey("maxResult")) {
            paramMap.put("maxResult", 10);
        }else{
            paramMap.put("maxResult", Integer.parseInt(paramMap.get("maxResult").toString()));

        }
        return JSON.toJSONString(baseinfoService.getList(paramMap));
    }

    @RequestMapping(value = "/getMapList", method = RequestMethod.GET)
    public String getMapList(@RequestParam Map paramJson) {
        System.out.println("======" + paramJson);
        String string = JSON.toJSONString(baseinfoService.getMapList(paramJson));
        System.out.println(string);
        return string;
    }
}
