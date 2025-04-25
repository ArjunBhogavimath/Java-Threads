public class Temp extends Thread{
    @Override
    public void run() {
        for(; ;){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
