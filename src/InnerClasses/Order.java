package InnerClasses;

public class Order {

    static class Item {
        String name;
        int price;

        Item(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }

    static void main(String[] args) {
        Item i = new Item("A", 10);
    }
}