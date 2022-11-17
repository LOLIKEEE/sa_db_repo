package sa.demo.practice;

import java.util.ArrayList;

public class OuterClass {
    String name = "Outer";

    public interface Sum {
        int sum(int a, int b);
    }
    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        arrayList.forEach(o -> {
        });

        doSomething((a,b) -> a + b);
    }

    public static void doSomething(Sum sum) {
        sum.sum(2,3);
    }
}
