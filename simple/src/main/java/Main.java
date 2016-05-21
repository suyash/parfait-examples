import com.custardsource.parfait.dxm.IdentifierSourceSet;
import com.custardsource.parfait.dxm.MetricName;
import com.custardsource.parfait.dxm.PcpMmvWriter;
import com.custardsource.parfait.dxm.semantics.Semantics;

import javax.measure.unit.Unit;

public class Main {
    public static void main (String... args) throws Exception {
        MetricName counter = MetricName.parse("counter[heroes]");
        MetricName instance = MetricName.parse("instance[heroes]");
        MetricName discrete = MetricName.parse("discrete[heroes]");

        PcpMmvWriter writer = new PcpMmvWriter("test.simple", IdentifierSourceSet.DEFAULT_SET);

        writer.addMetric(counter, Semantics.COUNTER, Unit.ONE, 1);
        writer.addMetric(instance, Semantics.INSTANT, Unit.ONE, 0);
        writer.addMetric(discrete, Semantics.DISCRETE, Unit.ONE, 0);

        writer.start();
    }
}
