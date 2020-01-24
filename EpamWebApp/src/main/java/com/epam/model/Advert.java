package com.epam.model;


public class Advert {

  private long userId;
  private long advertid;
  private String title;
  private String advbody;
  private String category;
  private String phonenumber;
  private String date;

  public Advert() {
  }

  public Advert(long userId, long advertid, String title, String advbody, String category, String phonenumber, String date) {
    this.userId = userId;
    this.advertid = advertid;
    this.title = title;
    this.advbody = advbody;
    this.category = category;
    this.phonenumber = phonenumber;
    this.date = date;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getAdvertid() {
    return advertid;
  }

  public void setAdvertid(long advertid) {
    this.advertid = advertid;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getAdvbody() {
    return advbody;
  }

  public void setAdvbody(String advbody) {
    this.advbody = advbody;
  }


  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }


  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

}
