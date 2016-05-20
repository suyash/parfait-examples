package com.parfait.counter;

import java.lang.management.ManagementFactory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.custardsource.parfait.DynamicMonitoringView;

public class Main {

    public static void setupArguments(String arguments) {
        for (String propertyAndValue: arguments.split(",")) {
            String[] tokens = propertyAndValue.split(":", 2);
            if (tokens.length == 2) {
                String name = MonitoringViewProperties.PARFAIT + "." + tokens[0];
                String value = tokens[1];
                System.setProperty(name, value);
            }
        }
    }

    public static void prepremain () {
        String runtimeName = ManagementFactory.getRuntimeMXBean().getName();
        // logger.debug(String.format("Agent runtime: %s [%s]", runtimeName, arguments));

        // extract properties from arguments, properties files, or intuition
        MonitoringViewProperties.setupProperties();
        // if (arguments != null) {
        //     setupArguments(arguments);
        // }

        String name = System.getProperty(MonitoringViewProperties.PARFAIT_NAME);
        // logger.debug(String.format("Starting Parfait agent %s", name));
    }

    public static void premain () throws Exception {
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
