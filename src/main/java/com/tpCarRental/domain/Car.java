package com.tpCarRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Car {

    @Id
    private String id;
    private String name;
    private String model;
    private String year;

    @ManyToOne
    private CarType carType;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    private Car(){

    }

    public Car(Builder builder){

        this.id = builder.id;
        this.name = builder.name;
        this.model = builder.model;
        this.year = builder.year;
        this.carType = builder.carType;

    }

    public static class Builder{

        private String id;
        private String name;
        private String year;
        private String model;
        private CarType carType;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder model(String value) {
            this.model = value;
            return this;
        }
        public Builder year(String value) {
            this.year = value;
            return this;
        }

        public Builder carType(CarType carType)
        {
            this.carType = carType;
            return this;
        }

        public Car build(){
            return new Car(this);
        }
    }
}
