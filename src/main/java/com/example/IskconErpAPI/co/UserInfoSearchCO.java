package com.example.IskconErpAPI.co;

import java.util.List;

/**
 * Created by sahil on 2/12/18.
 */
public class UserInfoSearchCO {

    List<Long> countryList;
    List<Long> stateList;
    List<Long> cityList;

    public List<Long> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Long> countryList) {
        this.countryList = countryList;
    }

    public List<Long> getStateList() {
        return stateList;
    }

    public void setStateList(List<Long> stateList) {
        this.stateList = stateList;
    }

    public List<Long> getCityList() {
        return cityList;
    }

    public void setCityList(List<Long> cityList) {
        this.cityList = cityList;
    }
}
