package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderDetailActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewDrink;
    private TextView textViewTypeDrinks;
    private TextView textViewAdditives;
    
    private static final String EXTRA_USER_NAME = "username";
    private static final String EXTRA_DRINK = "drink";
    private static final String EXTRA_DRINK_TYPE = "drinkType";
    private static final String EXTRA_ADDITIVIES = "additivies";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        InitView2();
        Intent intent = getIntent();
        textViewName.setText(intent.getStringExtra(EXTRA_USER_NAME));
        textViewDrink.setText(intent.getStringExtra(EXTRA_DRINK));
        textViewTypeDrinks.setText(intent.getStringExtra(EXTRA_DRINK_TYPE));
        textViewAdditives.setText(intent.getStringExtra(EXTRA_ADDITIVIES));
    }




    public static Intent newIntent(
            Context context,
            String username,
            String drink,
            String drinkType,
            String additivies
    ){
        Intent intent = new Intent(context, OrderDetailActivity.class);
        intent.putExtra(EXTRA_USER_NAME, username);
        intent.putExtra(EXTRA_DRINK, drink);
        intent.putExtra(EXTRA_DRINK_TYPE, drinkType);
        intent.putExtra(EXTRA_ADDITIVIES, additivies);
        return intent;
    }
    private void InitView2(){
        textViewName = findViewById(R.id.textViewName);
        textViewDrink = findViewById(R.id.textViewDrink);
        textViewTypeDrinks = findViewById(R.id.textViewTypeDrinks);
        textViewAdditives = findViewById(R.id.textViewAdditives);
    }


}
