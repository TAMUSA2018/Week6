//Starvation describes a situation where a greedy thread holds a resource for a long time so other threads are blocked forever.
public class Starvation {
 
    public synchronized void starvationRun() {
        String name = Thread.currentThread().getName();

        while (true) {
            System.out.println(name + " is working");
			/*try {
				wait(100);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
		    }*/
        }
    }
}
