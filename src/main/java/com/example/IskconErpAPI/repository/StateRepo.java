package com.example.IskconErpAPI.repository;

import com.example.IskconErpAPI.domain.States;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sahil on 1/12/18.
 */
@Repository
public interface StateRepo extends JpaRepository<States, Long> {

    States findByName(String stateName);
}
