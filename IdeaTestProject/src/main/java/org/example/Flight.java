package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Flight {
    private String origin;
    private String origin_name;
    private String destination;
    private String destination_name;
    private String departure_date;
    private String departure_time;
    private String arrival_date;
    private String arrival_time;
    private String carrier;
    private int stops;
    private int price;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOrigin_name() {
        return origin_name;
    }

    public void setOrigin_name(String origin_name) {
        this.origin_name = origin_name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination_name() {
        return destination_name;
    }

    public void setDestination_name(String destination_name) {
        this.destination_name = destination_name;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public int getStops() {
        return stops;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDuration() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");
        LocalDateTime departureDateTime = LocalDateTime.parse(departure_date + " " + departure_time, formatter);
        LocalDateTime arrivalDateTime = LocalDateTime.parse(arrival_date + " " + arrival_time, formatter);
        return (int) java.time.Duration.between(departureDateTime, arrivalDateTime).toMinutes();
    }

    @Override
    public String toString() {
        return "Flight{"
                + "origin='"
                + origin
                + '\''
                + ", originName='"
                + origin_name
                + '\''
                + ", destination='"
                + destination
                + '\''
                + ", destinationName='"
                + destination_name
                + '\''
                + ", departureDate='"
                + departure_date
                + '\''
                + ", departureTime='"
                + departure_time
                + '\''
                + ", arrivalDate='"
                + arrival_date
                + '\''
                + ", arrivalTime='"
                + arrival_time
                + '\''
                + ", carrier='"
                + carrier
                + '\''
                + ", stops="
                + stops
                + ", price="
                + price
                + ", duration=" + getDuration()
                + '}';
    }
}
