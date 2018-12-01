package com.example.IskconErpAPI.services;

import com.example.IskconErpAPI.domain.Countries;
import com.example.IskconErpAPI.domain.States;
import com.example.IskconErpAPI.repository.CountryRepo;
import com.example.IskconErpAPI.repository.StateRepo;
import com.example.IskconErpAPI.vo.StateVO;
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
public class StateService {

    public static final Logger logger = LoggerFactory.getLogger(StateService.class);

    @Autowired
    StateRepo stateRepo;

    @Autowired
    CountryRepo countryRepo;

    public States findByName(String name){
        return stateRepo.findByName(name);
    }

    public List<StateVO> findAllByCountry(Long countryId) {
        Countries countries = countryRepo.getOne(countryId);
        List<States> statesList = stateRepo.findAllByCountry(countries);
        ModelMapper modelMapper = new ModelMapper();
        StateVO stateVO[]= modelMapper.map(statesList, StateVO[].class);
        return Arrays.asList(stateVO);
    }

}
