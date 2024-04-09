package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getCars(List<Car> cars, Integer count) {
        if (count == null || count > cars.size()) {
            return cars;
        } else if (count > 0) {
            return cars.subList(0, count);
        }
        return new ArrayList<>();
    }
}
