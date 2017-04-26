package com.akr.arch.mvp.presenter;

import com.akr.arch.api.CakeApiService;
import com.akr.arch.mapper.CakeMapper;
import com.akr.arch.mvp.model.Cake;
import com.akr.arch.mvp.model.CakesResponse;
import com.akr.arch.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

/**
 * Created by Omar on 25/04/2017.
 */

public class CakePresenter extends BasePresenter<MainView> implements Observer<CakesResponse> {

    @Inject protected CakeApiService mApiService;
    @Inject protected CakeMapper mCakeMapper;

    @Inject
    public CakePresenter() {
    }

    public void getCakes() {
        getView().onShowDialog("Loading cakes....");
        Observable<CakesResponse> cakesResponseObservable = mApiService.getCakes();
        subscribe(cakesResponseObservable, this);
    }

    @Override
    public void onCompleted() {
        getView().onHideDialog();
        getView().onShowToast("Cakes loading complete!");
    }

    @Override
    public void onError(Throwable e) {
        getView().onHideDialog();
        getView().onShowToast("Error loading cakes " + e.getMessage());
    }

    @Override
    public void onNext(CakesResponse cakesResponse) {
        List<Cake> cakes = mCakeMapper.mapCakes(cakesResponse);
        getView().onClearItems();
        getView().onCakeLoaded(cakes);
    }
}
