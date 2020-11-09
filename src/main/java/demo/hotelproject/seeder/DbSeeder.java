package demo.hotelproject.seeder;

import demo.hotelproject.entity.Address;
import demo.hotelproject.entity.Hotel;
import demo.hotelproject.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DbSeeder implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Hotel marriot = new Hotel(
                "Marriot", 130,
                new Address("Paris", "France"),
                Arrays.asList(
                        new Review("John", 8, false),
                        new Review("Angelika", 7, true))
        );

        Hotel ibis = new Hotel(
                "Ibis", 90,
                new Address("Bucharest", "Romania"),
                Arrays.asList(
                        new Review("Michael", 8, true),
                        new Review("Steve", 7, false))
        );

        Hotel sofitel = new Hotel(
                "Sofitel", 200,
                new Address("Rome", "Italy"),
                Arrays.asList(
                        new Review("Peter", 8, false),
                        new Review("Mary", 7, false))
        );
    }
}
