package com.vvp.java;
// Generated Apr 1, 2019 8:58:21 PM by Hibernate Tools 4.3.1



/**
 * Student generated by hbm2java
 */
public class Student  implements java.io.Serializable {


     private Integer PId;
     private String PName;
     private float PEnroll;
     private int PSem;

    public Student() {
    }

    public Student(String PName, float PEnroll, int PSem) {
       this.PName = PName;
       this.PEnroll = PEnroll;
       this.PSem = PSem;
    }
   
    public Integer getPId() {
        return this.PId;
    }
    
    public void setPId(Integer PId) {
        this.PId = PId;
    }
    public String getPName() {
        return this.PName;
    }
    
    public void setPName(String PName) {
        this.PName = PName;
    }
    public float getPEnroll() {
        return this.PEnroll;
    }
    
    public void setPEnroll(float PEnroll) {
        this.PEnroll = PEnroll;
    }
    public int getPSem() {
        return this.PSem;
    }
    
    public void setPSem(int PSem) {
        this.PSem = PSem;
    }
}


