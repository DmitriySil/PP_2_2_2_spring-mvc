package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService {
    public static List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car("opel", "astra", "black"));
        cars.add(new Car("opel", "vectra", "yellow"));
        cars.add(new Car("opel", "corsa", "pink"));
        cars.add(new Car("opel", "omega", "red"));
        cars.add(new Car("opel", "kadett", "black"));
    }
    public List<Car> showCars(String count){
        if (count == null){
            return cars;
        } else return cars.stream().limit(Long.parseLong(count)).collect(Collectors.toList());
    }
}
