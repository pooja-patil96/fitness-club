package com.club.controller;

import com.club.model.Booking;
import com.club.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking){
        
			return bookingService.createBooking(booking);
		
    }

    @GetMapping
    public List<Booking> searchBookings(
            @RequestParam(required = false) String member,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate) {

        LocalDate start = startDate != null ? LocalDate.parse(startDate) : null;
        LocalDate end = endDate != null ? LocalDate.parse(endDate) : null;
        return bookingService.searchBookings(member, start, end);
    }
}
