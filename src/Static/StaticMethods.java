package Static;

class StaticMethods {

    static int a = 5;
    static int b = 10;
    static int result;

    static void multiply() {
        result = a * b;
        System.out.println("multiply() executed");
        System.out.println("Result = " + result);
    }

    public static void main(String[] args) {

        System.out.println("Main started");

        // First call
        multiply();

        // Modify variables
        a = 20;
        b = 30;

        System.out.println("Values changed: a = " + a + ", b = " + b);

        // Second call
        multiply();
    }
}
