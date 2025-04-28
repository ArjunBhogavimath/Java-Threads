package locks;

public class Main {

    public static void main(String[] args) {
        BankAccount sbi = new BankAccount();

        //Created thread with the runnable object, the runnable is an interface, so we need to create an anonymous class
        Runnable task = new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(50);
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");

        t1.start();
        t2.start();
    }
}
