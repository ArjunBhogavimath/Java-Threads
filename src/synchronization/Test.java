package synchronization;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(); // single instance of counter
        MyThread t1 = new MyThread(counter); //need to pass the counter so we can assign counter value in MyThread class
        MyThread t2 = new MyThread(counter);
        //created 2 threads, both will use same instance of counter object
        t1.start();
        t2.start();
        System.out.println("before Join : " + counter.getCount()); //this is showing as 0 because the main thread is not waiting for t1 and t2 to finish its work
        //to wait till t1 and t2 finishes we use join
        t1.join();
        t2.join();
        System.out.println(counter.getCount());
        //now we are getting random value under 2000, because there maybe some cases
        // where both threads perform same operation at once, so we lost that action of 2nd thread
        // to avoid this we use synchronized block or keyword
        //with this the synchronized method will only allow  thread at once
        // so we dont loose any operation
    }
}
