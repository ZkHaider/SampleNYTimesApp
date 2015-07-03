package com.samplenytimesapp.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.samplenytimesapp.R;
import com.samplenytimesapp.api.models.Result;
import com.samplenytimesapp.api.models.TopStories;
import com.samplenytimesapp.bus.BusProvider;
import com.samplenytimesapp.bus.events.LoadTopStories;
import com.samplenytimesapp.bus.events.LoadedTopStories;
import com.samplenytimesapp.fragments.ArticleFragment;
import com.squareup.otto.Subscribe;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BusProvider.getInstance().post(new LoadTopStories());
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        BusProvider.getInstance().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        BusProvider.getInstance().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /***
     *  Initialization Methods
     */

    private void initFragment(List<Result> results) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ArticleFragment articleFragment = ArticleFragment.getInstance();
        articleFragment.setResults(results);
        ft.replace(R.id.content, articleFragment);
        ft.commit();
    }

    /***
     *  Otto Subscription Methods
     */

    @Subscribe
    public void onLoadedTopStories(LoadedTopStories loadedTopStories) {
        TopStories topStories = loadedTopStories.getTopStories();
        List<Result> results = topStories.getResults();
        initFragment(results);
    }

}
