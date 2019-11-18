package com.abanoub.onlinestoreapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.bottom_bar)
    BottomNavigationView bottomNavigationView;

    private Unbinder mUnbinder;

    private AllFragment mAllFragment;
    private CatOneFragment mCatOneFragment;
    private CatTwoFragment mCatTwoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUnbinder = ButterKnife.bind(this);

        changeBackground();

        //creating new instances of bottom navigation bar fragments
        mAllFragment = AllFragment.newInstance();
        mCatOneFragment = CatOneFragment.newInstance();
        mCatTwoFragment = CatTwoFragment.newInstance();

        //set the default fragment
        setFragment(mAllFragment);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(menuItem -> {
                            switch (menuItem.getItemId()){
                                case R.id.all_data:
                                    //if you wont to change background color depend on selected item
                                    //bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                                    Log.i(TAG, "You choose data of all");
                                    setFragment(mAllFragment);
                                    return true;

                                case R.id.cate_one:
                                    Log.i(TAG, "You choose data of category one");
                                    setFragment(mCatOneFragment);
                                    return true;

                                case R.id.cate_two:
                                    Log.i(TAG, "You choose data of category two");
                                    setFragment(mCatTwoFragment);
                                    return true;

                                default:
                                    return false;

                            }
                        });
    }

    /**
     * This method for moving between bottom navigation bar fragments
     * @param fragment that displayed on root view
     */
    private void setFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragments_root_view, fragment);
        transaction.commit();
    }


    private void changeBackground(){
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{0xFF616261,0xFF131313}
        );

        gradientDrawable.setCornerRadius(0f);
        bottomNavigationView.setBackground(gradientDrawable);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null)
            mUnbinder.unbind();
    }
}
