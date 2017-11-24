package DAO;

import model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CarDAOImpl implements CarDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Car car) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(car);
        tx.commit();
        session.close();

    }

    @Override
    public void delete(Car car) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(car);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Car car, Car newCar) {
        car.setDescription(newCar.getDescription());
        car.setPower(newCar.getPower());
        car.setModel(newCar.getModel());
        car.setBrand(newCar.getBrand());

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(car);
        tx.commit();
        session.close();
    }

    public Car getCar(int id) {
        Session session = this.sessionFactory.openSession();
        return session.get(Car.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Car> list() {
        Session session = this.sessionFactory.openSession();
        List<Car> carList = session.createQuery("from Car").list();
        session.close();
        return carList;
    }
}
