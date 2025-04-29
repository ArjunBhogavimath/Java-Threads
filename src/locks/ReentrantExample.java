package locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {

    private final Lock lock = new ReentrantLock();

    public void outerMethode(){
        lock.lock();
        try{
            System.out.println("Inside outer method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod(){
        lock.lock();
        try{
            System.out.println("Inside inner method");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample reentrantExample = new ReentrantExample();
        reentrantExample.outerMethode();
    }
}

/**
 * Reentrant is a way to avoid deadlock
 * as we seen in this above code,
 * both methods depends on each other to do the unlock()
 * if we were not using reentrantlock, it could have been a deadlock
 *
 * so what happens now is a single thread can have multiple lock
 * but the lock should have the corresponding unlock as well
 * if not this will throw an error
 */
