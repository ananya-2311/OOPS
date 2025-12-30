package Abstract;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SubClass2 subClass2 = new SubClass2();
        subClass2.sleep();

        SubClass3 subClass3 = new SubClass3();
        subClass3.sleep();

        SubClass subClass4 = new SubClass();
        subClass4.sleep();
        List<String> l1 = new ArrayList<>();
        Object o = new Object();
    }
}
