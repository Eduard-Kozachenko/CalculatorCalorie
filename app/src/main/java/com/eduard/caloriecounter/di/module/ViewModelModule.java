package com.eduard.caloriecounter.di.module;

import com.eduard.caloriecounter.presentation.utils.CalculationViewModel;
import com.eduard.caloriecounter.presentation.utils.NoteViewModel;
import com.eduard.caloriecounter.presentation.utils.ViewModelKey;

import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Singleton
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NoteViewModel.class)
    abstract ViewModel bindListViewModel(NoteViewModel listViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CalculationViewModel.class)
    abstract ViewModel bindDetailsViewModel(CalculationViewModel detailsViewModel);

//    @Binds
//    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
