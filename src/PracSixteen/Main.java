package PracSixteen;

public class Main {
    public static void main(String[] args) {
        Item[] itemsArray = new Item[] {new Dish(390, "Philadelfia"), new Drink(190, "Sake"), new Dish(225.5, "Sashimi"), new Drink(690, "Bottle_of_wine")};
        InternetOrder order = new InternetOrder(itemsArray);
        order.show();
        order.add(new Drink(90, "Sake"));
        order.show();
        //order.removeAll("Sake");
        System.out.println(order.size());
        //order.show();
        Item [] itemsOrder = order.getItemsArray();
        for (int i = 0; i < order.size(); i++)
            System.out.print(itemsOrder[i] + " ");
        System.out.println(order.costTotal());
    }
}
