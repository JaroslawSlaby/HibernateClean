package DAO;

import model.Person;
import org.hibernate.SessionFactory;

import java.util.List;

public interface PersonDAO {

    void setSessionFactory(SessionFactory sessionFactory);

    void save(Person person);

    void delete(Person person);

    void update(Person person, Person newPerson);

    Person getPerson(int id);

    List<Person> list();
}
