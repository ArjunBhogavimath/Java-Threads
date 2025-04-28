package locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance = 100;

    //create lock object with reentrantlock class impl
    private final Lock lock = new ReentrantLock();

    /**
     *
     * whenever we use synchronized keyword
     * the lock will  be applied on this method, so till this method finishes its execusion
     * it may take a lot of time, until that time the next thread will be blocked,
     * it will be keep on waiting indefinitely.
     * to avoid this we need to use the locks manually
     *
     */
    public synchronized void synchronizedWithdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " Attempting to withdraw " + amount);
        if(balance >= amount){
            System.out.println(Thread.currentThread().getName() + " Proceeding with the Withdrawal");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {

            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " Completed withdrawal, Remaining balance is : " + balance);
        }
        else {
            System.out.println(Thread.currentThread().getName() + "Insufficient balance");
        }
    }


    /**
     * 1. lock.tryLock() : if we use this it will only allow when the lock is free/avaialble, otherwise will return false directly
     * doesn't wait
     * 2. lock.tryLock(1000, TimeUnit.MILLISECONDS) : Will wait for the particular time, if within the time, the lock released,
     * then it will go ahead with the method, otherwise will goto else part
     *
     * 3. lock.unlock() : will unlock the lock acquired and let next thread to take over
     *
     * 4. Thread.currentThread().interrupt(); : this is a good practice where we are restoring the thread state to interrupt
     * so we can able to perform monitoring operations after we know its interrupted
     *
     * we should restore this in catch block, when the current operation failed
     */
    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + "Attempting to withdraw " + amount);
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                if(balance >= amount){
                    System.out.println(Thread.currentThread().getName() + " Proceeding with the Withdrawal");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    //need to free the lock which is acquired
                    finally {
                        lock.unlock();
                    }
                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() + " Completed withdrawal, Remaining balance is : " + balance);
                }
                else {
                    System.out.println(Thread.currentThread().getName() + "Insufficient balance");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "Could not acquire the lock, will try later");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if(Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName() + " Thread is interrupted");
        }
    }
}
