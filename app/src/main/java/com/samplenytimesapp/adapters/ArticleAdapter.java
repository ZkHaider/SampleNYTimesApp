package com.samplenytimesapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.samplenytimesapp.R;
import com.samplenytimesapp.api.models.Multimedia;
import com.samplenytimesapp.api.models.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ZkHaider on 7/2/15.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    public static final String TAG = ArticleAdapter.class.getSimpleName();
    private static final String NORMAL = "Normal";

    private Context mContext;
    private List<Result> mResults;

    public ArticleAdapter(Context context) {
        this.mContext = context;
    }

    public void setResults(List<Result> results) {
        this.mResults = results;
    }

    public Result getResult(int position) {
        return mResults.get(position);
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.article_item, viewGroup, false);
        mContext = v.getContext();
        return new ArticleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder articleViewHolder, int position) {

        Result result = mResults.get(position);

        // Set Image
        List<Multimedia> multimediaList = result.getMultimedia();
        for (int i = 0, size = multimediaList.size(); i < size; i++) {
            Log.d(TAG, multimediaList.get(i).getFormattedUrl());
            if (multimediaList.get(i).getFormat().contains(NORMAL)) {
                String url = multimediaList.get(i).getFormattedUrl();
                Picasso.with(mContext)
                        .load(url)
                        .fit()
                        .centerCrop()
                        .into(articleViewHolder.mArticleImage);
            }
        }

        // Set Title
        String title = result.getTitle();
        Log.d(TAG, title);
        if (title != null)
            articleViewHolder.mArticleTitle.setText(title);

    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {

        private ImageView mArticleImage;
        private TextView mArticleTitle;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            mArticleImage = (ImageView) itemView.findViewById(R.id.articleImage);
            mArticleTitle = (TextView) itemView.findViewById(R.id.articleTitle);
        }
    }
}