package com.ncgroup.vehiclegenie.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class AddVehicle {
    private String Title;
    private String Sub_title;
    private int Price;
    private String brand;
    private String Model;
    private String Edition;
    private int Year;
    private String Condition;
    private String Transmission;
    private String Body;
    private String Fuel;
    private String Capacity;
    private String Mileage;
    private String Location;
    private String Description;
    private String Post_Url;
    private String Seller_Name;
    private String Seller_Type;
    private String Published_Date;
}
