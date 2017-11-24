package DAO;

import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    private SessionFactory sessionFactory;

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Person person) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(person);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Person person) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(person);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Person person, Person newPerson) {
        person.setName(newPerson.getName());
        person.setLastName(newPerson.getLastName());
        person.setAge(newPerson.getAge());
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(person);
        tx.commit();
        session.close();

    }

    @Override
    public Person getPerson(int id) {
        Session session = this.sessionFactory.openSession();
        return session.get(Person.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> list() {
        Session session = this.sessionFactory.openSession();
        List<Person> carList = session.createQuery("from Person").list();
        session.close();
        return carList;
    }
}
