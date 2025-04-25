public class Main {
    public static void main(String[] args){
        System.out.println("Hello World!!!");

        Temp t = new Temp();
        //while implementing Runnable interface we need to pas the Temp class object to new Thread's constructor
        Thread t1 = new Thread(t);
        t1.start();

        for (; ;){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
