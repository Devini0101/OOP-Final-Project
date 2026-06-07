/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pizzaria;
import java.util.ArrayList;
import pizzaria.model.Pizza;
import pizzaria.model.Client;
import pizzaria.model.Order;
import pizzaria.model.PriceTable;
import java.util.NoSuchElementException;
import pizzaria.view.SignupClient;
import javax.swing.JFrame;

/**
 *
 * @author letic
 * @author Vinicius Dias
 */
public class Pizzaria {
    private ArrayList<Order> orders;
    private ArrayList<Client> clients;
    private PriceTable priceTable;

    public void newOrder(Client client, Pizza pizza){
        if (!clients.contains(client)) {
            throw new NoSuchElementException("Client not found");
        }
        int id = orders.size();
        Order order = new Order(client, pizza, id);
        client.newOrder(order);
    }

    public void cancelOrder(Order order){
        if (!orders.contains(order)){
            throw new NoSuchElementException("Order not found");
        }
        orders.remove(order);
    }

    public String getOrders(){
        String result = "";
        for (Order order : this.orders) {
            result += order.getId() + "  "
                    +  order.getClient().getName() + "  "
                    + order.getPrice(this.priceTable);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Client> clientList = new ArrayList<>();
        JFrame screen = new JFrame("Pizzaria - Sistema de Cadastro");
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setSize(800, 600);
        screen.setLocationRelativeTo(null);

        SignupClient telaCadastro = new SignupClient( clientList , -1, null); // -1 == cadastro de cliente
        screen.add(telaCadastro);

        screen.setVisible(true);
    }


}
