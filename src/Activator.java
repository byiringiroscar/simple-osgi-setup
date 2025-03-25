package com.example.hello;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
    @Override
    public void start(BundleContext context) {
        System.out.println("Hello OSGi Bundle Started!");
    }

    @Override
    public void stop(BundleContext context) {
        System.out.println("Hello OSGi Bundle Stopped!");
    }
}
