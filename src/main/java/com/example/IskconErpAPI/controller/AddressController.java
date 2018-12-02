package com.example.IskconErpAPI.controller;

import com.example.IskconErpAPI.services.AddressService;
import com.example.IskconErpAPI.vo.AddressListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sahil on 2/12/18.
 */
@CrossOrigin
@RestController
@RequestMapping("/address")
public class AddressController {


    @Autowired
    AddressService addressService;

    @GetMapping("/list")
    public List<AddressListVO> getAllAddress() {
        return addressService.getAddressList();
    }
}
