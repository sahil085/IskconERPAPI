package com.example.IskconErpAPI.controller;

import com.example.IskconErpAPI.services.StateService;
import com.example.IskconErpAPI.vo.StateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sahil on 1/12/18.
 */
@CrossOrigin
@RequestMapping("/state")
@RestController
public class StateController {

    @Autowired
    StateService stateService;

    @GetMapping("/findByCountry/{countryId}")
    public List<StateVO> findAllByCountry(@PathVariable("countryId") Long countryId){
        return stateService.findAllByCountry(countryId);
    }
}
