package Inheritance;

public class Main {
    static void main(String[] args) {
        //Box initialisation
        System.out.println("Box has been created.");
        Box box = new Box(2,3,4);
        System.out.println(box.l + " " + box.w + " " + box.h);

        Box box2 = new Box(2,3);
        System.out.println(box2.l + " " + box2.w + " " + box2.h);

        Box box3 = new Box(2);
        System.out.println(box3.l + " " + box3.w + " " + box3.h);
        box3.box();
        box3.shape();
        //box3.boxWeight(); This is not allowed

        System.out.println("-----------------------------------------------------------------------------------------");

        //BoxWeight initialisation
        System.out.println("BoxWeight has been created");
        BoxWeight boxWeight = new BoxWeight(2, 5 , 4,5 );
        System.out.println(boxWeight.l + " " + boxWeight.w + " " + boxWeight.h + " " + boxWeight.weight);

        BoxWeight boxWeight2 = new BoxWeight(2, 5 , 4);
        System.out.println(boxWeight2.l + " " + boxWeight2.w + " " + boxWeight2.h + " " + boxWeight2.weight);

        BoxWeight boxWeight3 = new BoxWeight(2, 5 );
        System.out.println(boxWeight3.l + " " + boxWeight3.w + " " + boxWeight3.h + " " + boxWeight3.weight);

        BoxWeight boxWeight4 = new BoxWeight(2);
        System.out.println(boxWeight4.l + " " + boxWeight4.w + " " + boxWeight4.h + " " + boxWeight4.weight);

        BoxWeight boxWeight5 = new BoxWeight(2);
        boxWeight5.shape();

        BoxWeight boxWeight6 = new BoxWeight(2);
        boxWeight6.shape();
        boxWeight6.box();
        boxWeight6.boxWeight();
        System.out.println("-----------------------------------------------------------------------------------------");

        //Box b = new BoxWeight()
        Box b1 = new BoxWeight(2, 5 , 4,5 );
        //System.out.println(b1.l + " " + b1.w + " " + b1.h + b1.weight);
        //b1.weight is not recognised because Box class doesn't have weight parameter.
        System.out.println(b1.l + " " + b1.w + " " + b1.h);
        b1.shape();
        b1.box();
        //b1.boxWeight(); This is not allowed as the method boxWeight is not present in Box class, and reference is created using box class

        Box b2 = new BoxWeight(2, 5 , 4 );
        System.out.println(b2.l + " " + b2.w + " " + b2.h);

        Box b3 = new BoxWeight(2, 5 );
        System.out.println(b3.l + " " + b3.w + " " + b3.h);

        Box b4 = new BoxWeight(2);
        System.out.println(b4.l + " " + b4.w + " " + b4.h);

        System.out.println("-----------------------------------------------------------------------------------------");

        //BoxWeight bw = new Box();
        //BoxWeight bx1 = new Box(2, 3, 4);
        //above is not allowed

        Fruit fruit1 = new Fruit("Apple", 1);
        System.out.println(fruit1.fruitName + " " + fruit1.fruitWeight);
        System.out.println("-----------------------------------------------------------------------------------------");

        Fruit fruit2 = new Apple("Apple", "good");
        System.out.println(fruit2.fruitName + " " + fruit2.fruitWeight);

    }
}
