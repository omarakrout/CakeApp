package com.akr.arch.mvp.view;

import com.akr.arch.mvp.model.Cake;

import java.util.List;

/**
 * Created by Omar on 25/04/2017.
 */

public interface MainView extends BaseView {

    void onCakeLoaded(List<Cake> cakes);

    void onShowDialog(String message);

    void onHideDialog();

    void onShowToast(String message);

    void onClearItems();
}
