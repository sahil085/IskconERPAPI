package com.example.IskconErpAPI.vo;

import java.util.List;

/**
 * Created by sahil on 1/12/18.
 */
public class CountryVO {

    private Long id;
    private String name;
    private List<StateVO> stateVOS;

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

    public List<StateVO> getStateVOS() {
        return stateVOS;
    }

    public void setStateVOS(List<StateVO> stateVOS) {
        this.stateVOS = stateVOS;
    }
}
