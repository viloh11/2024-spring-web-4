package org.java.spring_web4.web.dto;

public class FarmerDto {

    private String name;
    private String surname;
    private int age;

    public FarmerDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "FarmerDTo{" + " name=" + name + ", surname= " + surname + ", age=" + age + " }";
    }
}
