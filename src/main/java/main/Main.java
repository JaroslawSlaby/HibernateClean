package main;

import DAO.CarDAO;
import DAO.CarDAOImpl;
import DAO.PersonDAO;
import DAO.PersonDAOImpl;
import model.Car;
import model.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {
    public static void main(String[] args) {


        SessionFactory factory;

        ServiceRegistry serviceRegistry;

        Configuration config = new Configuration();
        config.addAnnotatedClass(Car.class);
        config.addAnnotatedClass(Person.class);
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(serviceRegistry);

        CarDAO carDAO = new CarDAOImpl();
        carDAO.setSessionFactory(factory);
        PersonDAO personDAO = new PersonDAOImpl();
        personDAO.setSessionFactory(factory);

        Car car = new Car();
        car.setBrand("Mitsubishi");
        car.setModel("lancer");
        car.setDescription("bad");
        car.setPower(340);

        carDAO.save(car);

        Car car2 = new Car();
        car2.setBrand("Audi");
        car2.setModel("A3");
        car2.setDescription("good");
        car2.setPower(450);

        carDAO.save(car2);

        Car car3 = carDAO.getCar(2);
        System.out.println(car3);

        Person person = new Person();
        person.setName("Jarek");
        person.setLastName("Slaby");
        person.setAge(23);

        personDAO.save(person);

        Person newPerson = personDAO.getPerson(1);
        System.out.println(newPerson);

        factory.close();

    }
}
