package com.example.model;

public class City {
    private String countryName;
    private String cityName;
    private String stateName;
    private Coords coords;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Coords getCoords() {
        return coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }

    @Override
    public String toString() {
        return "City{" +
                "countryName='" + countryName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", stateName='" + stateName + '\'' +
                ", coords=" + coords +
                '}';
    }
}
