package com.example.IskconErpAPI.controller;

import com.example.IskconErpAPI.domain.RathYatra;
import com.example.IskconErpAPI.repository.RathYatraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.Optional;

@RestController
@CrossOrigin
public class RathYatraController {

    @Autowired
    RathYatraRepo rathYatraRepo;

    @PermitAll()
    @GetMapping("/location")
    public String getRathLocation(){
    RathYatra rathYatra = rathYatraRepo.getOne(1l);
    if(rathYatra !=null){
        return     rathYatra.getLongitude()+ "^" + rathYatra.getLattitude();

    }else {
       return null;
    }
    }

    @PutMapping("/updateLocation/{lati}/{longi}")
    @PermitAll()
    public String updateLocation(@PathVariable("lati") Double lattitude, @PathVariable("longi") Double longitude){
        Optional<RathYatra> optionalRathYatra = rathYatraRepo.findById(Long.parseLong("1"));
        if(optionalRathYatra.isPresent()){
           RathYatra rathYatra = optionalRathYatra.get();
            rathYatra.setLattitude(lattitude);
            rathYatra.setLongitude(longitude);
            rathYatraRepo.saveAndFlush(rathYatra);

        }else {
            RathYatra rathYatra = new RathYatra();
            rathYatra.setLattitude(lattitude);
            rathYatra.setLongitude(longitude);
            rathYatraRepo.saveAndFlush(rathYatra);
        }
        return "Location Saved Successfully.. Hare Krishna..!!";
    }
}
