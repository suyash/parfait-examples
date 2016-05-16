import com.custardsource.parfait.MonitoredCounter;

public class Test implements Runnable {
    private MonitoredCounter counter;
    private int time = 1000;

    Test () {
        counter = new MonitoredCounter("test.counter", "A simple Counter");
    }

    public void run () {
        while (true) {
            try {
                counter.inc();
                System.out.println("Counter set to: " + counter.get());
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
