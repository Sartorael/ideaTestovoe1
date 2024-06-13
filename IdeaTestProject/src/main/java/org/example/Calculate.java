package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Calculate {
    public void calculateMinFlightTimePerCarrier(List<Flight> flights) {
        List<Flight> vladToTlvFlights = filterFlightsByOriginAndDestination(flights, "VVO", "TLV");
        Map<String, Integer> minFlightTimePerCarrier = vladToTlvFlights.stream()
                .collect(Collectors.groupingBy(
                        Flight::getCarrier,
                        Collectors.minBy(Comparator.comparingInt(Flight::getDuration))
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().map(Flight::getDuration).orElse(Integer.MAX_VALUE)
                ));

        System.out.println("Минимальное время полета между городами Владивосток и Тель-Авив для каждого авиаперевозчика:");
        minFlightTimePerCarrier.forEach((carrier, minTime) -> {
            System.out.println(carrier + ": " + minTime + " минут");
        });
    }

    public void calculateAverageAndMedianPrice(List<Flight> flights) {
        List<Flight> vladToTlvFlights = filterFlightsByOriginAndDestination(flights, "VVO", "TLV");

        double averagePrice = calculateAverage(vladToTlvFlights.stream()
                .mapToInt(Flight::getPrice)
                .toArray());

        int medianPrice = calculateMedian(vladToTlvFlights.stream()
                .mapToInt(Flight::getPrice)
                .sorted()
                .toArray());

        System.out.println("Средняя цена полета между Владивостоком и Тель-Авивом: " + averagePrice);
        System.out.println("Медиана цены полета между Владивостоком и Тель-Авивом: " + medianPrice);
        System.out.println("Разница между средней ценой и медианой: " + (averagePrice - medianPrice));
    }

    private List<Flight> filterFlightsByOriginAndDestination(List<Flight> flights, String origin, String destination) {
        return flights.stream()
                .filter(f -> f.getOrigin().equals(origin) && f.getDestination().equals(destination))
                .collect(Collectors.toList());
    }

    private double calculateAverage(int[] values) {
        return values.length > 0 ? (double) java.util.Arrays.stream(values).sum() / values.length : 0.0;
    }

    private int calculateMedian(int[] values) {
        int length = values.length;
        if (length == 0) return 0;
        if (length % 2 == 0) {
            return (values[length / 2 - 1] + values[length / 2]) / 2;
        } else {
            return values[length / 2];
        }
    }
}
