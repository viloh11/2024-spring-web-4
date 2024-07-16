package org.java.spring_web4.db.pojo;

import org.java.spring_web4.web.dto.FarmerDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 128)
    private String name;

    @Column(nullable = false, length = 128)
    private String surname;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String farm;

    public Farmer(){}

    public Farmer(FarmerDto farmerDto){
        this(farmerDto.getName(), farmerDto.getSurname(), farmerDto.getAge(), farmerDto.getFarm());
    }

    public Farmer(String name, String surname, int age, String farm){
        setName(name);
        setSurname(surname);
        setAge(age);
        setFarm(farm);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getFarm() {
        return farm;
    }
    
    public void setFarm(String farm) {
        this.farm = farm;
    }

    public void update(FarmerDto farmerDto){
        setName(farmerDto.getName());
        setSurname(farmerDto.getSurname());
        setAge(farmerDto.getAge());
        setFarm(farmerDto.getFarm());
    }



    @Override
    public String toString() {
        return "Farmer{" + "id=" + id + ", name=" + name + ", surname= " + surname + ", age=" + age + ", farm=" + farm + " }";
    }

}
