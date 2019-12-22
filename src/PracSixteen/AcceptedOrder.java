package PracSixteen;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AcceptedOrder extends JFrame {
    JList<String> orderList;
    DefaultListModel<String> model;
    JButton exec;
   public   AcceptedOrder(List<Item> order) {
       super("Your order");
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       model = new DefaultListModel<>();
       exec = new JButton("Accept");
       for(Item item : order) {
           model.add(0, item.toString() + " | Cost: " + item.getCost());
       }
       orderList = new JList<>(model);

       JScrollPane pane = new JScrollPane(orderList);
       this.setLayout(null);
       this.add(pane);
       this.add(exec);
       exec.addActionListener(e -> {
           double cost = 0;
           for(Item item : order) {
               cost += item.getCost();
           }
           JOptionPane.showMessageDialog(this, "Total cost " + cost);
       });
       exec.setBounds(20, 310, 80, 30);
       pane.setBounds(0, 0, 300, 300);
       this.setSize(300, 400);
       this.setVisible(true);
   }
   public  static  void  main(String[] args) {
       AcceptedOrder o = new AcceptedOrder(new ArrayList<>());
   }
}
