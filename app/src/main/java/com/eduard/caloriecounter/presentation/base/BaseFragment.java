package com.eduard.caloriecounter.presentation.base;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    private BasePresenter basePresenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onInjection();
        onPrepareFragment(view);
        onPreparePresenter();
    }

    protected void onPreparePresenter() {

    }

    protected void onPrepareFragment(@NonNull View view) {

    }

    protected void onInjection() {

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        releasePresenter();
    }

    public void showInformationDialog(String information) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(information)
                .setCancelable(false)
                .setNeutralButton("OK", (dialog, which) -> dialog.dismiss());
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void attachPresenter(BasePresenter basePresenter, BasePresenter.View view) {
        this.basePresenter = basePresenter;
        this.basePresenter.attachView(view);
    }

    private void releasePresenter() {
        if (basePresenter != null) {
            basePresenter.release();
        }
    }
}
