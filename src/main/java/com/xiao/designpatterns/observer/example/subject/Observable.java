package com.xiao.designpatterns.observer.example.subject;

import com.xiao.designpatterns.observer.example.observer.Observer;

/**
 * 被观察者接口
 */
public interface Observable {
    boolean registerObserver(Observer observer);
    boolean removeObserver(Observer observer);
    boolean notifyObservers();
}
