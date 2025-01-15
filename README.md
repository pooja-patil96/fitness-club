# Fitness-Club
# Overview

This project is a simple Spring Boot application designed to manage club classes and member bookings. It allows for:

1. Creating Classes with specific start and end times, capacity, and duration.
2. Booking a Class for a member.
3. Searching Bookings by member name and/or date range.

# Database Configuration

Updating Database Password
In this Spring Boot application, the database configuration (including credentials) is managed via the application.properties file. This file holds the connection details to your database, including the database URL, username, and password.

Follow the steps below to update your database password:

1. Modify application.properties
      - The **application.properties** file is located in the src/main/resources/ directory of your Spring Boot project. Open this file to update the database password.
  
2. Restart the Application
   - Once you've updated the database connection credentials in the application.properties file and changed the password in your database, restart your Spring Boot application.
  
# API Documentation

**Base URL**

The API is hosted at http://localhost:8080/ (default Spring Boot port).
  
**1. Create a Class**   
Endpoint: POST {Base_url}/classes

Description: Creates a new class.

Request Body:
{
  "name": "Pilates",
  "startDate": "2025-12-01",
  "endDate": "2025-12-20",
  "startTime": "14:00",
  "duration": 60,
  "capacity": 10
}

Response Body:
{
  "id": 1,
  "name": "Pilates",
  "startDate": "2025-12-01",
  "endDate": "2025-12-20",
  "startTime": "14:00",
  "duration": 60,
  "capacity": 10
}

**2. Book a Class**

Endpoint: POST {Base_url}/bookings

Description: Books a member for a class on a specific participation date.

Request Body:
{
  "memberName": "Pooja",
  "clubClass": {
    "id": 1
  },
  "participationDate": "2025-12-02"
}

Response body:
{
		"bookingId": 2,
		"memberName": "pooja",
		"className": null,
		"participationDate": "2023-12-01",
		"clubClass": {
			"id": 1,
			"name": "Pilates",
			"startDate": "2023-12-01",
			"endDate": "2023-12-20",
			"startTime": "14:00:00",
			"duration": 60,
			"capacity": 4
		}
	}

**3. Search Bookings by Member**

Endpoint: GET {Base_url}/bookings?member=<member_name>

Description: Searches bookings by member name.

Example Request:  GET {Base_url}/bookings?member=Pooja

Response :
[
  {
		"bookingId": 2,
		"memberName": "pooja",
		"className": null,
		"participationDate": "2023-12-01",
		"clubClass": {
			"id": 1,
			"name": "Pilates",
			"startDate": "2023-12-01",
			"endDate": "2023-12-20",
			"startTime": "14:00:00",
			"duration": 60,
			"capacity": 4
		}
	},
]

**4. Search Bookings by Date Range**

Endpoint: GET {Base_url}/bookings?startDate=<start_date>&endDate=<end_date>

Description: Searches bookings between a specific date range.

Example Request: GET {Base_url}/bookings?startDate=2025-12-01&endDate=2025-12-10

Response:
[
  {
		"bookingId": 2,
		"memberName": "pooja",
		"className": null,
		"participationDate": "2023-12-01",
		"clubClass": {
			"id": 1,
			"name": "Pilates",
			"startDate": "2023-12-01",
			"endDate": "2023-12-20",
			"startTime": "14:00:00",
			"duration": 60,
			"capacity": 4
		}
	},
]





  
