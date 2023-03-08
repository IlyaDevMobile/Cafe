package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MakeOdredActivity extends AppCompatActivity {

    private TextView textViewgreetings;
    private RadioGroup radiogroupDrinks;
    private RadioButton radioButtonTea;
    private TextView textViewAdditives;
    private RadioButton radioButtonCofe;
    private CheckBox checkboxSugar;
    private CheckBox checkboxMilk;
    private CheckBox checkboxLemon;
    private Spinner spinnerTea;
    private Spinner spinnerCofe;
    private Button buttonCreateZakaz;
    private String drink;
    private String username;

    private static final String EXTRA_USER_NAME = "username";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_odred);
        initViews();
        setupUserName();

        radiogroupDrinks.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int id) {
                if(id == radioButtonTea.getId()){
                    onUserTea();

                } else if (id == radioButtonCofe.getId()){
                    onUserCofe();

                }

            }
        });
        radioButtonTea.setChecked(true);

        buttonCreateZakaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onUserMakeOrder();


            }
        });

    }



    private void onUserMakeOrder(){
        ArrayList<String>additivies= new ArrayList<>();
        if(checkboxSugar.isChecked()){
            additivies.add(checkboxSugar.getText().toString());
        }
        if(radioButtonTea.isChecked() && checkboxLemon.isChecked()){
            additivies.add( checkboxLemon.getText().toString());
        }
        if(checkboxMilk.isChecked()){
            additivies.add(checkboxMilk.getText().toString());
        }

        String drinkType = "";
        if (radioButtonTea.isChecked()){
            drinkType = spinnerTea.getSelectedItem().toString();
        }else if (radioButtonCofe.isChecked()){
            drinkType = spinnerCofe.getSelectedItem().toString();
        }

        Intent intent = OrderDetailActivity.newIntent(this,
                username,
                drink,
                drinkType,
                additivies.toString());
        startActivity(intent);

    }
    private void onUserTea(){
        drink = getString(R.string.tea);
        String additiviesLavel = getString(R.string.what_add_user, drink);
        textViewAdditives.setText(additiviesLavel);
        checkboxLemon.setVisibility(View.VISIBLE);
        checkboxMilk.setVisibility(View.VISIBLE);
        checkboxSugar.setVisibility(View.VISIBLE);
        spinnerTea.setVisibility(View.VISIBLE);
        spinnerCofe.setVisibility(View.INVISIBLE);

    }
    private void onUserCofe(){
        drink = getString(R.string.cofe);
        String additiviesLavel = getString(R.string.what_add_user, drink);
        textViewAdditives.setText(additiviesLavel);
        checkboxLemon.setVisibility(View.INVISIBLE);
        checkboxMilk.setVisibility(View.VISIBLE);
        checkboxSugar.setVisibility(View.VISIBLE);
        spinnerCofe.setVisibility(View.VISIBLE);
        spinnerTea.setVisibility(View.INVISIBLE);


    }


    private void setupUserName(){
        username = getIntent().getStringExtra(EXTRA_USER_NAME);
        String greenigns = getString(R.string.greenigns, username);
        textViewgreetings.setText(greenigns);
    }


    public static Intent newIntent(Context context,String username){
        Intent intent = new Intent(context, MakeOdredActivity.class);
        intent.putExtra(EXTRA_USER_NAME, username);
        return intent;
    }
    private void initViews(){
        textViewgreetings = findViewById(R.id.textViewgreetings);
        radiogroupDrinks = findViewById(R.id.radiogroupDrinks);
        radioButtonTea = findViewById(R.id.radioButtonTea);
        radioButtonCofe = findViewById(R.id.radioButtonCofe);
        textViewAdditives = findViewById(R.id.textViewAdditives);
        checkboxSugar = findViewById(R.id.checkboxSugar);
        checkboxMilk = findViewById(R.id.checkboxMilk);
        checkboxLemon = findViewById(R.id.checkboxLemon);
        spinnerTea = findViewById(R.id.spinnerTea);
        spinnerCofe = findViewById(R.id.spinnerCofe);
        buttonCreateZakaz = findViewById(R.id.buttonCreateZakaz);

    }


}