package com.akr.arch.api;

import com.akr.arch.mvp.model.CakesResponse;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Omar on 25/04/2017.
 */

public interface CakeApiService {

    @GET("58ff5708110000880ef5ff79")
    Observable<CakesResponse> getCakes();
}
