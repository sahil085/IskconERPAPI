package com.example.IskconErpAPI.services;

import com.example.IskconErpAPI.domain.Cities;
import com.example.IskconErpAPI.domain.States;
import com.example.IskconErpAPI.repository.CityRepo;
import com.example.IskconErpAPI.repository.StateRepo;
import com.example.IskconErpAPI.vo.CityVO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sahil on 1/12/18.
 */
@Service
public class CityService {

    @Autowired
    CityRepo cityRepo;

    @Autowired
    StateRepo stateRepo;

    public static final Logger logger = LoggerFactory.getLogger(CityService.class);

    public Cities findCityByName(String name){
        return cityRepo.findByName(name);
    }

    public List<CityVO> findAllByState(Long stateId) {
        States states = stateRepo.getOne(stateId);
        List<Cities> citiesList = cityRepo.findAllByState(states);
        ModelMapper modelMapper = new ModelMapper();
        CityVO cityVO[] = modelMapper.map(citiesList, CityVO[].class);
        return Arrays.asList(cityVO);
    }

}
