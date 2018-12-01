package com.example.IskconErpAPI.controller;

import com.example.IskconErpAPI.services.CityService;
import com.example.IskconErpAPI.vo.CityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sahil on 1/12/18.
 */
@CrossOrigin
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/findByState/{stateId}")
    public List<CityVO> findAllByState(@PathVariable("stateId") Long stateId) {
        return cityService.findAllByState(stateId);
    }
}
