//User table related SQL function
package com.infinitynetwork.csit314.CarListings;

import com.infinitynetwork.csit314.AppUsers.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarListingsRepository extends JpaRepository<CarListings, Long> {
    List<CarListings> findByCarPlateNumberIgnoreCase(String carPlateNumber);

    List<CarListings> findByCarBrandIgnoreCase(String carBrand);

    List<CarListings> findByCarModelIgnoreCase(String carModel);

    List<CarListings> findByListingStatus(ListingStatus listingStatus);

    List<CarListings> findBySeller(AppUser seller);

    Page<CarListings> findBySeller(AppUser seller, Pageable pageable);
}
