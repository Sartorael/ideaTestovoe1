package org.example;

import java.io.File;
import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath;
        URL jarUrl = Main.class.getProtectionDomain().getCodeSource().getLocation();
        File jarFile;
        try {
            jarFile = new File(jarUrl.toURI());
        } catch (Exception e) {
            jarFile = new File(jarUrl.getPath());
        }
        File jarDir = jarFile.getParentFile();
        System.out.println(jarFile.getParentFile());
        File ticketsFile = new File(jarDir, "tickets.json");
        if (ticketsFile.exists()) {
            filePath = ticketsFile.getAbsolutePath();
            System.out.println("Найден файл " + ticketsFile.getAbsolutePath());
        } else {
            System.out.println("Файл в папке с jar не найден, запускаем тестовый файл");
            filePath = "tickets.json";
        }
        FlightParser flightParser = new FlightParser();
        List<Flight> flights = flightParser.readFlightsFromFile(filePath);
        if (flights.isEmpty()) {
            flights = flightParser.readFlightsFromFileInTestMod(filePath);
        }

        Calculate calculate = new Calculate();
        calculate.calculateMinFlightTimePerCarrier(flights);
        calculate.calculateAverageAndMedianPrice(flights);
        System.out.println();
        System.out.println("Информация о продолжительности полетов:");
        for (Flight flight : flights) {
            System.out.println("Рейс: " + flight.getOrigin() + " → " + flight.getDestination() + ", Продолжительность: " + flight.getDuration() + " минут");
        }
    }
}
