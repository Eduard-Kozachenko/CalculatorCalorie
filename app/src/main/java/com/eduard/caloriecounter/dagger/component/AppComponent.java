package com.eduard.caloriecounter.dagger.component;

import com.eduard.caloriecounter.AppCalories;
import com.eduard.caloriecounter.dagger.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Component (modules = {AppModule.class})
@Singleton
public interface AppComponent {

    void inject(AppCalories application);
}

