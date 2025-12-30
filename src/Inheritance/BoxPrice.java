package Inheritance;

public class BoxPrice extends BoxWeight {
    int cost;

    public BoxPrice(int l, int w, int h, int weight, int cost) {
        super(l, w, h, weight);
        this.cost = cost;
    }

    public BoxPrice(int l, int weight) {
        super(l, weight);
    }

    public static void main(String[] args) {
        BoxPrice b = new BoxPrice(1, 1);
    }
}
