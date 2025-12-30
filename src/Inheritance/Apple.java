package Inheritance;

public class Apple extends Fruit {
    String fruitName;
    String quality;

    public Apple(String fruitName, int fruitWeight, String fruitName1, String quality) {
        super(fruitName, fruitWeight);
        this.fruitName = fruitName1;
        this.quality = quality;
    }

    Apple(String fruitName, String quality) {
        super();
        this.fruitName = fruitName;
        this.quality = quality;
    }
}
