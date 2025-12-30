public class swapNumbers {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        swap(a, b);

        System.out.println("a from main "+ a);
        System.out.println("b from main "+b);
    }

    static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;

        System.out.println("a from method " + a);
        System.out.println("b from method "+ b);
    }

}
