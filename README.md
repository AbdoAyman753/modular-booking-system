# Modular Booking System

This repository contains the source code for a modular booking system implemented using Java Spring Boot. The system is designed to handle flight and hotel bookings, payments, and customer notifications, demonstrating a clean, modular approach to building complex applications.

## Architecture

```bash

booking-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── bookingsystem/
│   │   │           ├── core/
│   │   │           │   ├── exceptions/      # Shared exceptions
│   │   │           │   ├── utils/           # Shared utilities
│   │   │           │   └── config/          # Shared configurations
│   │   │           ├── search/              # Search module
│   │   │           │   ├── models/          # Search-specific domain models
│   │   │           │   ├── service/         # Business logic for search
│   │   │           │   ├── controller/      # REST endpoints for search
│   │   │           │   └── config/          # Search module configurations
│   │   │           ├── booking/             # Booking module
│   │   │           │   ├── models/          # Booking-specific domain models
│   │   │           │   ├── service/         # Business logic for bookings
│   │   │           │   ├── controller/      # REST endpoints for bookings
│   │   │           │   └── config/          # Booking module configurations
│   │   │           ├── payment/             # Payment module
│   │   │           │   ├── models/          # Payment-specific domain models
│   │   │           │   ├── service/         # Business logic for payments
│   │   │           │   ├── controller/      # REST endpoints for payments
│   │   │           │   └── config/          # Payment module configurations
│   │   │           ├── notification/        # Notification module
│   │   │           │   ├── models/          # Notification-specific domain models
│   │   │           │   ├── service/         # Business logic for notifications
│   │   │           │   ├── controller/      # REST endpoints for notifications
│   │   │           │   └── config/          # Notification module configurations
│   │   │           ├── audit/               # Audit module
│   │   │           │   ├── models/          # Audit-specific domain models
│   │   │           │   ├── service/         # Business logic for auditing
│   │   │           │   ├── controller/      # REST endpoints for auditing
│   │   │           │   └── config/          # Audit module configurations
│   │   │           ├── auth/                # Auth module
│   │   │           │   ├── models/          # Auth-specific domain models
│   │   │           │   ├── service/         # Business logic for authentication
│   │   │           │   ├── controller/      # REST endpoints for authentication
│   │   │           │   └── config/          # Auth module configurations
│   │   │           └── BookingSystemApplication.java  # Main application class
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application-search.properties
│   │       ├── application-booking.properties
│   │       └── application-payment.properties
|   |       └── application-notification.properties
│   │       └── application-audit.properties
|   |       └── application-auth.properties
│   └── test/                                # Test code
├── pom.xml                                  # Single POM file for the entire project
├── docker-compose.yml                       # Docker Compose file
└── README.md                                # README for the project

```

1.  **`booking-system-core`:**
    *   Contains the common domain models and utilities shared across all modules.
2.  **`booking-system-search`:**
    *   Handles the search functionality for flights and hotels.
    *   Implements caching for improved performance using Redis.
    *   Interacts with external Flight and Hotel APIs for data retrieval.
3.  **`booking-system-booking`:**
    *   Manages the booking process for flights and hotels.
    *   Handles interactions with the Payment module.
    *   Uses RabbitMQ for asynchronous communication with the Notification module.
4.  **`booking-system-payment`:**
    *   Handles payment processing using external services like PayPal and Stripe.
    *   Interacts with a message queue (RabbitMQ) for payment events.
5.  **`booking-system-notification`:**
    *   Handles customer notifications via email or other channels.
    *   Listens for booking and payment events via RabbitMQ.
6.  **`booking-system-audit`:**
     *    Handles the system auditing of any sensitive transaction or actions.
7.  **`booking-system-auth`:**
     *    Handles the system Authentication and Authorization.

## Technology Stack

*   **Java:** The primary programming language.
*   **Spring Boot:** Used for building the application and services.
*   **Maven:** For dependency management and project builds.
*   **PostgreSQL:** For persistent data storage.
*   **Redis:** For caching of search results.
*   **RabbitMQ:** For asynchronous messaging.
*   **Docker:** For containerization.

## Prerequisites

Before getting started, ensure you have the following tools installed:

*   **Java Development Kit (JDK 17 or higher)**
*   **Apache Maven (3.6.0 or higher)**
*   **Docker and Docker Compose**

