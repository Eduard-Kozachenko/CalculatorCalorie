package com.eduard.caloriecounter.di.module;

import android.app.Application;

import com.eduard.caloriecounter.CalorieApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final CalorieApplication application;
    public ApplicationModule(CalorieApplication application) {
        this.application = application;
    }

    @Provides
    CalorieApplication provideCalorieApplication(){
        return application;
    }

    @Provides
    Application provideApplication(){
        return application;
    }
}
