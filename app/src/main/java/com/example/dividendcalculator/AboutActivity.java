package com.example.dividendcalculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        LinearLayout githubButton = findViewById(R.id.githubButton);
        githubButton.setOnClickListener(v -> {
            String url = "https://github.com/balqisstudy/Unit-Trust-Dividend-Calculator-App";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        ImageButton navCalculator = findViewById(R.id.navCalculator);
        ImageButton navAbout = findViewById(R.id.navAbout);

        navCalculator.setOnClickListener(v -> {
            Intent intent = new Intent(AboutActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
        // navAbout does nothing (already on About page)
    }
}
