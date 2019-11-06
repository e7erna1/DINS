package com.example.MyWebApp.controllers;

import com.example.MyWebApp.dao.PersonManagementDAO;
import com.example.MyWebApp.dao.PersonManagementDAOImpl;
import com.example.MyWebApp.dao.Persons;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Class {@link DeleteBean} get persons from database
 */

@ManagedBean(name = "getting")
@ViewScoped
public class GetBean {

  private List<Persons> linkedList;
  private String select;
  private String value;

  /**
   * Calls the function of generating a request, depending on the selected parameter.
   *
   * @param select - param, that will used for search.
   */

  public void getPeron(String select) {
    switch (select) {
      case "Name":
        createQuery("name", value);
        break;
      case "Surname":
        createQuery("serName", value);
        break;
      case "Address":
        createQuery("address", value);
        break;
    }
  }

  /**
   * FacesContext gets context for this request, which will treatment. Method cheats SQL query to
   * database using options. Gets a list of persons who satisfy these parameters. isValidationFailed
   * return true if everything ok.
   *
   * @param str - param, that will used for search.
   * @param value - value, that will used for search.
   */

  private void createQuery(String str, String value) {
    FacesContext context = FacesContext.getCurrentInstance();
    PersonManagementDAO personManagementDAO = new PersonManagementDAOImpl();
    String val = ("SELECT p from Persons p where p." + str + "=\'" + value + "\'");
    linkedList = personManagementDAO.getByValPersons(val);
    context.isValidationFailed();
  }

  public GetBean() {

  }

  public String getSelect() {
    return select;
  }

  public void setSelect(String select) {
    this.select = select;
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
