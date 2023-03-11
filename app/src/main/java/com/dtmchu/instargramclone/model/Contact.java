package com.dtmchu.instargramclone.model;

public class Contact {
    private int mId;
    private String mName;
    private String mPhoneNumber;
    public Contact(){   }
    public Contact(int id,String name, String phoneNumber) {
        this.mId = id;
        this.mName = name;
        this.mPhoneNumber = phoneNumber;
    }
    public Contact(String name, String phoneNumber) {
        this.mName = name;
        this.mPhoneNumber = phoneNumber;
    }
    public int getID(){
        return this.mId;
    }

    public void setID(int id){
        this.mId = id;
    }

    public String getName(){
        return this.mName;
    }

    public void setName(String name){
        this.mName = name;
    }

    public String getPhoneNumber(){
        return this.mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.mPhoneNumber = phoneNumber;
    }

}
