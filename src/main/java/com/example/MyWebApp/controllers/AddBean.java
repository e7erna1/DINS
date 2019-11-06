package com.example.MyWebApp.controllers;

import com.example.MyWebApp.dao.PersonManagementDAO;
import com.example.MyWebApp.dao.PersonManagementDAOImpl;
import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Class {@link AddBean} adding new person to database
 */


@ManagedBean(name = "addition")
@ViewScoped
public class AddBean implements Serializable {

  private String name;
  private String surname;
  private Date birthday;
  private String address;

  /**
   * FacesContext gets context for this request, which will treatment.
   * PersonManagementDAO gets instance to interact with the database then it adds new person.
   * isValidationFailed return true if everything ok.
   * @param name - name of person
   * @param surname - surname of person
   * @param birthday - birthday of person
   * @param address - address of person
   */

  public void addPerson(String name, String surname, Date birthday, String address) {
    try {
      FacesContext context = FacesContext.getCurrentInstance();
      PersonManagementDAO personManagementDAO = new PersonManagementDAOImpl();
      personManagementDAO.addPerson(name, surname, birthday, address);
      context.isValidationFailed();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public AddBean() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}