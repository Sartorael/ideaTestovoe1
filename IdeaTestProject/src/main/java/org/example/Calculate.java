package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Calculate {
  public void calculateMinFlightTimeAndPriceDifference(List<Flight> flights) {
    List<Flight> vladivostokToTelAvivFlights =
        filterFlightsByOriginAndDestination(flights, "Владивосток", "Тель-Авив");

    if (vladivostokToTelAvivFlights.isEmpty()) {
      System.out.println("Отсутствуют рейсы между городами Владивосток и Тель-Авив");
      return;
    }

    Flight minFlightTime =
        vladivostokToTelAvivFlights.stream()
            .min(Comparator.comparingInt(Flight::getDuration))
            .orElseThrow();

    System.out.println("Минимальное время полета от Владивостока до Тель-Авива:");
    System.out.println(minFlightTime);

    List<Integer> prices = getFlightPrices(vladivostokToTelAvivFlights);
    double averagePrice = calculateAveragePrice(prices);
    double medianPrice = calculateMedianPrice(prices);

    System.out.println("Средняя цена полета от Владивостока до Тель-Авива:");
    System.out.println(averagePrice);

    System.out.println("Медианная цена полета от Владивостока до Тель-Авива:");
    System.out.println(medianPrice);

    double priceDifference = averagePrice - medianPrice;

    System.out.println(
        "Разница между средней ценой и медианой для полета от Владивостока до Тель-Авива:");
    System.out.println(priceDifference);
  }

  private List<Flight> filterFlightsByOriginAndDestination(
      List<Flight> flights, String origin, String destination) {
    List<Flight> filteredFlights = new ArrayList<>();

    for (Flight flight : flights) {
      if (flight.getOrigin() != null && flight.getDestination() != null) {
        if (flight.getOrigin().equals(origin) && flight.getDestination().equals(destination)) {
          filteredFlights.add(flight);
        }
      }
    }

    return filteredFlights;
  }

  private List<Integer> getFlightPrices(List<Flight> flights) {
    List<Integer> prices = new ArrayList<>();

    for (Flight flight : flights) {
      prices.add(flight.getPrice());
    }

    return prices;
  }

  private double calculateAveragePrice(List<Integer> prices) {
    return prices.stream().mapToInt(Integer::intValue).average().orElse(0.0);
  }

  private double calculateMedianPrice(List<Integer> prices) {
    int size = prices.size();
    if (size % 2 == 0) {
      int midIndex = size / 2;
      return (double) (prices.get(midIndex - 1) + prices.get(midIndex)) / 2;
    } else {
      int midIndex = size / 2;
      return prices.get(midIndex);
    }
  }
}
