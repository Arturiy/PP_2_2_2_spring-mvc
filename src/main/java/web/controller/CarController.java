package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    final private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String showCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {

        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Lada", 110, "red", 100));
        cars.add(new Car("BMW", 112, "blue", 200));
        cars.add(new Car("Audi", 111, "green", 300));
        cars.add(new Car("Opel", 113, "black", 400));
        cars.add(new Car("Volkswagen", 114, "white", 500));

        model.addAttribute("cars", carService.getCars(cars, count));
        return "cars";
    }


}