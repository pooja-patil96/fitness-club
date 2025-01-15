package com.club.model;



import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private String memberName;
    private String className;
    private LocalDate participationDate;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private ClubClass clubClass;


    public Booking() {}

    public Booking(String memberName, String className, LocalDate participationDate, ClubClass clubClass) {
        this.memberName = memberName;
        this.className = className;
        this.participationDate = participationDate;
        this.clubClass = clubClass;
    }

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public LocalDate getParticipationDate() {
		return participationDate;
	}

	public void setParticipationDate(LocalDate participationDate) {
		this.participationDate = participationDate;
	}

	public ClubClass getClubClass() {
		return clubClass;
	}

	public void setClubClass(ClubClass clubClass) {
		this.clubClass = clubClass;
	}

}
