package org.java.spring_web4.web.dto;

public class FarmDto {

    private String name;
    private String city;

    public FarmDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

     @Override
    public String toString() {
        return "Farm{ name=" + name + ", city=" + city + " }"; 
    }

}
