package sa.demo.exception;

import java.io.FileNotFoundException;

public class MainClass {

    public static void main(String[] args) {
        try {
            doSomething();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception file) {

        } finally {

        }
        System.out.println("abc");

    }

    public static void doSomething() throws Exception {
        throw new Exception();
    }
}
