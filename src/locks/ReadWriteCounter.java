package locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {

    private int count = 0;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock writeLock = lock.writeLock();

    private final Lock readLock = lock.readLock();


    public void increment(){
        writeLock.lock();
        try{
            count++;
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {

    }
}
