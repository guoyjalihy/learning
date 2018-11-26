package com.xiao.designpatterns.observer.example.observer.impl;

import com.xiao.designpatterns.observer.example.observer.DisplayElement;
import com.xiao.designpatterns.observer.example.observer.Observer;
import com.xiao.designpatterns.observer.example.subject.Observable;
import com.xiao.designpatterns.observer.example.subject.domain.Weather;

/**
 * 展示当前温度观察者
 */
public class CurrentWeatherObserver implements Observer , DisplayElement {

    private Observable observable;
    public CurrentWeatherObserver(Observable obs){
        this.observable = obs;
        observable.registerObserver(this);
    }

    public void update(Object obj) {
        display((Weather) obj);
    }

    public void display(Weather weather) {
        System.out.println("我是当前温度。");
        System.out.println("温度：" + weather.getTemperature());
        System.out.println("湿度：" + weather.getHumidity());
        System.out.println("气压：" + weather.getPressure());
    }
}
