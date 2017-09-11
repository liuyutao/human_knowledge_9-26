package com.allin.knowledge.business.service;

import com.allin.knowledge.model.KnowledgeCustomerAnswer;

import java.util.List;
import java.util.Map;

public interface KnowledgeCustomerAnswerService {

    public List<KnowledgeCustomerAnswer> getList(Map paramMap);

    long create(Map paramMap);

}
