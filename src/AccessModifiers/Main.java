package AccessModifiers;

public class Main {
    static void main(String[] args) {
        Numbers n1 = new Numbers(1);
        System.out.println(n1.number);
        int n = n1.number;
        System.out.println(n);

        Numbers n2 = new Numbers(2, "Ananya");
        System.out.println(n2.number + " " + n2.name);


    }
}
