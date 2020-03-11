package com.eduard.caloriecounter.presentation.fragments;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.eduard.caloriecounter.R;
import com.eduard.caloriecounter.presentation.base.BaseFragment;
import com.eduard.caloriecounter.presentation.presenter.CollectionContract;
import com.eduard.caloriecounter.presentation.presenter.CollectionPresenter;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CollectionFragment extends BaseFragment implements CollectionContract.View, View.OnClickListener, AdapterView.OnItemSelectedListener {

//    @Inject
//    CollectionPresenter presenter;

    private CollectionContract.Presenter presenter;
    private DialogFragment loadingFragment = DialogLoadingFragment.getInstance();

    @Override
    public void onPreparePresenter() {
        attachPresenter((CollectionPresenter) presenter, this);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.collection_of_info_fragment, container, false);

        presenter = new CollectionPresenter();

        Spinner spinLevel = v.findViewById(R.id.spin_Lvl_activity);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity(),R.array.heading_level_activity,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinLevel.setAdapter(adapter);
        spinLevel.setOnItemSelectedListener(this);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().findViewById(R.id.btn_generate).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText etWeight=getView().findViewById(R.id.et_Weight);
        EditText etHeight=getView().findViewById(R.id.et_Height);
        EditText etAge=getView().findViewById(R.id.et_Age);
        RadioButton rb_Male = getView().findViewById(R.id.rb_Male);
        RadioButton rb_Female = getView().findViewById(R.id.rb_Female);
        Spinner spinLevel = getView().findViewById(R.id.spin_Lvl_activity);

        String strUserW = etWeight.getText().toString();
        String strUserH = etHeight.getText().toString();
        String strUserA = etAge.getText().toString();

        if(TextUtils.isEmpty(strUserW) || TextUtils.isEmpty(strUserH) || TextUtils.isEmpty(strUserA) ) {
            Toast.makeText(getActivity(),"Not all fields are filled correctly",Toast.LENGTH_LONG).show();
            return;
        }else if (rb_Male.isChecked() == true) {
            showProgressBar();
            presenter.collectionInfoMale(Double.valueOf(strUserW),
                    Double.valueOf(strUserH),
                    Double.valueOf(strUserA),
                    Integer.valueOf(spinLevel.getSelectedItemPosition()));
        }else if(rb_Female.isChecked() == true) {
            showProgressBar();
            presenter.collectionInfoFemale(Double.valueOf(strUserW),
                    Double.valueOf(strUserH),
                    Double.valueOf(strUserA),
                    Integer.valueOf(spinLevel.getSelectedItemPosition()));
        }
    }

    @Override
    public void showProgressBar() {
        CountDownTimer cdt = new CountDownTimer(3000, 1000) {
            int i = 3;
            public void onTick(long millisUntilFinished) {
                if (!loadingFragment.isVisible()) {
                    loadingFragment.show(getActivity().getSupportFragmentManager(), "LOADING");
                }
                i--;
            }
            public void onFinish() {
                if (loadingFragment.isVisible()) {
                    loadingFragment.dismiss();
                }
            }
        }.start();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Spinner spinLevel = getView().findViewById(R.id.spin_Lvl_activity);
        if(i > 0) {
            Toast.makeText(getActivity(), spinLevel.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
