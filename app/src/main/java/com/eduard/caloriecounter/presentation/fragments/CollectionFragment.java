package com.eduard.caloriecounter.presentation.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.eduard.caloriecounter.R;
import com.eduard.caloriecounter.presentation.activity.MainActivity;
import com.eduard.caloriecounter.presentation.base.BaseFragment;
import com.eduard.caloriecounter.presentation.model.User;
import com.eduard.caloriecounter.presentation.presenter.CollectionContract;
import com.eduard.caloriecounter.presentation.presenter.CollectionPresenter;
import com.eduard.caloriecounter.presentation.utils.Calculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class CollectionFragment extends BaseFragment implements CollectionContract.View {

//    @Inject
//    DialogInfoFragment alertDialogInfo;
//    @Inject
//    CollectionPresenter collectionPresenter;

    private TextView tvInfo;
    private Button btnGenerate;

    private CollectionContract.Presenter mPresenter;


    private CollectionPresenter presenter = new CollectionPresenter(new Calculator(), new User());
    private DialogFragment loadingFragment = DialogLoadingFragment.getInstance();

    @Override
    public void onPreparePresenter() {
        attachPresenter(presenter, this);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.collection_of_info_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

//    @Override
//    public void initView() {
//
//        tvInfo = tvInfo.findViewById(R.id.tv_info_test);
//        btnGenerate = btnGenerate.findViewById(R.id.btn_generate);
//        btnGenerate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                presenter.onClick(v);
//            }
//        });
//
//    }

    @Override
    public void updateUserInfo(String info) {
        tvInfo.setText(info);
    }

    @Override
    public void showProgressBar() {

        if (!loadingFragment.isVisible()) {
            loadingFragment.show(getActivity().getSupportFragmentManager(), "LOADING");
        }
    }

    @Override
    public void hideProgressBar() {

            if (loadingFragment.isVisible()) {
                loadingFragment.dismiss();
            }
    }

    @Override
    public void showError() {

    }


//    protected void onInjection() {
//        DaggerCalculatorComponents.builder()
//                .appComponent(CalculatorApp.getComponent())
//                .presentationModule(new PresentationModule())
//                .build()
//                .inject(this);
//    }

}
