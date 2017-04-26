package com.akr.arch.mvp.view.activity.details;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.akr.example.R;
import com.akr.arch.mvp.view.activity.BaseActivity;
import com.akr.arch.helper.ImageHandler;
import com.akr.arch.mvp.model.Cake;
import butterknife.Bind;


/**
 * Created by Omar on 25/04/2017.
 */

public class DetailActivity extends BaseActivity {

    public static final String CAKE = "cake";

    @Bind(R.id.cakeImage) protected ImageView mCakeImage;
    @Bind(R.id.cakeTitle) protected TextView mCakeTitle;
    @Bind(R.id.cakeDescription) protected TextView mCakeDescription;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mCakeImage.setTransitionName("cakeImageAnimation");
        }

        showBackArrow();

        Cake cake = (Cake) intent.getSerializableExtra(CAKE);
        setTitle("Cake Detail");

        mCakeTitle.setText(cake.getTitle());
        mCakeDescription.setText(cake.getDetailDescription());

        Glide.with(this).load(cake.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(new ImageHandler(mCakeImage));
    }

    @Override
    protected void resolveDaggerDependency() {
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_detail;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
