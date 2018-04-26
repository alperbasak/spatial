package com.oksijen.lbs.spatial.dao;

import com.oksijen.lbs.spatial.model.Spatial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpatialDao extends JpaRepository<Spatial,Long>{

   // public static final String FIND_MSISDN="Select s from Spatial s where s.msisdn=:msisdn " +
     //       "and s.lat is not null and s.lon is not null and timestamp>1506428624000";

    List<Spatial> findSpatialsByLatBetweenAndLonBetweenAndTimestampAfter(double latStart,double latEnd, double lonStart, double lonEnd,long timestamp);

//    String getIMSI(String msisdn);

 //   @Query(value = FIND_MSISDN)
 //   List<Spatial> findMsisdn(@Param("msisdn") String msisdn);
}
