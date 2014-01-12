package com.corydominguez.tiptastic;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TipActivity extends ActionBarActivity {
    private EditText etBill;
    private TextView tvTip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip_activity);
        etBill = (EditText) findViewById(R.id.etBill);
        tvTip = (TextView) findViewById(R.id.tvTip);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("DEBUG", "onResume was just called!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("DEBUG", "onPause was just called!");
    }

    public void solveTip(View v) {
        BigDecimal percentage = new BigDecimal("0.00");
        if(v.getTag().equals("ten")) percentage = new BigDecimal("0.10");
        if(v.getTag().equals("fifteen")) percentage = new BigDecimal("0.15");
        if(v.getTag().equals("twenty")) percentage = new BigDecimal("0.20");

        BigDecimal bill;
        try {
            bill =  new BigDecimal(etBill.getText().toString());
        } catch (NumberFormatException e) {
            bill = new BigDecimal("0");
            Toast.makeText(this, "You need to input your bill", Toast.LENGTH_SHORT).show();
        }
        BigDecimal tip = bill.multiply(percentage);
        tvTip.setText("$" + tip.setScale(2, RoundingMode.CEILING).toString());
    }

}
