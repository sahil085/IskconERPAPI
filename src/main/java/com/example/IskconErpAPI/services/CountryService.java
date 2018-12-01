package com.example.IskconErpAPI.services;

import com.example.IskconErpAPI.domain.Countries;
import com.example.IskconErpAPI.repository.CountryRepo;
import com.example.IskconErpAPI.vo.CountryVO;
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
public class CountryService {

    @Autowired
    CountryRepo countryRepo;

    public static final Logger logger = LoggerFactory.getLogger(CountryService.class);


    public Countries findByName(String name){
        return countryRepo.findByName(name);
    }

    public List<CountryVO> findAll() {
        List<Countries> countriesList = countryRepo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        CountryVO countryVO[] = modelMapper.map(countriesList, CountryVO[].class);
        return Arrays.asList(countryVO);
    }

}
