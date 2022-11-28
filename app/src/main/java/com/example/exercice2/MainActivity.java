package com.example.exercice2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //region Variables
    private EditText height;
    private EditText weight;
    //private EditText age;
    private SeekBar age;
    private RadioButton men;
    private RadioButton women;
    private TextView meta;
    //endregion

    /**
     * Event lors de la creation de l'activité
     *
     * @param savedInstanceState Bundle
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Debug", "Let's go");

        MyListener listener = new MyListener();

        Button btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(listener);

        Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(listener);

        age = (SeekBar) findViewById(R.id.seekAge);
        age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TextView age = (TextView) findViewById(R.id.txtProgress);
                age.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    /**
     * Calcul du metabolisme de base
     *
     * @param view Contecte
     */
    public void calculate(View view) {
        height = (EditText) findViewById(R.id.editHeight);
        weight = (EditText) findViewById(R.id.editWeight);
        //age = (EditText) findViewById(R.id.editAge);

        men = (RadioButton) findViewById(R.id.buttonMen);
        women = (RadioButton) findViewById(R.id.buttonWomen);
        meta = (TextView) findViewById(R.id.txtMeta);

        if (height.getText().toString().equals("") || weight.getText().toString().equals("") || age.getProgress() == 0) {
            Toast.makeText(this, "Merci de remplir tous les champs", Toast.LENGTH_SHORT).show();
        } else {
            if (men.isChecked()) {
                Homme homme = new Homme(Integer.parseInt(height.getText().toString()), Double.parseDouble(weight.getText().toString()), age.getProgress());
                meta.setText(String.format("%s", homme.getMeta()));
            } else if (women.isChecked()) {
                Femme femme = new Femme(Integer.parseInt(height.getText().toString()), Double.parseDouble(weight.getText().toString()), age.getProgress());
                meta.setText(String.format("%s", femme.getMeta()));
            }
        }

    }

    /**
     * Efface les champs
     *
     * @param view Contexte
     */
    public void clear(View view) {
        height = (EditText) findViewById(R.id.editHeight);
        weight = (EditText) findViewById(R.id.editWeight);
        age = (SeekBar) findViewById(R.id.seekAge);
        meta = (TextView) findViewById(R.id.txtMeta);

        height.setText("");
        weight.setText("");
        age.setProgress(0);
        meta.setText("");
    }

    /**
     * Listener pour les boutons
     */
    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnCalculate:
                    calculate(view);
                    break;
                case R.id.btnClear:
                    clear(view);
                    break;
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_other:
                Toast.makeText(this, "Other menu", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_settings:
                Toast.makeText(this, "Settings menu", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
