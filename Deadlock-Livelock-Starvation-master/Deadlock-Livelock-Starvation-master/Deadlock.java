public class Deadlock { 
    private Object lock1 = new Object();
    private Object lock2 = new Object();
     private Object lock3 = new Object();
 
    public void Lock1_2_3() {
        synchronized (lock1) {
            System.out.println("Now Locking resource1");
            synchronized (lock2) {
                System.out.println("Now Locking resource2");
            }
            synchronized (lock3) {
                System.out.println("Now Locking resource3");
            }
        }
    }
 
    public void Lock2_1_3() {
        synchronized (lock2) {
            System.out.println("Now Locking resource2");
            synchronized (lock1) {
                System.out.println("Now Locking resource1");
            }
            synchronized (lock3) {
                System.out.println("Now Locking resource3");
            }
        }
    }
    public void Lock3_1_2() {
        synchronized (lock3) {
            System.out.println("Now Locking resource2");
            synchronized (lock1) {
                System.out.println("Now Locking resource1");
            }
            synchronized (lock2) {
                System.out.println("Now Locking resource2");
            }
        }
    }
}
