package com.epam.model;


public class User {

  private long userid;
  private String name;
  private String surname;
  private String email;
  private String lawstatus;


  public User() {
  }

  public User(long userid, String name, String surname, String email, String lawstatus) {
    this.userid = userid;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.lawstatus = lawstatus;
  }

  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
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


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getLawstatus() {
    return lawstatus;
  }

  public void setLawstatus(String lawstatus) {
    this.lawstatus = lawstatus;
  }

}
