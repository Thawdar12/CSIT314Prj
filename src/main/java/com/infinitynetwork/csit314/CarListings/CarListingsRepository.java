//User table related SQL function
package com.infinitynetwork.csit314.CarListings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarListingsRepository extends JpaRepository<CarListings, Long> {
    List<CarListings> findByCarPlateNumberIgnoreCase(String carPlateNumber);

    List<CarListings> findByCarBrandIgnoreCase(String carBrand);

    List<CarListings> findByCarModelIgnoreCase(String carModel);

    List<CarListings> findByListingStatus(ListingStatus listingStatus);
}
