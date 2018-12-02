package com.example.IskconErpAPI.vo;

import java.util.List;

/**
 * Created by sahil on 1/12/18.
 */
public class StateVO {

    private Long id;
    private String name;
    private List<CityVO> cityVOList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CityVO> getCityVOList() {
        return cityVOList;
    }

    public void setCityVOList(List<CityVO> cityVOList) {
        this.cityVOList = cityVOList;
    }
}
