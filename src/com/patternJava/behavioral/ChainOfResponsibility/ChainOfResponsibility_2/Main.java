package com.patternJava.behavioral.ChainOfResponsibility.ChainOfResponsibility_2;

public class Main {
    public static void main(String[] args) {
        AuthenticationProcessor oAuthProcessor = new OAuthAuthenticationProcessor(null);
        AuthenticationProcessor unamePasswordProcessor = new UsernamePasswordAuthenticationProcessor(oAuthProcessor);

        boolean isAuthorized = unamePasswordProcessor.isAuthorized(new OAuthTokenProvider());
        System.out.println("isAuthorized = " + isAuthorized); // true

        boolean isAuthorized2 = unamePasswordProcessor.isAuthorized(new UsernamePasswordProvider());
        System.out.println("isAuthorized2 = " + isAuthorized2); // true

        boolean isAuthorized3 = unamePasswordProcessor.isAuthorized(new SamlAuthenticationProvider());
        System.out.println("isAuthorized3 = " + isAuthorized3); // false
    }
}
