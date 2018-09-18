package com.willian.cortes.willmaterialdesign;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {
    private ActionBar actionBar = null;
    private Toolbar toolbar;

    private AppCompatButton btAlert;
    private AppCompatButton btDialogMultiItems;
    private AppCompatButton btDialogSingleItem;
    private AlertDialog alertDialog;

    private String[] arItems = {"Item 1", "Item 2", "Item 3", "Item 4"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogs_view);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getResources().getString(R.string.dialogs));

        btAlert = findViewById(R.id.btDialog);
        btAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exemploDialog();
            }
        });

        btDialogSingleItem = findViewById(R.id.btDialogSingleItems);
        btDialogSingleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exemploDialogSingleItem();
            }
        });

        btDialogMultiItems = findViewById(R.id.btDialogMultiItems);
        btDialogMultiItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exemploDialogMultiItems();
            }
        });
    }

    private void exemploDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialog);
        builder.setMessage(getResources().getString(R.string.deseja_excluir));
        builder.setPositiveButton(getResources().getString(R.string.sim), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DialogActivity.this, getResources().getString(R.string.sim), Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.nao), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DialogActivity.this, getResources().getString(R.string.nao), Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog = builder.create();
        alertDialog.show();
    }

    private void exemploDialogMultiItems() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.selecione_opcao_desejada));

        builder.setMultiChoiceItems(arItems, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                Toast.makeText(DialogActivity.this, arItems[i] + ": " + b, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton(getResources().getString(R.string.ok), null);
        builder.setNegativeButton(getResources().getString(R.string.cancelar), null);

        alertDialog = builder.create();
        alertDialog.show();
    }

    private void exemploDialogSingleItem() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.selecione_opcao_desejada));
        builder.setSingleChoiceItems(arItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DialogActivity.this, arItems[i], Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton(getResources().getString(R.string.ok), null);
        builder.setNegativeButton(getResources().getString(R.string.cancelar), null);

        alertDialog = builder.create();
        alertDialog.show();
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
