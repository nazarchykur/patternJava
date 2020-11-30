package com.patternJava.structural.flyweight.flyweight_1;

import java.util.HashMap;
import java.util.Map;

public class DeveloperFactory {
    public static final Map<String, Developer> DEVELOPERS = new HashMap<>();

    public Developer getDeveloperBySpeciality(String speciality) {
        Developer developer = DEVELOPERS.get(speciality);
        if (developer == null) {
            switch (speciality) {
                case "java":
                    System.out.println("Hiring Java developer...");
                    developer = new JavaDeveloper();
                    break;
                case "js":
                    System.out.println("Hiring JS developer...");
                    developer = new JSDeveloper();
                    break;
            }
            DEVELOPERS.put(speciality, developer);
        }
        return developer;
    }
}
