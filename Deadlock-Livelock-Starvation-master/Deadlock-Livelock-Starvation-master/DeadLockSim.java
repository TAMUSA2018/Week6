/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ialsmadi
 */
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class DeadLockSim extends Thread{
	
	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	
	private void justAsimpleMethod() {
		for(int i=0; i<1000; i++) {
			count++;
		}
	}
	public void Thread1() throws InterruptedException {
		lock.lock();
		
		System.out.println("Thread1 starts");
		cond.await();
		
		
		
		try {
			justAsimpleMethod();
                        System.out.println(" Thread1 Locking method");
                      //  Thread.sleep(2000);
		} finally {
			lock.unlock();
                         System.out.println("Thread1 UnLocking method");
		}
	}
	
	public void Thread2() throws InterruptedException {
		//Thread.sleep(1000);
		lock.lock();
		
		System.out.println("Thread2 starts");
		//new Scanner(System.in).nextLine(); 
		//System.out.println("Return key was just clicked!");
		
		cond.signal();
		
		try {
			justAsimpleMethod();
                        System.out.println("Thread2 Locking method");
		} finally {
			lock.unlock();
                         System.out.println("Thread2 UnLocking method");
		}
	}
	
	public void finished() {
		System.out.println("Count is: " + count);
	}
}
