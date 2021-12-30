package com.patternJava.behavioral.state.state_3;

public class Radio {
    private Station station;

    public void setStation(Station station) {
        this.station = station;
    }
    
    public void nextStation() {
        if (station instanceof UAStation) {
            setStation(new HitFMStation());
        } else if (station instanceof HitFMStation) {
            setStation(new RetroStation());
        } else if (station instanceof RetroStation) {
            setStation(new UAStation());
        }
    }

    public void play() {
        station.play();
    }
    
    
}
