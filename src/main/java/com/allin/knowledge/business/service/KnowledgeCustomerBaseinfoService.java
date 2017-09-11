package com.allin.knowledge.business.service;

import com.allin.knowledge.model.KnowledgeCustomerBaseinfo;

import java.util.List;
import java.util.Map;

public interface KnowledgeCustomerBaseinfoService {

    public List<KnowledgeCustomerBaseinfo> getList(Map paramMap);

    public Map getMapList(Map paramJson);
}
