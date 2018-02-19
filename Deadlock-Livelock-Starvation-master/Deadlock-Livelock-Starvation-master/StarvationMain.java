public class StarvationMain {
 
    public static void starRun() {
        Starvation starvation = new Starvation();
 
		for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                public void run() {
                    starvation.starvationRun();
                }
            }).start();
        }
    }
}
