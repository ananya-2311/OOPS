package Interface;

public class Cat extends Dog implements Animal{
    String name;

    public Cat(String name) {
        this.name = name;
    }
    public Cat() {
        super();
    }

    @Override
    public void sound() {
        System.out.println("Meow Meow");
    }

    @Override
    public void name() {
        System.out.println("Cat");
    }

    public void printName(){
        System.out.println(this.name);
    }

}
