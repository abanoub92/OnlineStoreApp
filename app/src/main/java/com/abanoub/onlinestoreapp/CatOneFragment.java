package com.abanoub.onlinestoreapp;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * this fragment responsible of represents data
 * of category one in list
 */
public class CatOneFragment extends Fragment {

    private static final String TAG = "CatOneFragment";

    @BindView(R.id.cat_one_data_list)
    RecyclerView mCatOneList;

    private Unbinder mUnbinder;

    private Activity mActivity;

    public CatOneFragment() {}

    /**
     * Use this factory method to create a new instance of
     * this fragment
     *
     * @return A new instance of fragment CatOneFragment.
     */
    public static CatOneFragment newInstance() {
        return new CatOneFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cat_one, container, false);

        mUnbinder = ButterKnife.bind(this, view);

        mActivity = Objects.requireNonNull(getActivity());

        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        mCatOneList.setHasFixedSize(true);
        mCatOneList.setLayoutManager(layoutManager);

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null)
            mUnbinder.unbind();
    }
}
