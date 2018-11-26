package com.xiao.designpatterns.observer.example.observer.impl;

import com.xiao.designpatterns.observer.example.observer.DisplayElement;
import com.xiao.designpatterns.observer.example.observer.Observer;
import com.xiao.designpatterns.observer.example.subject.Observable;
import com.xiao.designpatterns.observer.example.subject.domain.Weather;
import com.xiao.designpatterns.observer.example.subject.impl.WeatherData;

/**
 * 展示统计数据观察者
 */
public class StatisticsWeatherObserver implements Observer , DisplayElement {

    private Observable observable;
    public StatisticsWeatherObserver(Observable obs){
        this.observable = obs;
        observable.registerObserver(this);
    }

    public void update(Object obj) {
        display((Weather) obj);
    }

    public void display(Weather weather) {
        System.out.println("我是统计数据。");
        Float average = (weather.getTemperature()
                          + weather.getHumidity()
                          + weather.getPressure()) / 3 ;
        System.out.println("平均温度：" + average);
        System.out.println("平均湿度：" + average);
        System.out.println("平均气压：" + average);
    }
}
