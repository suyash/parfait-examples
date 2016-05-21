import com.custardsource.parfait.dxm.IdentifierSourceSet;
import com.custardsource.parfait.dxm.MetricName;
import com.custardsource.parfait.dxm.PcpMmvWriter;
import com.custardsource.parfait.dxm.semantics.Semantics;

import javax.measure.unit.Unit;

public class Counter implements Runnable {
    public void run () {
        MetricName counter = MetricName.parse("counter[heroes]");

        PcpMmvWriter writer = new PcpMmvWriter("test.counter", IdentifierSourceSet.DEFAULT_SET);

        int val = 1;

        writer.addMetric(counter, Semantics.COUNTER, Unit.ONE, 1);

        try {
            while (true) {
                val += 1;
                writer.updateMetric(counter, val);
                System.out.println("val: " + val);

                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}