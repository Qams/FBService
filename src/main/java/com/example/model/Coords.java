package com.example.model;

public class Coords {
    private float lon;
    private float lat;

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Coords{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
