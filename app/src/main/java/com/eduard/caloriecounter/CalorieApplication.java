package com.eduard.caloriecounter;

import android.app.Application;

import com.eduard.caloriecounter.di.component.ApplicationComponent;
import com.eduard.caloriecounter.di.component.DaggerApplicationComponent;
import com.eduard.caloriecounter.di.module.ApplicationModule;
import com.eduard.caloriecounter.di.module.RoomModule;

public class CalorieApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .roomModule(new RoomModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
