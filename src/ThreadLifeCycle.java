/**
 * use the same class for both threads
 */
public class ThreadLifeCycle extends Thread {

    @Override
    public void run(){
        System.out.println("RUNNING");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //create obj of the current class
        ThreadLifeCycle t1 = new ThreadLifeCycle();
        System.out.println(t1.getState()); //NEW
        //lets start the thread
        t1.start();
        System.out.println(t1.getState()); //RUNNABLE
        Thread.sleep(100); //making main method wait for sometime
        System.out.println(t1.getState()); //TIMED_WAITING
        //this is the sub thread (not main)/ as it is having 2 sec wait
        t1.join(); // waits for the t1 (run) thread to die, and continues afterwards
        System.out.println(t1.getState()); //TERMINATED (prints after waiting for t1 to complete its task and die)
    }
}
