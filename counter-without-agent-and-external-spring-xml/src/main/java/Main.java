import io.pcp.parfait.DynamicMonitoringView;
import io.pcp.parfait.MonitorableRegistry;

import io.pcp.parfait.pcp.PcpMonitorBridge;

import io.pcp.parfait.dxm.PcpMmvWriter;
import io.pcp.parfait.dxm.IdentifierSourceSet;

public class Main {
    public static void main (String args[]) {
        try {
            MonitorableRegistry registry = MonitorableRegistry.DEFAULT_REGISTRY;
            PcpMmvWriter writer = new PcpMmvWriter("Main", IdentifierSourceSet.DEFAULT_SET);
            PcpMonitorBridge bridge = new PcpMonitorBridge(writer);
            DynamicMonitoringView view = new DynamicMonitoringView(registry, bridge);
            view.start();

            Thread t = new Thread(new Counter());
            t.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
