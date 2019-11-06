package com.example.MyWebApp.dao;

import java.util.Date;
import java.util.List;

/**
 * {@link PersonManagementDAO} this interface describe main methods for interaction with database.
 * All methods needs for interaction with database.
 */

public interface PersonManagementDAO {

  void addPerson(String name, String surname, Date birthday, String address);

  void deletePerson(Persons persons);

  void editPerson(List<Persons> personsList);

  List<Persons> getByValPersons(String quer);

  List<Persons> getPeron(String name);

  List<Persons> getAllPersons();

}