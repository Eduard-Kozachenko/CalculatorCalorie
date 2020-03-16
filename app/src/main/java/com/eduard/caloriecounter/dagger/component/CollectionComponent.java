package com.eduard.caloriecounter.dagger.component;

import com.eduard.caloriecounter.dagger.module.CollectionModule;
import com.eduard.caloriecounter.dagger.scope.ActivityScope;
import com.eduard.caloriecounter.presentation.fragments.CollectionFragment;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {
        CollectionModule.class
})
public interface CollectionComponent {
    void inject(CollectionFragment fragment);
}
