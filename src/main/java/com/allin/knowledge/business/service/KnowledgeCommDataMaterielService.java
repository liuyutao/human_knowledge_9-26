package com.allin.knowledge.business.service;

import com.allin.knowledge.model.KnowledgeCommDataMateriel;

import java.util.List;
import java.util.Map;

public interface KnowledgeCommDataMaterielService {

    public List<KnowledgeCommDataMateriel> getLists(Map paramMap);

    public Map getMapList(Map paramJson);
}
