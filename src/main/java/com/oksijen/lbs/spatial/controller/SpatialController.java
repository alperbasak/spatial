package com.oksijen.lbs.spatial.controller;

import com.oksijen.lbs.spatial.dao.SpatialDao;
import com.oksijen.lbs.spatial.model.Spatial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class SpatialController {

    private final SpatialDao spatialDao;

    @Autowired
    public SpatialController(SpatialDao spatialDao) {
        this.spatialDao = spatialDao;
    }

    @RequestMapping(value = "/spa",method = RequestMethod.GET)
    public Object[] getSpatialListInBetween(@RequestParam double latStart, @RequestParam double latEnd, @RequestParam double lonStart, @RequestParam  double lonEnd,@RequestParam long timestamp){
       List<Spatial> spatials= spatialDao.findSpatialsByLatBetweenAndLonBetweenAndTimestampAfter(latStart,latEnd,lonStart,lonEnd,timestamp);

       return spatials.stream()
                .collect(Collectors.groupingBy(Spatial::getMsisdn,Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .toArray();
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Spatial> getAll(){
        return spatialDao.findAll();
    }

    /*
    @RequestMapping(value = "/{msisdn}", method = RequestMethod.GET)
    public Object[] findByMsisdn(@PathVariable String msisdn){
        return spatialDao.findMsisdn(msisdn).toArray();
    }
    */


}
