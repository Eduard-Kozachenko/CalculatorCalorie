package com.eduard.caloriecounter;

import android.app.Application;

import com.eduard.caloriecounter.dagger.component.AppComponent;
import com.eduard.caloriecounter.dagger.component.DaggerAppComponent;
import com.eduard.caloriecounter.dagger.module.AppModule;

public class AppCalories extends Application {

    private AppComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
    public AppComponent getComponent() {
        return component;
    }


}
