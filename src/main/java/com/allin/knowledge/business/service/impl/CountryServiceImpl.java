package com.allin.knowledge.business.service.impl;

import com.allin.knowledge.business.service.CountryService;
import com.allin.knowledge.mapper.CountryMapper;
import com.allin.knowledge.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author aubergine
 * @date 2017-9-5 21:04:14
 */
@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryMapper countryMapper;

    public List<Country> getList(Map paramMap) {
        return countryMapper.getList(paramMap);
    }

}
