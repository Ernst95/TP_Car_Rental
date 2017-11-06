package com.tpCarRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Status {

    @Id
    private String id;
    private String statuc;

    @ManyToOne
    private CarType carType;

    public String getId() {
        return id;
    }

    public String getName() {
        return statuc;
    }


    private Status(){

    }

    public Status(Builder builder){

        this.id = builder.id;
        this.statuc = builder.statuc;
        this.carType = builder.carType;

    }

    public static class Builder{

        private String id;
        private String statuc;
        private CarType carType;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder statuc(String value) {
            this.statuc = value;
            return this;
        }


        public Builder carType(CarType carType)
        {
            this.carType = carType;
            return this;
        }

        public Status build(){
            return new Status(this);
        }
    }
}
