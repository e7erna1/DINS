package com.example.MyWebApp.controllers;

import com.example.MyWebApp.dao.PersonManagementDAO;
import com.example.MyWebApp.dao.PersonManagementDAOImpl;
import com.example.MyWebApp.dao.Persons;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Class {@link EditBean} edit person in database.
 */

@ManagedBean(name = "edition")
@ViewScoped
public class EditBean {

  private List<Persons> linkedList;
  private String select;
  private String value;

  /**
   * FacesContext gets context for this request, which will treatment.
   * PersonManagementDAO gets instance to interact with the database then get list of person with introduced person's name.
   * isValidationFailed return true if everything ok.
   *
   * @param value -
   */

  public void Find(String value) {
    try {
      FacesContext context = FacesContext.getCurrentInstance();
      PersonManagementDAO personManagementDAO = new PersonManagementDAOImpl();
      linkedList = personManagementDAO.getPeron(value);
      context.isValidationFailed();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * FacesContext gets context for this request, which will treatment. PersonManagementDAO gets
   * instance to interact with the database then send new persons list. isValidationFailed return
   * true if everything ok.
   */

  public void Update() {
    try {
      FacesContext context = FacesContext.getCurrentInstance();
      PersonManagementDAO personManagementDAO = new PersonManagementDAOImpl();
      personManagementDAO.editPerson(linkedList);
      context.isValidationFailed();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void setSelect(String select) {
    this.select = select;
  }

  public String getSelect() {
    return select;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public List<Persons> getLinkedList() {
    return linkedList;
  }

  public void setLinkedList(List<Persons> linkedList) {
    this.linkedList = linkedList;
  }
}
