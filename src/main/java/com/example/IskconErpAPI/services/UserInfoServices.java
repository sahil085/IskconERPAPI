package com.example.IskconErpAPI.services;

import com.example.IskconErpAPI.co.UserInfoCO;
import com.example.IskconErpAPI.common.CommonResponseVO;
import com.example.IskconErpAPI.domain.Cities;
import com.example.IskconErpAPI.domain.Countries;
import com.example.IskconErpAPI.domain.States;
import com.example.IskconErpAPI.domain.UserInfo;
import com.example.IskconErpAPI.repository.CityRepo;
import com.example.IskconErpAPI.repository.CountryRepo;
import com.example.IskconErpAPI.repository.StateRepo;
import com.example.IskconErpAPI.repository.UserInfoRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sahil on 1/12/18.
 */
@Service
public class UserInfoServices {

    @Autowired
    CountryRepo countryRepo;

    @Autowired
    StateRepo stateRepo;

    @Autowired
    CityRepo cityRepo;

    @Autowired
    UserInfoRepo userInfoRepo;

    public static final Logger logger = LoggerFactory.getLogger(UserInfoServices.class);

    public CommonResponseVO createNewUser(UserInfoCO userInfoCO) {
        try{
            UserInfo userInfo = new UserInfo();
            Cities city = cityRepo.getOne(userInfoCO.getCityId());
            userInfo.setCity(city);
            States state = stateRepo.getOne(userInfoCO.getStateId());
            userInfo.setState(state);
            Countries country = countryRepo.getOne(userInfoCO.getCountryId());
            userInfo.setCountry(country);
            userInfo.setCurrentAddress(userInfoCO.getCurrentAddress());
            userInfo.setMobileNumber(userInfoCO.getMobileNumber());
            userInfo.setPermanentAddress(userInfoCO.getPermanentAddress());
            userInfo.setName(userInfoCO.getName());

            userInfoRepo.saveAndFlush(userInfo);

            return CommonResponseVO.successResponse("Details Saved Successfully");

        }catch (Exception e){
            logger.error(e.getMessage());
            throw new RuntimeException("Error in saving details");
        }
    }

}
