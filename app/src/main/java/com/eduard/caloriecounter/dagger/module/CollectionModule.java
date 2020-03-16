package com.eduard.caloriecounter.dagger.module;

import com.eduard.caloriecounter.dagger.scope.ActivityScope;
import com.eduard.caloriecounter.presentation.presenter.CollectionPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class CollectionModule {

    @ActivityScope
    @Provides
    public CollectionPresenter providePresenter(CollectionPresenter presenter) {
        return presenter;
    }
}
