public class MyThread extends Thread{

    @Override
    public void run(){
            for (; ;){
                //Thread.sleep(100);
                System.out.println("Hello World!!!!!!");
            }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setDaemon(true);
        t1.start();

        //t2.start();
        //t1.interrupt(); // sleep interrupted
        System.out.println("Main done");
    }
}
