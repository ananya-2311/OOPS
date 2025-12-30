package Interface;

public class Dog implements Animal {
    String name;

    @Override
    public void sound() {
        System.out.println("Bhau Bhau");
    }

    @Override
    public void name() {
        System.out.println("Dog");
    }

    public void printName(){
        System.out.println(this.name);
    }
}
