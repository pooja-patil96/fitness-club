package com.club.service;

import com.club.exception.BookingCapacityExceededException;
import com.club.model.Booking;
import com.club.model.ClubClass;
import com.club.repo.BookingRepository;
import com.club.repo.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ClubRepository clubClassRepository;

    public Booking createBooking(Booking booking) {
        ClubClass clubClass = clubClassRepository.findById(booking.getClubClass().getId()).orElse(null);
        if (clubClass == null) {
            return null;  // Class not found
        }

       // long count = bookingRepository.
        // Check if the class is already fully booked for the given date
        long count = bookingRepository.countByClubClassAndParticipationDate(clubClass, booking.getParticipationDate());

        if (count >= clubClass.getCapacity()) {
            throw new BookingCapacityExceededException("Class is already fully booked for this date.");
        }

        return bookingRepository.save(booking);
    }

    public List<Booking> searchBookings(String memberName, LocalDate startDate, LocalDate endDate) {
        if (memberName != null) {
            if (startDate != null && endDate != null) {
                return bookingRepository.findByMemberNameAndParticipationDateBetween(memberName, startDate, endDate);
            } else {
                return bookingRepository.findByMemberName(memberName);
            }
        } else {
            return bookingRepository.findByParticipationDateBetween(startDate, endDate);
        }
    }
}
