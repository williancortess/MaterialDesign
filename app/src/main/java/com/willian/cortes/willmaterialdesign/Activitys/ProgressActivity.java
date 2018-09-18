package com.willian.cortes.willmaterialdesign;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

public class ProgressActivity extends AppCompatActivity{
    private ProgressBar circularBar;
    private ProgressBar linearBar;

    private ActionBar actionBar = null;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_view);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getResources().getString(R.string.menu_progress));

        circularBar = findViewById(R.id.circularBar);
        circularBar.setVisibility(View.GONE);

        linearBar = findViewById(R.id.linearBar);
        linearBar.setVisibility(View.GONE);
        linearBar.setProgress(0);
        linearBar.setSecondaryProgress(0);
        linearBar.setMax(100);

        new AsyncCircular().execute();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public class AsyncCircular extends AsyncTask<Void, Integer, Void>{
        @Override
        protected void onPreExecute() {
            circularBar.setVisibility(View.VISIBLE);
            linearBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            for(int i = 0; i < 100; i++){
                try {
                    publishProgress(i); //Chama Progress Update
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            linearBar.setProgress(values[0]);
            linearBar.setSecondaryProgress(values[0] + 15);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            circularBar.setVisibility(View.GONE);
            linearBar.setVisibility(View.GONE);
        }
    }
}
