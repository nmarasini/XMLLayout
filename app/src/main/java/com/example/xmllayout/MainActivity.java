package com.example.xmllayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    EditText txtCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = findViewById(R.id.rgTipAmount);
        txtCost = findViewById(R.id.txtCostOfService);
        Button btn = findViewById(R.id.btnCalculate);
        RadioButton rbOk = findViewById(R.id.rdoOk);
        TextView tvtip = findViewById(R.id.tvTipAmount);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double costOfService;
                double tipPercentage=0;
                double tipAmount;

               if(txtCost.getText().toString().equals("")){
                   txtCost.setError("Enter cost of service");
                   return;
               }
               int checkedId = rg.getCheckedRadioButtonId();
               if(checkedId<0){
                   rbOk.setError("Select service type");
                   return;
               }
               try {
                   costOfService = Double.valueOf(txtCost.getText().toString());
               } catch (Exception ex) {
                   txtCost.setError("Invalid cost of service");
                   return;
               }
               switch (checkedId){
                   case R.id.rdoAmazing:
                       tipPercentage = 0.20;
                       break;
                   case R.id.rdoGood:
                       tipPercentage= 0.18;
                       break;
                   case R.id.rdoOk:
                       tipPercentage = 0.15;
               }

               tipAmount = costOfService * tipPercentage;
               tvtip.setText(Double.toString(tipAmount));
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdoAmazing:
                        Toast.makeText(MainActivity.this, "Amazing clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdoGood:
                        Toast.makeText(MainActivity.this, "Good clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdoOk:
                        Toast.makeText(MainActivity.this, "Ok Clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}