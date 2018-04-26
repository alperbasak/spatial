package com.oksijen.lbs.spatial.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "LOCATION_REPORTS")
public class Spatial {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name = "trigger_id")
    public String id;

    @Column
    public long timestamp;

    @Column
    public String msisdn;

    @Column (name = "latitude")
    public Double lat;

    @Column (name = "longitude")
    public Double lon;

    public Spatial(long timestamp, String msisdn, Double lat, Double lon) {
        this.timestamp = timestamp;
        this.msisdn = msisdn;
        this.lat = lat;
        this.lon = lon;
    }

    public Spatial(){}

    @Override
    public String toString() {
        return "Spatial{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", msisdn=" + msisdn +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
