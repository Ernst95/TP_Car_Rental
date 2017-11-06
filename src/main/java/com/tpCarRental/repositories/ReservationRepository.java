package com.tpCarRental.repositories;


import com.tpCarRental.domain.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation,String> {
}
