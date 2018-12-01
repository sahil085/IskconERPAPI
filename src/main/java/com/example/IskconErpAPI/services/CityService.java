package com.example.IskconErpAPI.services;

import com.example.IskconErpAPI.domain.Cities;
import com.example.IskconErpAPI.repository.CityRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sahil on 1/12/18.
 */
@Service
public class CityService {

    @Autowired
    CityRepo cityRepo;

    public static final Logger logger = LoggerFactory.getLogger(CityService.class);

    public Cities findCityByName(String name){
        return cityRepo.findByName(name);
    }


}
