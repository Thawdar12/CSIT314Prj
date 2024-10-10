//User table related SQL function
package com.infinitynetwork.csit314.CarListings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarListingsRepository extends JpaRepository<CarListings, Long> {
    Optional<CarListings> findByCarPlateNumber(String carPlateNumber);
}
