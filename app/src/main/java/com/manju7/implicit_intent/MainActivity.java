package com.manju7.implicit_intent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonW, buttonE, buttonG, buttonC , buttonS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonW = (Button) findViewById(R.id.buttonW);
        buttonE = (Button) findViewById(R.id.buttonE);
        buttonG = (Button) findViewById(R.id.buttonG);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonS = (Button) findViewById(R.id.buttonS);

        buttonW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("smsto:" + "7892202787");
                Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                i.setPackage("com.whatsapp");
                startActivity(i);
            }
        });

        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });

        buttonG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://www.google.com"));
                startActivity(i);
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:7892202787"));




                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }



                startActivity(intent);


            }
        });

        buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:7892202787"));
                intent.putExtra("sms_body", "Hi");
                startActivity(intent);
            }
        });

    }

    private void sendMail(){

         String to="manjuakalawadi@gmail.com";
         String sub="subject";
         String message="message";

         Intent intent = new Intent(Intent.ACTION_SEND);
         intent.putExtra(Intent.EXTRA_EMAIL,"manjuakalawadi@gmail.com");
         intent.putExtra(Intent.EXTRA_SUBJECT,"Subject");
         intent.putExtra(Intent.EXTRA_TEXT,"message");

         intent.setType("message/rfc882");
         startActivity(Intent.createChooser(intent,"Choose an email"));

    }
}
