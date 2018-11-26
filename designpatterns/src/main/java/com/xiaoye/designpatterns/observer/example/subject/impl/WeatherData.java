package com.xiao.designpatterns.observer.example.subject.impl;

import com.xiao.designpatterns.observer.example.observer.Observer;
import com.xiao.designpatterns.observer.example.subject.Observable;
import com.xiao.designpatterns.observer.example.subject.domain.Weather;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeatherData implements Observable {
    private Weather weather;
    private List<Observer> observerList = Collections.synchronizedList(new ArrayList<Observer>());
    public boolean registerObserver(Observer observer) {
        observerList.add(observer);
        return true;
    }

    public boolean removeObserver(Observer observer) {
        observerList.remove(observer);
        return true;
    }

    public boolean notifyObservers() {
        for (Observer observer : observerList){
            observer.update(weather);
        }
        return true;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
        notifyObservers();
    }
}
