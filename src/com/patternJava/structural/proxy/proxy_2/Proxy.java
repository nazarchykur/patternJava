package com.patternJava.structural.proxy.proxy_2;

import java.util.ArrayList;
import java.util.List;

public class Proxy implements Internet {
    private Internet internet = new RealInternet();
    private static List<String> bannedSites = new ArrayList<>();

    static {
        bannedSites.add("www.twitter.com");
        bannedSites.add("www.instagram.com");
    }
    
    @Override
    public void connectTo(String server) throws Exception {
        if (bannedSites.contains(server)){
            throw new Exception("Access Denied to server: " + server);
        }
        internet.connectTo(server);
    }
}
