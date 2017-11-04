package com.tpCarRental.services;

/**
 * Created by Ernst on 2017/11/04.
 */
public interface BaseService <E, ID>{

    E save(E id);
    E findById(ID id);
    E update(E id);
    void delete(E id);

}
