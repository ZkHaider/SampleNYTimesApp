package com.samplenytimesapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samplenytimesapp.R;
import com.samplenytimesapp.adapters.ArticleAdapter;
import com.samplenytimesapp.api.models.Result;

import java.util.List;

/**
 * Created by ZkHaider on 7/2/15.
 */
public class ArticleFragment extends Fragment {

    private static ArticleFragment mArticleFragment;

    private RecyclerView mArticleRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArticleAdapter mArticleAdapter;
    private List<Result> mResults;

    public static ArticleFragment getInstance() {
        if (mArticleFragment == null)
            return mArticleFragment = new ArticleFragment();
        return mArticleFragment;
    }

    public void setResults(List<Result> results) {
        this.mResults = results;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_articles, null);
        initViews(root);
        return root;
    }

    private void initViews(View view) {
        mArticleRecyclerView = (RecyclerView) view.findViewById(R.id.articleRecyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mArticleRecyclerView.setHasFixedSize(true);
        mArticleRecyclerView.setLayoutManager(mLayoutManager);

        mArticleAdapter = new ArticleAdapter(getActivity());
        mArticleAdapter.setResults(mResults);

        mArticleRecyclerView.setAdapter(mArticleAdapter);
    }

}
