package com.willian.cortes.willmaterialdesign.Activitys;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.willian.cortes.willmaterialdesign.R;

public class SnackActivity extends AppCompatActivity {
    private ActionBar actionBar = null;
    private Toolbar toolbar;

    private FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snack_view);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getResources().getString(R.string.menu_snack));

        fab = findViewById(R.id.fab_snack);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Snackbar snackbar = Snackbar.make(view, getResources().getString(R.string.item_excluido), Snackbar.LENGTH_LONG);
                snackbar.setAction(getResources().getString(R.string.fechar), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();

                        Toast.makeText(SnackActivity.this, getResources().getString(R.string.snack_fechada), Toast.LENGTH_LONG).show();
                    }
                });

                //Customizando a SnackBar
                View snackView = snackbar.getView();
                TextView snackActionView = snackView.findViewById(android.support.design.R.id.snackbar_action);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    snackView.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark, null));
                    snackActionView.setTextColor(getResources().getColor(android.R.color.white, null));
                }

                snackbar.show();
            }
        });
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
}
