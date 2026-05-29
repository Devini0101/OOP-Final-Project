package pizzaria.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
/**
 *
 * @author letic
 */
public class Client {
    private String name;
    private String lastName;
    private int phoneNumber;
    private ArrayList<Order> orders;
    
    public Client(String name, String lastName, int phoneNumber){
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    
    public void newOrder(Order order){
        orders.add(order);
    }
    
    
}
