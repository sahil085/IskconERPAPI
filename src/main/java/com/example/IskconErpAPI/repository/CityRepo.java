package com.example.IskconErpAPI.repository;

import com.example.IskconErpAPI.domain.Cities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sahil on 1/12/18.
 */
@Repository
public interface CityRepo extends JpaRepository<Cities, Long> {

    Cities findByName(String cityName);
}
