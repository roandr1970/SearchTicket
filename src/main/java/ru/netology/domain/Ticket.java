package ru.netology.domain;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private String departureAirport;
    private String arrivalAirport;
    private int price;
    private int travelTime;


    public int getId() {
        return id;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public int getPrice() {
        return price;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public Ticket(int id, String departureAirport, String arrivalAirport, int price, int travelTime) {
        this.id = id;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.price = price;
        this.travelTime = travelTime;
    }

    @Override
    public int compareTo(Ticket o) {
        return price - o.price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", price=" + price +
                ", travelTime=" + travelTime +
                '}';
    }
}
