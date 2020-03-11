package com.eduard.caloriecounter.presentation.base;

public class BasePresenter<V extends BasePresenter.View> {

    private V view;

    protected V getView() {
        return view;
    }

    public void attachView(V view) {
        this.view = view;
    }

    private void detachView() {
        view = null;
    }

    public void release() {
        detachView();
    }

    public interface View {

        void showProgressBar();

        void showInformationDialog(String data);
    }
}
