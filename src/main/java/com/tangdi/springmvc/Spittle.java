package com.tangdi.springmvc;

import java.util.Date;
import java.util.UUID;

public class Spittle {

    private final Long id;

    private final String message;

    private final Date time;

    private Double latitude;

    private Double longitude;

    public Spittle(String message, Date time, Double longitude, Double latitude){
        this.id = null;
        this.message = message;
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object that){
        that = (Spittle)that;
        if(id == ((Spittle) that).id && time == ((Spittle) that).time){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return UUID.randomUUID().hashCode();
    }
}
