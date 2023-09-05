package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class CarDaoImpl implements CarDao {
    private final List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car("Toyota", "Camry", 2022));
        carList.add(new Car("Honda", "Civic", 2021));
        carList.add(new Car("Ford", "F-150", 2022));
        carList.add(new Car("Chevrolet", "Malibu", 2020));
        carList.add(new Car("Nissan", "Altima", 2023));
    }

    @Override
    public List<Car> getCarByNumber(int number) {
        return IntStream.range(0, carList.size())
                .filter(l -> l < number)
                .mapToObj(carList::get)
                .toList();
    }
}
