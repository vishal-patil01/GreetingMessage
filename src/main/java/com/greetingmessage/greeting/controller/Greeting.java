package com.greetingmessage.greeting.controller;

public class Greeting {
    private long incrementAndGet;
    private String format;

    public Greeting(long incrementAndGet, String format) {
        this.incrementAndGet = incrementAndGet;
        this.format = format;
    }

    public long getIncrementAndGet() {
        return incrementAndGet;
    }

    public void setIncrementAndGet(long incrementAndGet) {
        this.incrementAndGet = incrementAndGet;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
