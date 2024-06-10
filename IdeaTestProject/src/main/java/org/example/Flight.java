package org.example;

public class Flight {
  private String carrier;
  private String origin;
  private String destination;
  private int price;
  private int duration;

  public Flight(String carrier, String origin, String destination, int price, int duration) {
    this.carrier = carrier;
    this.origin = origin;
    this.destination = destination;
    this.price = price;
    this.duration = duration;
  }

  public String getCarrier() {
    return carrier;
  }

  public void setCarrier(String carrier) {
    this.carrier = carrier;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  @Override
  public String toString() {
    return "Flight{"
        + "carrier='"
        + carrier
        + '\''
        + ", origin='"
        + origin
        + '\''
        + ", destination='"
        + destination
        + '\''
        + ", price="
        + price
        + ", duration="
        + duration
        + '}';
  }
}
