package com.example.IskconErpAPI.services;

import com.example.IskconErpAPI.domain.Countries;
import com.example.IskconErpAPI.repository.CountryRepo;
import com.example.IskconErpAPI.vo.AddressListVO;
import com.example.IskconErpAPI.vo.CityVO;
import com.example.IskconErpAPI.vo.CountryVO;
import com.example.IskconErpAPI.vo.StateVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sahil on 2/12/18.
 */
@Service
public class AddressService {

    @Autowired
    CountryService countryService;
    @Autowired
    StateService stateService;
    @Autowired
    CityService cityService;

    public static final Logger logger = LoggerFactory.getLogger(AddressService.class);

    public List<AddressListVO> getAddressList() {
        List<CountryVO> countryVOList = countryService.findAll();
        List<AddressListVO> addressListVOList = new LinkedList<>();
        countryVOList.forEach(countryVO -> {
            AddressListVO addressListVO = new AddressListVO();
            List<StateVO> stateVOS  = stateService.findAllByCountry(countryVO.getId());
            CountryVO countryStateVo = new CountryVO();
            countryStateVo.setId(countryVO.getId());
            countryStateVo.setName(countryVO.getName());
            List<StateVO> stateVOList = new LinkedList<>();
            stateVOS.forEach(stateVO -> {
                List<CityVO> cityVOList = cityService.findAllByState(stateVO.getId());
                StateVO stateCityVo = new StateVO();
                stateCityVo.setId(stateVO.getId());
                stateCityVo.setName(stateVO.getName());
                stateCityVo.setCityVOList(cityVOList);
                stateVOList.add(stateCityVo);
            });
            countryStateVo.setStateVOS(stateVOList);
            addressListVO.setCountryVO(countryStateVo);
        addressListVOList.add(addressListVO);

        });
        return addressListVOList;
    }

}
