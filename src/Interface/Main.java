package Interface;

public class Main {
    public static void main(String[] args) {
        Dog a = new Dog();
        a.sound();
        a.name();
        System.out.println("-----------------------------------");

        Cat c = new Cat();
        c.sound();
        c.name();
        System.out.println("-----------------------------------");

        Dog d1 = new Cat();
        d1.sound();
        d1.name();
        System.out.println("-----------------------------------");

        Dog d2 = new Cat("Sheeha");
        d2.sound();
        d2.name();
        d2.printName(); //this printed Sheesha
        System.out.println(d2.name); //this did not print anything- it is because variables do not follow polymorphism, but methods do
        System.out.println("-----------------------------------");

        Animal a1 = new Dog();
        a1.sound();
        a1.name();
        System.out.println("-----------------------------------");

        Animal a2 = new Cat();
        a2.sound();
        a2.name();
        System.out.println("-----------------------------------");

    }
}
