package demo.hotelproject.controller;

import demo.hotelproject.entity.Hotel;
import demo.hotelproject.repository.HotelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/all")
    public List<Hotel> getAllHotels(){
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels;
    }

    @PutMapping
    public void inserthotel(@RequestBody Hotel hotel) {
        this.hotelRepository.insert(hotel);
    }

    @PostMapping
    public void updateHotel(@RequestBody Hotel hotel) {
        this.hotelRepository.save(hotel);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable("id") String id) {
        this.hotelRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Hotel getById(@PathVariable("id") String id){
        Hotel hotel = this.hotelRepository.getById(id);
        return hotel;
    }

    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getByPrice(@PathVariable("maxPrice") int maxPrice){
        List<Hotel> hotels = this.hotelRepository.findByPricePerNightLessThan(maxPrice);
        return hotels;
    }

    @GetMapping("/city/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city) {
        List<Hotel> hotels = this.hotelRepository.findByCityName(city);
        return hotels;
    }

    @GetMapping("/country/{country}")
    public List<Hotel> getByCountry(@PathVariable("country") String country) {
        List<Hotel> hotels = this.hotelRepository.findByCountryName(country);
        return hotels;
    }
}
