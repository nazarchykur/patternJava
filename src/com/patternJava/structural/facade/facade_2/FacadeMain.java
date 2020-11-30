package com.patternJava.structural.facade.facade_2;

public class FacadeMain {
    public static void main(String[] args) {
//        Power power = new Power();
//        power.on();
//        DVDRom dvdRom = new DVDRom();
//        dvdRom.load();
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvdRom);
        ComputerFacade computer = new ComputerFacade();
        computer.copy();
    }
}

class Power{
    void on() {
        System.out.println("Turn on PC.");
    }

    void off() {
        System.out.println("Turn off PC.");
    }
}
class DVDRom{
    private boolean data = false;

    public boolean hasData() {
        return data;
    }

    void load() {
        data = true;
    }

    void unload() {
        data = false;
    }
}
class HDD{
    void copyFromDVD(DVDRom dvdRom) {
        if (dvdRom.hasData()) {
            System.out.println("Copying data from disc.");
        } else {
            System.out.println("Please put disc with data.");
        }
    }
}
class ComputerFacade{
    Power power = new Power();
    DVDRom dvdRom = new DVDRom();
    HDD hdd = new HDD();

    void copy() {
        power.on();
        dvdRom.load();
        hdd.copyFromDVD(dvdRom);
    }
}