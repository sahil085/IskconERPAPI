package com.example.IskconErpAPI.repository;

import com.example.IskconErpAPI.domain.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sahil on 1/12/18.
 */
@Repository
public interface CountryRepo extends JpaRepository<Countries, Long> {

    Countries findByName(String countryName);
}
