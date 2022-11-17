package sa.demo.practice;

public class CallableImpl implements Callable {

    @Override
    public String call() {
        return "abc";
    }
}
