package com.example.stationerystore.model;

public class AdminUser extends User {
    private String department;

    public AdminUser(Long id, String username, String email, String department){
        super(id, username, email, UserRole.ADMIN);
        this.department = department;
    }

    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department;
    }

    @Override
    public String toString(){
        return super.toString()+", AdminUser{department='"+department+"'}";
    }
}
