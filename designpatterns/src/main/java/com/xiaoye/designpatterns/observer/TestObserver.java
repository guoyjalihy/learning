package com.xiao.designpatterns.observer;

import com.xiao.designpatterns.observer.example.observer.Observer;
import com.xiao.designpatterns.observer.example.observer.impl.CurrentWeatherObserver;
import com.xiao.designpatterns.observer.example.observer.impl.ForecastWeatherObserver;
import com.xiao.designpatterns.observer.example.observer.impl.StatisticsWeatherObserver;
import com.xiao.designpatterns.observer.example.subject.domain.Weather;
import com.xiao.designpatterns.observer.example.subject.impl.WeatherData;

public class TestObserver {
    public static void main(String[] args) throws Exception{

        WeatherData weatherData = new WeatherData();
        Observer currentWeatherObserver = new CurrentWeatherObserver(weatherData);
        Observer forecastWeatherObserver = new ForecastWeatherObserver(weatherData);
        Observer statisticsWeatherObserver = new StatisticsWeatherObserver(weatherData);

        Weather weather = new Weather();
        weather.setHumidity(80.0f);
        weather.setPressure(90.0f);
        weather.setTemperature(30.0f);
        weatherData.setWeather(weather);

        weatherData.removeObserver(forecastWeatherObserver);
        weatherData.setWeather(weather);
    }
}
