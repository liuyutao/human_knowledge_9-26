package com.allin.knowledge.util.generic.service.impl;

import com.allin.knowledge.util.StringTool;
import com.allin.knowledge.util.generic.dao.GenericMapperDAO;
import com.comm.util.page.Page;

import java.util.List;
import java.util.Map;

public class GenericMapperServiceImpl<T1 extends GenericMapperDAO<?>, T2> {

    // 实体类类型(由构造方法自动赋值)
    private Class<T1> mapperClass;
    private GenericMapperDAO genericMapperDAO;

    // 构造方法，根据实例类自动获取实体类类型
    public GenericMapperServiceImpl(Class<T1> mapperClass) {
        this.mapperClass = mapperClass;
    }

    private void buildMapperObject() {
        try {
//			SqlSessionFactory sessionFactory = MyBatisConfig.sqlSessionFactory
//					.getObject();//
//			SqlSession session = SqlSessionUtils.getSqlSession(sessionFactory);

//			genericMapperDAO = 	MyBatisConfig.SqlSessionTemplate.getMapper(mapperClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private GenericMapperDAO<?> getGenericMapperDAO() {
        if (genericMapperDAO == null) {
            buildMapperObject();
        }
        return genericMapperDAO;
    }

    @SuppressWarnings("unchecked")
    public List<T2> getList(Map paramMap) {
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
        return (List<T2>) getGenericMapperDAO().getList(paramMap);
    }


    /***************可以自行拓展的方法****************/
    @SuppressWarnings("unchecked")
    public T2 getById(long id) {
        return (T2) getGenericMapperDAO().getById(id);
    }

    public long create(Map paramMap) {
        /*存储原来ID的值*/
        String id = StringTool.getMapString(paramMap, "id");
        getGenericMapperDAO().insert(paramMap);
		/*存储被覆盖后ID的值*/
        String keyId = StringTool.getMapString(paramMap, "id");
        paramMap.put("id", id);
        long resultKey = StringTool.isStringEmpty(keyId) ? 0 : Long.parseLong(keyId);
        return resultKey;

    }

    public void update(Map paramMap) {
        getGenericMapperDAO().update(paramMap);
    }

    public int getCount(Map paramMap) {
        return getGenericMapperDAO().getCount(paramMap);
    }

    public Page getPageList(Map paramMap) {

        Page pageObj = new Page(1, 10);
        pageObj.setItems(getList(paramMap));
        pageObj.setTotal(getCount(paramMap));

        return pageObj;

    }

}
