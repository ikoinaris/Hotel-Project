package demo.hotelproject.repository;

import demo.hotelproject.entity.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {

    Hotel getById(String id);

    List<Hotel> findByPricePerNightLessThan(int maxPrice);

    @Query(value = "{'address.city':?0}")
    List<Hotel> findByCityName(String city);

    @Query(value = "{'address.country':?0}")
    List<Hotel> findByCountryName(String country);
}
