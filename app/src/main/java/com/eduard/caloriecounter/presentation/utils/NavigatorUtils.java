package com.eduard.caloriecounter.presentation.utils;

import android.app.Activity;
import android.content.Intent;

import com.eduard.caloriecounter.presentation.constants.AppConstants;
import com.eduard.caloriecounter.presentation.fragments.CollectionFragment;
import com.eduard.caloriecounter.presentation.model.Note;

public class NavigatorUtils implements AppConstants {
    public static void redirectToEditTaskScreen(Activity activity, Note note) {
        Intent intent = new Intent(activity, CollectionFragment.class);
        intent.putExtra(INTENT_TASK, note);
        activity.startActivityForResult(intent, ACTIVITY_REQUEST_CODE);
    }
}
