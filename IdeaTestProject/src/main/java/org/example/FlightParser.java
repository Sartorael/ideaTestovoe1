package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FlightParser {
  public List<Flight> readFlightsFromFile(String fileName) {
    List<Flight> flights = new ArrayList<>();
    try (InputStream inputStream = new FileInputStream(fileName)) {
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
        Gson gson = new Gson();
        flights = gson.fromJson(reader, new TypeToken<List<Flight>>() {}.getType());
      }
    } catch (Exception e) {
      readFlightsFromFileInTestMod("tickets.json");
    }
    return flights;
  }

  public List<Flight> readFlightsFromFileInTestMod(String fileName) {
    List<Flight> flights = new ArrayList<>();
    try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
      assert inputStream != null;
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
        Gson gson = new Gson();
        flights = gson.fromJson(reader, new TypeToken<List<Flight>>() {}.getType());
      }
    } catch (Exception e) {
      System.out.println("Ошибка чтения файла: " + e.getMessage());
      e.printStackTrace();
    }
    return flights;
  }
}
