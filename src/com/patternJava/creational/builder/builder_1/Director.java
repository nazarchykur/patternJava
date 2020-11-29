package com.patternJava.creational.builder.builder_1;

public class Director {
    WebsiteBuilder builder;

    public void setBuilder(WebsiteBuilder builder) {
        this.builder = builder;
    }

    Website buildWebsite() {
        builder.createWebsite();
        builder.buildName();
        builder.buildCms();
        builder.buildPrice();

//        Website website = builder.getWebsite();
//        return website;
        return builder.getWebsite();
    }
}
