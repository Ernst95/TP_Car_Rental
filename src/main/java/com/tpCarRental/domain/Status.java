package com.tpCarRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Status {

    @Id
    private String id;
    private String statuses;

    public String getId() {
        return id;
    }

    public String getStatus() {
        return statuses;
    }

    private Status(){

    }

    public Status(Builder builder){

        this.id = builder.id;
        this.statuses = builder.statuses;

    }

    public static class Builder{

        private String id;
        private String statuses;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder statuses(String value) {
            this.statuses = value;
            return this;
        }

        public Status build(){
            return new Status(this);
        }
    }
}
