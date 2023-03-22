package com.patternJava.structural.proxy.proxy_2;

public class Main {
    public static void main(String[] args) {
        Internet internet = new Proxy();
        tryToConnect(internet, "www.learnjava.com"); // Connecting to www.learnjava.com
        tryToConnect(internet, "www.instagram.com"); // Access Denied to server: www.instagram.com
    }

    private static void tryToConnect(Internet internet, String nameOfSite) {
        try {
            internet.connectTo(nameOfSite);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
