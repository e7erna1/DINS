package com.example.MyWebApp.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class describe entity {@link Persons} This entity is the object with which our program
 * works. This class is a POJO.
 */

@Entity
@Table(name = "persons")
public class Persons implements Serializable {

  /**
   * This field {@link id} is an identifier in the database.
   */

  @Id
  @GeneratedValue
  @Column(name = "identity")
  private long id;

  /**
   * This field {@link name} describes name.
   */

  @Column(name = "first_name")
  private String name;

  /**
   * This field {@link serName} describes surname.
   */

  @Column(name = "second_name")
  private String serName;

  /**
   * This field {@link date} describes birthday.
   */

  @Column(name = "birthday")
  private Date date;

  /**
   * This field {@link address} describes address.
   */

  @Column(name = "address")
  private String address;

  /**
   * All the rest methods is support methods for functioning database.
   */

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSerName() {
    return serName;
  }

  public void setSerName(String serName) {
    this.serName = serName;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Persons() {

  }

  Persons(String name) {
    this.name = name;
  }

  Persons(String name, String serName, Date date, String address) {
    this.name = name;
    this.serName = serName;
    this.date = date;
    this.address = address;
  }

  @Override
  public String toString() {
    return "Persons{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", serName='" + serName + '\'' +
        ", date=" + date +
        ", address='" + address + '\'' +
        '}';
  }
}