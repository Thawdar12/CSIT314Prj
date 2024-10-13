package com.infinitynetwork.csit314.ContentGeneration;

import com.infinitynetwork.csit314.AppUsers.AppUser;
import com.infinitynetwork.csit314.AppUsers.AppUserRepository;
import com.infinitynetwork.csit314.AppUsers.AppUserService;
import com.infinitynetwork.csit314.AppUsers.UserType;
import com.infinitynetwork.csit314.CarListings.CarListings;
import com.infinitynetwork.csit314.CarListings.CarListingsRepository;
import com.infinitynetwork.csit314.CarListings.ListingStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

@Component
public class InsertToDatabase implements CommandLineRunner {

    private final AppUserService appUserService;

    private final AppUserRepository appUserRepository;

    private final CarListingsRepository carListingsRepository;

    public InsertToDatabase(AppUserService appUserService, AppUserRepository appUserRepository, CarListingsRepository carListingsRepository) {
        this.appUserService = appUserService;
        this.appUserRepository = appUserRepository;
        this.carListingsRepository = carListingsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        boolean shouldInsert = false;
        for (String arg : args) {
            if ("-i".equals(arg)) {
                shouldInsert = true;
                break;
            }
        }

        if (shouldInsert) {
            insertUsers();
            insertCarListings();
        }
    }

    private void insertUsers() throws IOException {
        Random random = new Random();
        UserType[] userTypes = UserType.values();

        String[] firstNames = {"Alex", "Jordan", "Taylor", "Morgan", "Casey", "Jamie", "Riley", "Reese", "Drew", "Quinn"};
        String[] lastNames = {"Smith", "Johnson", "Brown", "Williams", "Jones", "Miller", "Davis", "Garcia", "Wilson", "Taylor"};

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_credentials.txt"))) {
            for (int i = 0; i < 100; i++) {
                String firstName = firstNames[random.nextInt(firstNames.length)];
                String lastName = lastNames[random.nextInt(lastNames.length)];
                String username = firstName.toLowerCase() + "." + lastName.toLowerCase() + i;
                String email = username + "@example.com";
                String password = generateRandomString(10);
                String phoneNumber = String.format("%010d", 1000000000L + i);
                UserType userType = userTypes[random.nextInt(userTypes.length)];

                AppUser appUser = new AppUser(username, email, password, phoneNumber, userType);
                appUserService.registerUser(appUser);

                writer.write("Username: " + username + ", Password: " + password + ", UserType: " + userType + "\n");
            }
            System.out.println("Inserted 100 random users into the database.");
            System.out.println("User credentials have been written to user_credentials.txt");
        } catch (IOException e) {
            System.err.println("Error writing user credentials to file: " + e.getMessage());
        }
    }

    private void insertCarListings() {
        Random random = new Random();

        // Realistic car brands and models
        Map<String, String[]> carData = new HashMap<>();
        carData.put("Toyota", new String[]{"Corolla", "Camry", "Prius", "RAV4"});
        carData.put("Honda", new String[]{"Civic", "Accord", "CR-V", "Fit"});
        carData.put("Ford", new String[]{"Fiesta", "Focus", "Mustang", "Explorer"});
        carData.put("Chevrolet", new String[]{"Cruze", "Malibu", "Impala", "Equinox"});
        carData.put("BMW", new String[]{"3 Series", "5 Series", "X3", "X5"});
        carData.put("Mercedes-Benz", new String[]{"C-Class", "E-Class", "GLA", "GLC"});
        carData.put("Audi", new String[]{"A3", "A4", "Q5", "Q7"});
        carData.put("Nissan", new String[]{"Sentra", "Altima", "Leaf", "Rogue"});
        carData.put("Hyundai", new String[]{"Elantra", "Sonata", "Tucson", "Santa Fe"});
        carData.put("Kia", new String[]{"Rio", "Optima", "Sportage", "Sorento"});

        List<AppUser> sellers = appUserRepository.findAllByUserType(UserType.SELLER);
        if (sellers.isEmpty()) {
            System.out.println("No sellers found to associate with car listings.");
            return;
        }

        Set<String> usedPlateNumbers = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            String carBrand = (String) carData.keySet().toArray()[random.nextInt(carData.size())];
            String[] models = carData.get(carBrand);
            String carModel = models[random.nextInt(models.length)];

            String carPlateNumber;
            do {
                carPlateNumber = "XYZ" + String.format("%04d", random.nextInt(10000));
            } while (usedPlateNumbers.contains(carPlateNumber));
            usedPlateNumbers.add(carPlateNumber);
            
            int manufacturedYear = 1995 + random.nextInt(2020 - 1995 + 1);
            String millage = String.valueOf(5000 + random.nextInt(200000));
            double price = 5000 + random.nextDouble() * 45000;
            String photo = "/exampleImg/Car (" + (1 + random.nextInt(20)) + ").jpg";

            // Pick a random seller
            AppUser seller = sellers.get(random.nextInt(sellers.size()));

            DecimalFormat df = new DecimalFormat("#.##");
            price = Double.valueOf(df.format(price));

            CarListings carListing = new CarListings();
            carListing.setCarBrand(carBrand);
            carListing.setCarModel(carModel);
            carListing.setCarPlateNumber(carPlateNumber);
            carListing.setManufacturedYear(String.valueOf(manufacturedYear));
            carListing.setMillage(millage);
            carListing.setPrice(price);
            carListing.setListingStatus(ListingStatus.OPEN);
            carListing.setListedBy(seller);
            carListing.setSeller(seller);
            carListing.setPhoto(photo);

            carListingsRepository.save(carListing);
        }

        System.out.println("Inserted 100 random car listings into the database.");
    }

    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
    }
}
