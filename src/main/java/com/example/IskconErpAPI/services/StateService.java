package com.example.IskconErpAPI.services;

import com.example.IskconErpAPI.domain.States;
import com.example.IskconErpAPI.repository.StateRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sahil on 1/12/18.
 */
@Service
public class StateService {

    public static final Logger logger = LoggerFactory.getLogger(StateService.class);

    @Autowired
    StateRepo stateRepo;

    public States findByName(String name){
        return stateRepo.findByName(name);
    }

}
