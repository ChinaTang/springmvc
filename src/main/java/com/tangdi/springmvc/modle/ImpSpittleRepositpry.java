package com.tangdi.springmvc.modle;

import com.tangdi.springmvc.Spittle;
import com.tangdi.springmvc.controller.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ImpSpittleRepositpry implements SpittleRepository {

    @Autowired
    public ImpSpittleRepositpry(){

    }

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }
}
