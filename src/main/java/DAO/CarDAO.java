package DAO;

import model.Car;
import org.hibernate.SessionFactory;

import java.util.List;

public interface CarDAO {

    void setSessionFactory(SessionFactory sessionFactory);

    void save(Car car);

    void delete(Car car);

    void update(Car car, Car newCar);

    Car getCar(int id);

    List<Car> list();
}
