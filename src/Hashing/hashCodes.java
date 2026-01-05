package Hashing;

public class hashCodes {
    static void main(String[] args) {
        int x = 67;
        Integer y = 67;
        Integer z = 67;
        System.out.println(Integer.hashCode(x)); //67
        System.out.println(y.hashCode()); //67
        System.out.println(z.hashCode()); //67

        boolean a = true;
        boolean n = true;
        boolean b = false;
        System.out.println(Boolean.hashCode(a)); //1231
        System.out.println(Boolean.hashCode(n)); //1231
        System.out.println(Boolean.hashCode(b)); //1237

        char test = 'a';
        char test2 = 'a';
        char test3 = 'z';
        System.out.println(test == test2);
        System.out.println(Character.hashCode(test)); //97
        System.out.println(Character.hashCode(test2)); //97
        System.out.println(Character.hashCode(test3)); //122

        long abc = 1234567890L;
        long abc2 = 1234567891L;
        long abc3 = 1234567892L;
        System.out.println(Long.hashCode(abc)); //1234567890
        System.out.println(Long.hashCode(abc2)); //1234567891
        System.out.println(Long.hashCode(abc3)); //1234567892

        float t1 = 123.456f;
        float t2 = 123.457f;
        float t3 = 123.458f;
        System.out.println(Float.hashCode(t1));
        System.out.println(Float.hashCode(t2));
        System.out.println(Float.hashCode(t3));
//        1123477881
//        1123478012
//        1123478143
        //These floats produce different hash codes because they are representable with distinct IEEE-754 bit patterns,
        // and Float.hashCode() simply returns those raw bits as an integer.



    }
}
