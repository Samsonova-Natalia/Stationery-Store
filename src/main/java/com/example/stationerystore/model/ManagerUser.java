package com.example.stationerystore.model;

public class ManagerUser extends User {
    private String managedStore;

    public ManagerUser(Long id, String username, String email, String managedStore){
        super(id, username, email, UserRole.MANAGER);
        this.managedStore = managedStore;
    }

    public String getManagedStore(){
        return managedStore;
    }
    public void setManagedStore(String managedStore){
        this.managedStore = managedStore;
    }

    @Override
    public String toString() {
        return super.toString()+", ManagerUser{managedStore='"+managedStore+"'}";
    }
}
