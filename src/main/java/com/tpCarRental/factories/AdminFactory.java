package com.tpCarRental.factories;

import com.tpCarRental.domain.Admin;

/**
 * Created by Ernst on 2017/11/04.
 */
public class AdminFactory {

    public static Admin buildAdmin(String id, String name, String password)
    {
        Admin admin = new Admin.Builder()
                .id(id)
                .name(name)
                .password(password)
                .build();
        return admin;
    }
}
