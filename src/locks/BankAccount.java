package locks;

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
}
