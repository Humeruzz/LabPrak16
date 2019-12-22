package PracSixteen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderWindow extends JFrame {
    List<Item> listOfProducts;
    DefaultListModel<String> productsListModel;
    JList<String> productsTable;
    JButton add;
    JButton exec;
    List<Item> order;
    public OrderWindow() {
        order = new ArrayList<>();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listOfProducts = Arrays.asList(new Dish(390, "Burger"), new Drink(100, "Water"), new Dish(150.5, "Fried Potato"), new Drink(150, "Coca-cola"), new Dish( 222.2, "Pizza"), new Dish(72.15, "Cake"), new Drink(129.9, "Tea"));
        this.setLayout(null);
        productsListModel = new DefaultListModel<>();
        for(Item product : listOfProducts) {
            productsListModel.add(0, product.toString());
        }
        productsTable = new JList<>(productsListModel);
        productsTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane pane = new JScrollPane(productsTable);
        add = new JButton("add");
        exec = new JButton("order");
        this.add(pane);
        this.add(add);
        this.add(exec);
        add.setBounds(25, 310, 80, 30);
        exec.setBounds(125, 310, 80, 30);
        pane.setSize(250, 300);
        setSize(250, 400);

        add.addActionListener(e -> {
            int[] indexes =  productsTable.getSelectedIndices();
            for(Item item : listOfProducts) {
                for(int index : indexes) {
                    if (item.getName() == productsTable.getModel().getElementAt(index)) {
                        order.add(item);
                    }
                }
            }
        });
        exec.addActionListener(e -> {
            AcceptedOrder or = new AcceptedOrder(order);
            this.setVisible(false);
        });
        this.setVisible(true);
    }
    public static void main(String[] args) {
        OrderWindow w = new OrderWindow();
    }
}
