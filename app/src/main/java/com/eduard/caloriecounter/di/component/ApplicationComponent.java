package com.eduard.caloriecounter.di.component;

import android.app.Application;

import com.eduard.caloriecounter.di.module.ActivityBindingModule;
import com.eduard.caloriecounter.di.module.ApplicationModule;
import com.eduard.caloriecounter.di.module.ContextModule;
import com.eduard.caloriecounter.presentation.base.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

@Singleton
@Component(modules = {ContextModule.class, ApplicationModule.class, AndroidSupportInjectionModule.class, ActivityBindingModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    void inject(BaseApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        ApplicationComponent build();
    }
}