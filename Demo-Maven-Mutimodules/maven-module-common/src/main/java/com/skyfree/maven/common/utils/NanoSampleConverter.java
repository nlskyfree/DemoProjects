package com.skyfree.maven.common.utils;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class NanoSampleConverter extends ClassicConverter{

    @Override
    public String convert(ILoggingEvent event) {
        long nowInNanos = System.nanoTime();
        return Long.toString(nowInNanos);
    }

}
