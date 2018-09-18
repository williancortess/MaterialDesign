package com.willian.cortes.willmaterialdesign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SelectionControlsActivity extends AppCompatActivity{
    private ActionBar actionBar = null;
    private Toolbar toolbar;

    private SwitchCompat switchCompat;
    private AppCompatCheckBox checkBox;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_controls_view);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getResources().getString(R.string.menu_controls));

        switchCompat = findViewById(R.id.switch_liga_desliga);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(SelectionControlsActivity.this, getResources().getString(R.string.ligado), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(SelectionControlsActivity.this, getResources().getString(R.string.desligado), Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBox = findViewById(R.id.cb_sorvete);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(SelectionControlsActivity.this, getResources().getString(R.string.gosto_de_sorvete), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(SelectionControlsActivity.this, getResources().getString(R.string.nao_gosto_de_sorvete), Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_opcao1:{
                        Toast.makeText(SelectionControlsActivity.this, getResources().getString(R.string.opcao1), Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.rb_opcao2:{
                        Toast.makeText(SelectionControlsActivity.this, getResources().getString(R.string.opcao2), Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.rb_opcao3:{
                        Toast.makeText(SelectionControlsActivity.this, getResources().getString(R.string.opcao3), Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
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
