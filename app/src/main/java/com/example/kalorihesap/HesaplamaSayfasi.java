package com.example.kalorihesap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HesaplamaSayfasi extends AppCompatActivity {

    private DatabaseReference myRef;

    private TextView sabah_txt,oglen_txt,aksam_txt,total_txt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesaplama_sayfasi);

        int sabah_alinan_kalori = getIntent().getIntExtra("kahvalti_kalorisi",0);
        int oglen_alinan_kalori = getIntent().getIntExtra("ogle_kalorisi",0);
        int aksam_alinan_kalori = getIntent().getIntExtra("aksam_kalorisi",0);

        int total_alinan_kalori = sabah_alinan_kalori + oglen_alinan_kalori + aksam_alinan_kalori;

        sabah_txt = findViewById(R.id.sabah_txt);
        oglen_txt = findViewById(R.id.oglen_txt);
        aksam_txt = findViewById(R.id.aksam_txt);
        total_txt = findViewById(R.id.total_txt);
        myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kalorihesap-c9f15-default-rtdb.firebaseio.com/");

        sabah_txt.setText(String.valueOf(sabah_alinan_kalori) + "kcal");
        oglen_txt.setText(String.valueOf(oglen_alinan_kalori) + "kcal");
        aksam_txt.setText(String.valueOf(aksam_alinan_kalori) + "kcal");

        total_txt.setText(String.valueOf(total_alinan_kalori) + "kcal");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        String date = sdf.format(c.getTime());

        myRef.child("Alınan Kaloriler").child(date).child("Sabah").setValue(sabah_alinan_kalori);
        myRef.child("Alınan Kaloriler").child(date).child("Oglen").setValue(oglen_alinan_kalori);
        myRef.child("Alınan Kaloriler").child(date).child("Aksam").setValue(aksam_alinan_kalori);
        myRef.child("Alınan Kaloriler").child(date).child("Toplam").setValue(total_alinan_kalori);




    }
}