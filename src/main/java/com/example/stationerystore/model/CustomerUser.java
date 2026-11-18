package com.example.stationerystore.model;

public class CustomerUser extends User {
    private int loyaltyPoints;

    public CustomerUser(Long id, String username, String email, int loyaltyPoints){
        super(id, username, email, UserRole.CUSTOMER);
        this.loyaltyPoints = loyaltyPoints;
    }

    public int getLoyaltyPoints(){
        return loyaltyPoints;
    }
    public void setLoyaltyPoints(int loyaltyPoints){
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString(){
        return super.toString()+", CustomerUser{loyaltyPoints="+loyaltyPoints+"}";
    }
}
