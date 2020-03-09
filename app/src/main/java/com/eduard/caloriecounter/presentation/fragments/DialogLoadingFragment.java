package com.eduard.caloriecounter.presentation.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eduard.caloriecounter.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogLoadingFragment extends DialogFragment {

    public static DialogFragment getInstance() {
        DialogLoadingFragment dialogLoadingFragment = new DialogLoadingFragment();
        dialogLoadingFragment.setCancelable(false);
        return dialogLoadingFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.progress_loading, container, false);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.DialogTheme);
    }
}
