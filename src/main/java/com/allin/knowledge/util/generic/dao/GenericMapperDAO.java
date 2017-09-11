package com.allin.knowledge.util.generic.dao;

import java.util.List;
import java.util.Map;

import com.allin.knowledge.util.BaseForm;

public interface GenericMapperDAO<T extends BaseForm> {

    long insert(Map paramMap);

    void update(Map paramMap);

    List<T> getList(Map paramMap);

    T getById(long key);

    int getCount(Map paramMap);
}
