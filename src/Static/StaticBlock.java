package Static;

public class StaticBlock {
    static int a = 5;
    static int b;

    static {
        System.out.println("StaticInt init executed");
        b = a* 5;
    }

    static void main() {
        System.out.println("main() executed");
        StaticBlock staticBlock = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        b+=1;
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock staticBlock2 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

    }
}
