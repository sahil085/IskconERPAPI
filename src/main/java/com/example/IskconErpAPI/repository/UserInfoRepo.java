package com.example.IskconErpAPI.repository;

import com.example.IskconErpAPI.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sahil on 1/12/18.
 */
@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {

    List<UserInfo> findAllByCountry(List<Long> countryIdList);
    List<UserInfo> findAllByState(List<Long> stateIdList);
    List<UserInfo> findAllByCity(List<Long> cityIdList);
}
