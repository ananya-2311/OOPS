package Inheritance;

public class BoxWeight extends Box {
    int weight;


    BoxWeight(int l, int w, int h) {
        System.out.println("BoxWeight has been created with 3 params");
        super(l, w, h);
    }

    public BoxWeight(int l, int w, int h, int weight) {
        System.out.println("BoxWeight has been created with 4 params");
        super(l, w, h);
        this.weight = weight;
    }

    public BoxWeight(int l, int w, int h, int side, int weight) {
        System.out.println("BoxWeight has been created with 4 params");
        super(l, w, h, side);
        this.weight = weight;
    }

//    BoxWeight(int l, int w) {
//        System.out.println("BoxWeight has been created with 2 params");
//        super(l, w);
//    }

    BoxWeight(int l, int weight) {
        super(l);
        this.weight = weight;
        System.out.println("BoxWeight has been created with equal sides and a weight of " + weight + "kg");
    }


    BoxWeight(int l) {
        System.out.println("BoxWeight has been created with 1 params");
        super(l);
    }

    void shape() {
        System.out.println("I am from BoxWeight");
    }

    void boxWeight() {
        System.out.println("I am from boxWeight method and boxWeight class");
    }

    public static void main(String[] args) {
        //BoxWeight boxWeight = new BoxWeight();
        //default constructor cannot be accessed if any other constructor is present
        // When a custom constructor (with or without arguments) is defined in a class, the default no-argument constructor is no longer automatically provided by the compiler [1]. If you want to be able to call the default constructor, you must explicitly define it yourself.

        BoxWeight boxWeight = new BoxWeight(1, 2,3,4,5);
        System.out.println(boxWeight.l + " " + boxWeight.w + " " + boxWeight.h + " " + boxWeight.getSide() + " " + boxWeight.weight);

        //boxWeight.side cannot be accessed as it is private. We need public methods to access it, hence we have used getSide()


    }
}
