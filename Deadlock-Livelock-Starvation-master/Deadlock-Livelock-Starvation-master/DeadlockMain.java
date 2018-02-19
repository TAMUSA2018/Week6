import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class DeadlockMain {
    private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
    public void deadRun() {
        Deadlock deadlock = new Deadlock();
 

    Thread t1 = new Thread(new Runnable() {
        public void run() {
            lock.lock();
            System.out.println("Thread 1 is running");
            deadlock.Lock1_2_3();
            try {
			simpleMethod();
		} finally {
		//	lock.unlock();
		}
			          
		}
    });

    t1.start();

    Thread t2 = new Thread(new Runnable() {
        public void run() {
             lock.lock();
            System.out.println("Thread 2 is running, locking");
            deadlock.Lock2_1_3();
			try {
			simpleMethod();
		} finally {
			//lock.unlock();
                         System.out.println("unlocking");
		}
        }
    });

    t2.start();
    Thread t3 = new Thread(new Runnable() {
        public void run() {
             lock.lock();
            System.out.println("Thread 3 is running, locking");
            deadlock.Lock3_1_2();
			try {
			simpleMethod();
		} finally {
		//	lock.unlock();
                         System.out.println("unlocking");
		}
        }
    });

    t3.start();

}
     

	private void simpleMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


	
