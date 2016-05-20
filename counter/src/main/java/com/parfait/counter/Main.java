package com.parfait.counter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.pcp.parfait.DynamicMonitoringView;

public class Main {
    private static void premain() throws Exception {
        // String runtimeName = ManagementFactory.getRuntimeMXBean().getName();
        // logger.debug(String.format("Agent runtime: %s [%s]", runtimeName, arguments));

        // extract properties from arguments, properties files, or intuition
        MonitoringViewProperties.setupProperties();
        // if (arguments != null) {
        //     setupArguments(arguments);
        // }

        // String name = System.getProperty(MonitoringViewProperties.PARFAIT_NAME);
        // logger.debug(String.format("Starting Parfait agent %s", name));

        ApplicationContext context = new ClassPathXmlApplicationContext("agent.xml");
        DynamicMonitoringView view = (DynamicMonitoringView)context.getBean("monitoringView");
        view.start();
    }

    public static void main (String args[]) {
        try {
            premain();

            Thread t = new Thread(new Counter());
            t.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
