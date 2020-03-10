package no.knowit.demo.funcjava.functechniques;

public class ClosureDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        // Although the behavior, doProcess() does not have defined variable b, it gets printed out due the closure
        doProcess(a, new Executor() {
            @Override
            public void execute(int i) {
                System.out.println(i + b);
            }
        });
    }

    public static void doProcess(int i, Executor executor) {
        executor.execute(i);
    }
}

interface Executor {
    void execute(int i);
}
