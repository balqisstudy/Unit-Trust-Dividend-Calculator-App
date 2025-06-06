package com.example.dividendcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.content.Intent;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText investedAmount, annualRate, months;
    Button calculateButton;
    TextView tvTotalDividend, tvMonthlyDividend;
    ImageButton navCalculator, navAbout;
    DecimalFormat formatter = new DecimalFormat("#0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        investedAmount = findViewById(R.id.investedAmount);
        annualRate = findViewById(R.id.annualRate);
        months = findViewById(R.id.months);
        calculateButton = findViewById(R.id.calculateButton);
        tvTotalDividend = findViewById(R.id.tvTotalDividend);
        tvMonthlyDividend = findViewById(R.id.tvMonthlyDividend);
        navCalculator = findViewById(R.id.navCalculator);
        navAbout = findViewById(R.id.navAbout);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDividend();
            }
        });

        navCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Stay on MainActivity (Home)
            }
        });

        navAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }

    private void calculateDividend() {
        try {
            double amount = Double.parseDouble(investedAmount.getText().toString());
            double rate = Double.parseDouble(annualRate.getText().toString()) / 100;
            int numMonths = Integer.parseInt(months.getText().toString());

            if (numMonths < 1 || numMonths > 12) {
                tvMonthlyDividend.setText("-");
                tvTotalDividend.setText("Months must be 1-12");
                return;
            }

            double monthlyDividend = (rate / 12) * amount;
            double totalDividend = monthlyDividend * numMonths;

            tvMonthlyDividend.setText(formatter.format(monthlyDividend));
            tvTotalDividend.setText(formatter.format(totalDividend));

        } catch (Exception e) {
            tvMonthlyDividend.setText("-");
            tvTotalDividend.setText("enter valid values");
        }
    }
}
