package com.eduard.caloriecounter.di.module;

import com.eduard.caloriecounter.presentation.activity.MainActivity;
import com.eduard.caloriecounter.presentation.main.MainFragmentBindingModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainFragmentBindingModule.class})
    abstract MainActivity bindMainActivity();
}
