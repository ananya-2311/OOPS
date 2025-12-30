package Inheritance;

public class Box {
    int l;
    int w;
    int h;
    private int side;

    public Box() {

    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    Box(int l, int w, int h) {
        this.l = l;
        this.w = w;
        this.h = h;
        System.out.println("Box has been created with 3 params");
    }

    Box(int l, int w, int h, int side) {
        this.l = l;
        this.w = w;
        this.h = h;
        this.side = side;
        System.out.println("Box has been created with 4 params");
    }

    Box(int l, int w) {
        this.l = l;
        this.w = w;
        System.out.println("Box has been created with 2 params");
    }

    Box(int l) {
        this.l = l;
        System.out.println("Box has been created with 1 params");
    }

    void shape() {
        System.out.println("I am from box");
    }

    void box() {
        System.out.println("I am from box method and box class");
    }

    public static void main(String[] args) {
        Box box = new Box(1, 2);
        System.out.println(box.l + " " + box.w + " " + box.h);

        Box b4 = new Box(1,1,2,2);
        System.out.println(b4.l + " " + b4.w + " " + b4.h + " " + b4.side);
    }
}
