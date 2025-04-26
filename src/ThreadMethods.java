public class ThreadMethods extends Thread{

    @Override
    public void run(){
            for (; ;){
                //Thread.sleep(100);
                System.out.println("Hello World!!!!!!");
            }
    }

    public static void main(String[] args) {
        ThreadMethods t1 = new ThreadMethods();
        ThreadMethods t2 = new ThreadMethods();
        t1.setDaemon(true);
        t1.start();

        //t2.start();
        //t1.interrupt(); // sleep interrupted
        System.out.println("Main done");
    }
}
