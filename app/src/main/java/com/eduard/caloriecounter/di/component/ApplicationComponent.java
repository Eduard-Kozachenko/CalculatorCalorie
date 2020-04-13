package com.eduard.caloriecounter.di.component;

import android.app.Application;

import com.eduard.caloriecounter.di.module.ApplicationModule;
import com.eduard.caloriecounter.di.module.RoomModule;
import com.eduard.caloriecounter.presentation.activity.AddEditNoteActivity;
import com.eduard.caloriecounter.presentation.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, RoomModule.class})
public interface ApplicationComponent {

    void inject(AddEditNoteActivity addNoteActivity);
    void inject(MainActivity mainActivity);

    Application application();
}