package FunctionalInterface;

public class EvenFilter implements Filter, Operands {
    @Override
    public boolean test(int x) {
        return x%2==0;
    }

    @Override
    public int calculate(int x, int y) {
        return x+y;
    }

    public int calculateSubtract(int x, int y) {
        return x-y;
    }

    public int calculateMultiply(int x, int y) {
        return x*y;
    }

    static void main(String[] args) {
        int x = 7;
        EvenFilter evenFilter = new EvenFilter();
        //Explicit function needed to check condition
        System.out.println(evenFilter.test(x));

        //condition written in one line
        Filter even = a -> a % 2 == 0;
        System.out.println(even.test(x));

        //Operands
        int num1 = 4;
        int num2 = 5;
        Operands plus = (a,b) -> a+b;
        Operands minus = (a,b) -> a-b;
        Operands multiply = (a,b) -> a*b;
        Operands divide = (a,b) -> a/b;
        System.out.println(plus.calculate(num1, num2));
        System.out.println(minus.calculate(num1, num2));
        System.out.println(multiply.calculate(num1, num2));
        System.out.println(divide.calculate(num1, num2));

        EvenFilter evenFilter2 = new EvenFilter();
        System.out.println(evenFilter2.calculate(num1, num2));
        System.out.println(evenFilter2.calculateSubtract(num1, num2));
        System.out.println(evenFilter2.calculateMultiply(num1, num2));
    }

}
