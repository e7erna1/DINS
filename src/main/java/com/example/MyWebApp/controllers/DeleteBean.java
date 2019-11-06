package com.example.MyWebApp.controllers;

import com.example.MyWebApp.dao.PersonManagementDAO;
import com.example.MyWebApp.dao.PersonManagementDAOImpl;
import com.example.MyWebApp.dao.Persons;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Class {@link DeleteBean} delete persons from database
 */

@ManagedBean(name = "deletion")
@ViewScoped
public class DeleteBean {

  transient private PersonManagementDAO personManagementDAO;

  private String name;
  private List<Persons> linkedList;

  /**
   * FacesContext gets context for this request, which will treatment. PersonManagementDAO gets
   * instance to interact with the database then remove person from database. isValidationFailed
   * return true if everything ok.
   *
   * @param persons - person which u want delete
   */

  public void deletePerson(Persons persons) {
    try {
      personManagementDAO = new PersonManagementDAOImpl();
      FacesContext context = FacesContext.getCurrentInstance();
      personManagementDAO.deletePerson(persons);
      linkedList.remove(persons);
      context.isValidationFailed();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * FacesContext gets context for this request, which will treatment. PersonManagementDAO gets
   * instance to interact with the database then search person by name, and fill the list with
   * search result. isValidationFailed return true if everything ok.
   *
   * @param name - name of person which u want get
   */

  public void getPeron(String name) {
    try {
      personManagementDAO = new PersonManagementDAOImpl();
      FacesContext context = FacesContext.getCurrentInstance();
      linkedList = personManagementDAO.getPeron(name);
      context.isValidationFailed();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Persons> getLinkedList() {
    return linkedList;
  }

  public void setLinkedList(List<Persons> linkedList) {
    this.linkedList = linkedList;
  }
}
