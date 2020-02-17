package com.eduard.caloriecounter;

import android.app.Application;

public class CalculatorApp extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        component.inject(this);

    }

    public static AppComponent getComponent() {
        return component;
    }
}
