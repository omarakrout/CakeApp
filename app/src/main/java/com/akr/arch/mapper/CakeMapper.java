package com.akr.arch.mapper;

import com.akr.arch.mvp.model.Cake;
import com.akr.arch.mvp.model.CakesResponse;
import com.akr.arch.mvp.model.CakesResponseCakes;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Omar on 25/04/2017.
 */

public class CakeMapper {

    @Inject
    public CakeMapper() {
    }

    public List<Cake> mapCakes(CakesResponse response) {
        List<Cake> cakeList = new ArrayList<>();

        if (response != null) {
            CakesResponseCakes[] responseCakes = response.getCakes();
            if (responseCakes != null) {
                for (CakesResponseCakes cake : responseCakes) {
                    Cake myCake = new Cake();
                    myCake.setId(cake.getId());
                    myCake.setTitle(cake.getTitle());
                    myCake.setDetailDescription(cake.getDetailDescription());
                    myCake.setPreviewDescription(cake.getPreviewDescription());
                    myCake.setImageUrl(cake.getImage());
                    cakeList.add(myCake);
                }
            }
        }
        return cakeList;
    }
}
