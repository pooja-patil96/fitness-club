package com.club.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.club.model.Booking;
import com.club.model.ClubClass;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    long countByClubClassAndParticipationDate(ClubClass clubClass, LocalDate participationDate);
    List<Booking> findByMemberName(String memberName);
    List<Booking> findByParticipationDateBetween(LocalDate startDate, LocalDate endDate);
    List<Booking> findByMemberNameAndParticipationDateBetween(String memberName, LocalDate startDate, LocalDate endDate);

}
