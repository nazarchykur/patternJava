package com.patternJava.creational.singleton.singleton_1;

public class ProgramLogger {
    private static ProgramLogger programLogger;
    public static String logFile = "this is logfile. \n\n";

    public static synchronized ProgramLogger getProgramLogger() {
        if (programLogger == null) {
            programLogger = new ProgramLogger();
        }
        return programLogger;
    }
    private ProgramLogger() {
    }

    public void addLogInfo(String logInfo) {
        logFile += logInfo + "\n";
    }

    public void showLogFile() {
        System.out.println(logFile);
    }
}
