package com.eduard.caloriecounter;

import android.app.Application;

import com.eduard.caloriecounter.dagger.component.AppComponent;
import com.eduard.caloriecounter.dagger.component.DaggerAppComponent;

public class AppCalories extends Application {

    private static AppComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .build();
        component.inject(this);
    }
    public static AppComponent getComponent() {
        return component;
    }
}
