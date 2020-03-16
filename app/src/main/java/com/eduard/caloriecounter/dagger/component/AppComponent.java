package com.eduard.caloriecounter.dagger.component;

import android.app.Application;
import android.content.Context;

import com.eduard.caloriecounter.AppCalories;
import com.eduard.caloriecounter.dagger.module.AppModule;
import com.eduard.caloriecounter.presentation.fragments.CollectionFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton  @Component (modules = {AppModule.class} )public
interface AppComponent {

    void inject(AppCalories application);

    void inject(CollectionFragment fragment);
}

