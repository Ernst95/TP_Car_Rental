package com.tpCarRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarType {

    @Id
    private String id;
    private String type;
    private int price;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }


    public int gePrice() {
        return price;
    }

    private CarType(){

    }

    public CarType(Builder builder){

        this.id = builder.id;
        this.type = builder.type;
        this.price = builder.price;

    }

    public static class Builder{

        private String id;
        private String type;
        private int price;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder type(String value) {
            this.type = value;
            return this;
        }

        public Builder price(int value) {
            this.price = value;
            return this;
        }

        public CarType build(){
            return new CarType(this);
        }
    }
}
