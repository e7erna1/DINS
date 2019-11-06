package com.example.MyWebApp.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * {@link PersonManagementDAOImpl} implements {@link PersonManagementDAO}
 */
public class PersonManagementDAOImpl implements PersonManagementDAO {


  /**
   * Creating a database session using HibernateUtil. Session starts transaction, then save new
   * persons with params and then transaction finishes by commit. If something wrong, we rollback
   * transaction, nothing happens with database.
   *
   * @param name - contains person's name
   * @param surname - contains person's surname
   * @param birthday - contains person's birthday
   * @param address - contains person's address
   */

  @Override
  public void addPerson(String name, String surname, Date birthday, String address) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      session.save(new Persons(name, surname, birthday, address));
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw e;
    }
  }

  /**
   * HibernateUtil. Session starts transaction, then delete person that we take as param and then
   * transaction finishes by commit. If something wrong, we rollback transaction, nothing happens
   * with database.
   *
   * @param persons - person, that we want delete from database. Creating a database session using
   */

  @Override
  public void deletePerson(Persons persons) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      session.delete(persons);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw e;
    }
  }

  /**
   * Session starts transaction, then save all list of new persons to database (upgrade existed
   * persons) and then transaction finishes by commit. If something wrong, we rollback transaction,
   * nothing happens with database.
   *
   * @param personsList - list with edited persons. Creating a database session using
   * HibernateUtil.
   */

  @Override
  public void editPerson(List<Persons> personsList) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      for (Persons persons : personsList) {
        session.update(persons);
      }
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw e;
    }
  }

  /**
   * Creating a database session using HibernateUtil. Session starts transaction, then execute HQL
   * query from request, list persons save persons from database and then transaction finishes by
   * commit. If something wrong, we rollback transaction, nothing happens with database.
   *
   * @param quer - HQL query ready to run.
   * @return - list of persons retrieved from the database.
   */

  @Override
  public List<Persons> getByValPersons(String quer) {
    Transaction transaction = null;
    Query query;
    List<Persons> persons;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      query = session.createQuery(quer, Persons.class);
      persons = query.getResultList();
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw e;
    }
    return persons;
  }

  /**
   * Creating a database session using HibernateUtil. Session starts transaction, then creates SQL
   * request to database with param name, which get as method param, list persons save persons with
   * this name from database and then transaction finishes by commit. If something wrong, we
   * rollback transaction, nothing happens with database.
   *
   * @param name - name of the person we need.
   * @return - list of persons retrieved from the database.
   */

  @Override
  public List<Persons> getPeron(String name) {
    Transaction transaction = null;
    Query query;
    List<Persons> persons = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      query = session.createQuery("SELECT p from Persons p where p.name=:name", Persons.class);
      query.setParameter("name", name);
      persons = query.getResultList();
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    return persons;
  }

  /**
   * Creating a database session using HibernateUtil. Session starts transaction, then creates HQL
   * request to database, list persons save all persons from database and then transaction finishes
   * by commit. If something wrong, we rollback transaction, nothing happens with database.
   *
   * @return List of all persons in database.
   */

  @Override
  public List<Persons> getAllPersons() {
    Transaction transaction = null;
    Query query;
    List<Persons> persons;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      query = session.createQuery("FROM Persons p");
      persons = query.list();
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw e;
    }
    return persons;
  }
}