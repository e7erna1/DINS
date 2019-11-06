package com.example.MyWebApp.controllers;

import com.example.MyWebApp.dao.PersonManagementDAO;
import com.example.MyWebApp.dao.PersonManagementDAOImpl;
import com.example.MyWebApp.dao.Persons;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Class {@link DeleteBean} get all persons from database
 */

@ManagedBean(name = "gettingAll")
@SessionScoped
public class GetAllBean {

  private List<Persons> linkedList;

  /**
   * FacesContext gets context for this request, which will treatment. PersonManagementDAO gets
   * instance to interact with the database then get all persons from database. isValidationFailed
   * return true if everything ok.
   */

  public void getAllPerson() {
    try {
      PersonManagementDAO personManagementDAO = new PersonManagementDAOImpl();
      FacesContext context = FacesContext.getCurrentInstance();
      linkedList = personManagementDAO.getAllPersons();
      context.isValidationFailed();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public GetAllBean() {
  }

  public List<Persons> getLinkedList() {
    return linkedList;
  }

  public void setLinkedList(List<Persons> linkedList) {
    this.linkedList = linkedList;
  }
}
