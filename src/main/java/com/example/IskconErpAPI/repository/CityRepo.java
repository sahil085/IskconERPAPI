package com.example.IskconErpAPI.repository;

import com.example.IskconErpAPI.domain.Cities;
import com.example.IskconErpAPI.domain.States;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by sahil on 1/12/18.
 */
@Repository
public interface CityRepo extends JpaRepository<Cities, Long> {

    Cities findByName(String cityName);
    List<Cities> findAllByState(States states);
}
