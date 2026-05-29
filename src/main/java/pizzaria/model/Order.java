package pizzaria.model;


import pizzaria.model.Client;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author letic
 */
public class Order {
    private Client client;
    private Pizza pizza;
    
    public Order(Client client, Pizza pizza){
        this.client = client;
        this.pizza = pizza;
        client.newOrder(this);
    }
}
