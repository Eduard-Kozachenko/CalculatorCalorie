package com.eduard.caloriecounter.presentation.base;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.eduard.caloriecounter.R;

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

//        builder.setMessage(information);
//        builder.setCancelable(true);
//
//        builder.setPositiveButton(
//                "Ok",
//                (dialog, id) -> dialog.cancel());
//
//        builder.setNegativeButton(
//                "Cancel",
//                (dialog, id) -> dialog.cancel());
//
//        AlertDialog alert = builder.create();
//        alert.show();

        builder.setTitle("Confirm Delete...");
        builder.setMessage("Are you sure you want delete this file?");
        builder.setIcon(R.drawable.ic_assignment_returned_black_24dp);
        builder.setPositiveButton("Ok",
                (dialog, which) -> {
                    Toast.makeText(getActivity(),
                            "You clicked on YES", Toast.LENGTH_SHORT)
                            .show();
                });

        builder.setNegativeButton("Cancel",
                (dialog, which) -> {
                    Toast.makeText(getActivity(),
                            "You clicked on NO", Toast.LENGTH_SHORT)
                            .show();
                    dialog.cancel();
                });

        builder.show();
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
