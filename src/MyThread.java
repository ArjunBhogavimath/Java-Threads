public class MyThread extends Thread{

    //rename the thread name
    public MyThread(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Arjun");
        t1.start();
    }
}
