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
        MyThread tH = new MyThread("High Priority");
        MyThread tM = new MyThread("Medium Priority");
        MyThread tL = new MyThread("Low Priority");
        tH.setPriority(Thread.MAX_PRIORITY); //max priority given for this
        tM.setPriority(Thread.NORM_PRIORITY); //medium priority given for this
        tL.setPriority(Thread.MIN_PRIORITY); //min priority given for this
        tH.start();
        tM.start();
        tL.start();
    }
}
