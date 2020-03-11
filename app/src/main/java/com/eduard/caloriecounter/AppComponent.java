package com.eduard.caloriecounter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton  @Component (modules = {AppModule.class})
public interface AppComponent {

    void inject(App application);
}

