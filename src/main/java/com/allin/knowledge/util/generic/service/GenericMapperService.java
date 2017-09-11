package com.allin.knowledge.util.generic.service;

import java.util.List;
import java.util.Map;

public interface GenericMapperService<T> {

    public Map getList(Map paramMap);

    public Map getById(long id);

    public Map getMapList(Map paramMap);

    public Map getMapById(long id);

    public Map create(Map paramMap);

    public Map update(Map paramMap);

    public Map getPageList(Map paramMap);

}
