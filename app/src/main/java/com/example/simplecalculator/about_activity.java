package com.example.simplecalculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class about_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_layout);

        TextView linkedin = (TextView)findViewById(R.id.linkedin);
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myaccount = "https://www.linkedin.com/in/jtc0913/";
                Uri webaddress = Uri.parse(myaccount);

                Intent gotoMyAccount = new Intent(Intent.ACTION_VIEW, webaddress);
                if(gotoMyAccount.resolveActivity(getPackageManager()) != null) {
                    startActivity(gotoMyAccount);
                }
            }
        });
    }
}
