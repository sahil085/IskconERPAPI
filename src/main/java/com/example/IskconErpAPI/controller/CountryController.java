package com.example.IskconErpAPI.controller;

import com.example.IskconErpAPI.services.CountryService;
import com.example.IskconErpAPI.vo.CountryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sahil on 1/12/18.
 */
@CrossOrigin
@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/findAll")
    public List<CountryVO> findAll(){
        return countryService.findAll();
    }

}
