package com.eduard.caloriecounter.presentation.main;

import com.eduard.caloriecounter.presentation.activity.AddEditNoteActivity;
import com.eduard.caloriecounter.presentation.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract MainActivity provideListFragment();

    @ContributesAndroidInjector
    abstract AddEditNoteActivity provideDetailsFragment();
}
