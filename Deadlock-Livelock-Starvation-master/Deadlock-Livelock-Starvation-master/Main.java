
import java.util.Scanner;
class Main {
    static void tryLock() throws Exception{
      
		
		final DeadLockSim DLock = new DeadLockSim();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					DLock.Thread1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					DLock.Thread2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		DLock.finished();
	}

    
	public static void main(String[] args) {
    /*       try{
            tryLock();
           }
           catch(Exception ex){
               
           } */
		int process;
		String processString;
		Scanner scanner = new Scanner(System.in);

		System.out.println("1) Deadlock");
		System.out.println("2) Livelock");
		System.out.println("3) Starvation");
		System.out.print("Please pick a valid choice: ");

		try {
			processString = scanner.nextLine();		
			process = Integer.parseInt(processString);
		

			if(process == 1) {
				DeadlockMain deadlockMain = new DeadlockMain();
				deadlockMain.deadRun();
			}
			else if(process == 2) {
				LivelockMain livelockMain = new LivelockMain();
				livelockMain.liveRun();
			}
			else if(process == 3) {
				StarvationMain starvationMain = new StarvationMain();
				starvationMain.starRun();
			
			}
			else {
				System.out.println("Please pick a valid choice");				
			}

		}
		catch(NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Format exception.");
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("General exception.");
		}

		double startTime = System.currentTimeMillis();

		while(true) {
			if(System.currentTimeMillis() - 5000 > startTime) {
				System.exit(0);	
			}
		}
	}
}
