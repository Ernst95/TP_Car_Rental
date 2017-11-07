package com.tpCarRental.domain;

import javax.persistence.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Entity
public class Customer {

    @Id
    private String id;
    private String name,surname;
    private String userName;
    private String password;
    private boolean licence;

    @OneToOne
    @JoinColumn(name="fullId")
    private Address address_id;
    private Contact contact_id;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLicence() {
        if (licence == TRUE) {
            return licence;
        } else
        {

            return FALSE;
    }
    }

    public Address getAddress_id() {
        return address_id;
    }

    public Contact getContact_id() {
        return contact_id;
    }


    private Customer()
    {


    }

    public Customer(Builder build)
    {
        this.id=build.id;
        this.name=build.name;
        this.password=build.password;
        this.surname=build.surname;
        this.userName=build.userName;
        this.address_id=build.address_id;
        this.contact_id=build.contact_id;
        this.licence=build.licence;




    }

    public static class Builder
    {
        private String id;
        private String name,surname;
        private String userName;
        private String password;
        private Boolean licence;
        private Address address_id;
        private Contact contact_id;


        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder name(String value)
        {

            this.name=value;
            return this;

        }
        public Builder surname(String value)
        {

            this.surname=value;
            return this;


        }

        public Builder userName(String value)
        {

            this.userName=value;
            return this;

        }

        public Builder password(String value)
        {
            this.password=value;
            return this;

        }
        public Builder licence(Boolean value)
        {

            this.licence=value;
            return this;
        }
        public Builder address_id(Address value)
        {
            this.address_id=value;
            return this;

        }
        public Builder contact_id(Contact value)
        {
            this.contact_id=value;
            return this;

        }

        public Customer build()
        {
            return new Customer(this);
        }






    }

}
