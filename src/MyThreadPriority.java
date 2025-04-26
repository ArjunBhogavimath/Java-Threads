public class MyThreadPriority extends Thread{

    //rename the thread name
    public MyThreadPriority(String name){
        super(name);
    }

    @Override
    public void run(){
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        MyThreadPriority tH = new MyThreadPriority("High Priority");
        MyThreadPriority tM = new MyThreadPriority("Medium Priority");
        MyThreadPriority tL = new MyThreadPriority("Low Priority");
        tH.setPriority(Thread.MAX_PRIORITY); //max priority given for this
        tM.setPriority(Thread.NORM_PRIORITY); //medium priority given for this
        tL.setPriority(Thread.MIN_PRIORITY); //min priority given for this
        tH.start();
        tM.start();
        tL.start();
    }
}
