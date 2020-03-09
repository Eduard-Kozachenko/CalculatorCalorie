package com.eduard.caloriecounter.di;

import com.eduard.caloriecounter.ActivityScope;
import com.eduard.caloriecounter.AppComponent;
import com.eduard.caloriecounter.presentation.fragments.CollectionFragment;

import dagger.Component;

@ActivityScope
@Component(modules = {PresentationModule.class}, dependencies = AppComponent.class )

public interface CalculatorComponents {

    void inject(CollectionFragment fragment);
}