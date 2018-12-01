package com.example.IskconErpAPI.repository;

import com.example.IskconErpAPI.domain.Countries;
import com.example.IskconErpAPI.domain.States;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sahil on 1/12/18.
 */
@Repository
public interface StateRepo extends JpaRepository<States, Long> {

    States findByName(String stateName);
    List<States> findAllByCountry(Countries countries);
}
