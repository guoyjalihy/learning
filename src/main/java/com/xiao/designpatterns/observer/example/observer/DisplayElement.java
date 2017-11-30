package com.xiao.designpatterns.observer.example.observer;

import com.xiao.designpatterns.observer.example.subject.domain.Weather;

/**
 * 展示天气信息接口
 */
public interface DisplayElement {
    void display(Weather weather);
}
