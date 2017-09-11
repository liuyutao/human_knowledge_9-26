package com.allin.knowledge.business.service.impl;

import com.allin.knowledge.business.service.KnowledgeCustomerAnswerService;
import com.allin.knowledge.mapper.KnowledgeCustomerAnswerMapper;
import com.allin.knowledge.model.KnowledgeCustomerAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author aubergine
 * @date 2017-9-5 21:04:14
 */
@Service
public class KnowledgeCustomerAnswerServiceImpl implements KnowledgeCustomerAnswerService{

    @Autowired
    private KnowledgeCustomerAnswerMapper answerMapper;

    public List<KnowledgeCustomerAnswer> getList(Map paramMap) {
        return answerMapper.getList(paramMap);
    }

    @Override
    public long create(Map paramMap) {
        return answerMapper.inserts(paramMap);
    }
}
