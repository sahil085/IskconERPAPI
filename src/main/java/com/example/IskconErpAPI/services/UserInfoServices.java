package com.example.IskconErpAPI.services;

import com.example.IskconErpAPI.co.UserInfoCO;
import com.example.IskconErpAPI.co.UserInfoSearchCO;
import com.example.IskconErpAPI.common.CommonResponseVO;
import com.example.IskconErpAPI.domain.Cities;
import com.example.IskconErpAPI.domain.Countries;
import com.example.IskconErpAPI.domain.States;
import com.example.IskconErpAPI.domain.UserInfo;
import com.example.IskconErpAPI.repository.CityRepo;
import com.example.IskconErpAPI.repository.CountryRepo;
import com.example.IskconErpAPI.repository.StateRepo;
import com.example.IskconErpAPI.repository.UserInfoRepo;
import com.example.IskconErpAPI.vo.UserInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<UserInfoVO> findAll() {

        try {

            List<UserInfo> userInfoList = userInfoRepo.findAll();
            List<UserInfoVO> userInfoVOList = new ArrayList<>();
            userInfoList.forEach(userInfo -> {
                UserInfoVO userInfoVO = new UserInfoVO();
                userInfoVO.setName(userInfo.getName());
                userInfoVO.setPermanentAddress(userInfo.getPermanentAddress());
                userInfoVO.setCurrentAddress(userInfo.getCurrentAddress());
                userInfoVO.setMobileNumber(userInfo.getMobileNumber());
                userInfoVO.setCityName(userInfo.getCity().getName());
                userInfoVO.setStateName(userInfo.getState().getName());
                userInfoVO.setCountryName(userInfo.getCountry().getName());
                userInfoVOList.add(userInfoVO);
            });

            return userInfoVOList;

        }catch (Exception e){
            logger.error(e.getMessage());
            throw new RuntimeException("Error in fetching user list");
        }
    }

    public List<UserInfoVO> findAllByFilter(UserInfoSearchCO userInfoSearchCO) {

        try {
            List<UserInfoVO> userInfoVOList = new ArrayList<>();
            List<UserInfo> userInfoList = new ArrayList<>();

            if(!userInfoSearchCO.getCountryList().isEmpty()){
                userInfoList.addAll(userInfoRepo.findAllByCountry(userInfoSearchCO.getCountryList()));
            }

            if(!userInfoSearchCO.getStateList().isEmpty()){
                userInfoList.addAll(userInfoRepo.findAllByState(userInfoSearchCO.getStateList()));
            }

            if(!userInfoSearchCO.getCityList().isEmpty()){
                userInfoList.addAll(userInfoRepo.findAllByCity(userInfoSearchCO.getCityList()));
            }

            userInfoList.forEach(userInfo -> {
                UserInfoVO userInfoVO = new UserInfoVO();
                userInfoVO.setName(userInfo.getName());
                userInfoVO.setPermanentAddress(userInfo.getPermanentAddress());
                userInfoVO.setCurrentAddress(userInfo.getCurrentAddress());
                userInfoVO.setMobileNumber(userInfo.getMobileNumber());
                userInfoVO.setCityName(userInfo.getCity().getName());
                userInfoVO.setStateName(userInfo.getState().getName());
                userInfoVO.setCountryName(userInfo.getCountry().getName());
                userInfoVOList.add(userInfoVO);
            });

            return userInfoVOList;

        }catch (Exception e){
            logger.error(e.getMessage());
            throw new RuntimeException("Error in fetching user list");
        }
    }


}
