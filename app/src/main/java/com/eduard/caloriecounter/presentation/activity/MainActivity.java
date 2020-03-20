package com.eduard.caloriecounter.presentation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.eduard.caloriecounter.R;
import com.eduard.caloriecounter.presentation.fragments.CollectionFragment;

import static com.eduard.caloriecounter.presentation.constants.AppConstants.ACTIVITY_REQUEST_CODE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        addFragment();
    }

//    private void addFragment() {
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        CollectionFragment infoFragment = new CollectionFragment();
//        transaction.add(R.id.fl_container,infoFragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
}
