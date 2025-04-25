public class Main {
    public static void main(String[] args){
        System.out.println("Hello World!!!");

        Temp t1 = new Temp();
        t1.start();

        for (; ;){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
