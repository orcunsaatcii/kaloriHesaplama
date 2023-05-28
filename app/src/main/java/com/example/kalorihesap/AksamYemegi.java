package com.example.kalorihesap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AksamYemegi extends AppCompatActivity {

    private DatabaseReference myRef;
    private TextView mercimek_txt,pilav_txt,sarma_txt,kofte_txt,lazanya_txt,kola_txt,
            ayran_txt,kazandibi_txt,sutlac_txt;

    private EditText mercimek_edit,pilav_edit,sarma_edit,kofte_edit,lazanya_edit,kola_edit,
            ayran_edit,kazandibi_edit,sutlac_edit;

    private Button hesaplamasayfasi_btn;

    String mercimek,pilav,sarma,kofte,lazanya,kola,ayran,kazandibi,sutlac;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aksam_yemegi);

        int sabah_kalori = getIntent().getIntExtra("kahvalti_kalorisi",0);
        int ogle_kalori = getIntent().getIntExtra("ogle_kalorisi",0);


        myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kalorihesap-c9f15-default-rtdb.firebaseio.com/");
        mercimek_txt = findViewById(R.id.mercimek_txt);
        pilav_txt = findViewById(R.id.pilav_txt);
        sarma_txt = findViewById(R.id.sarma_txt);
        kofte_txt = findViewById(R.id.kofte_txt);
        lazanya_txt= findViewById(R.id.lazanya_txt);
        kola_txt = findViewById(R.id.kola_txt);
        ayran_txt = findViewById(R.id.ayran_txt);
        kazandibi_txt= findViewById(R.id.kazandibi_txt);
        sutlac_txt = findViewById(R.id.sutlac_txt);
        hesaplamasayfasi_btn = findViewById(R.id.hesaplamasayfasi_btn);

        mercimek_edit = findViewById(R.id.mercimek_edit);
        pilav_edit = findViewById(R.id.pilav_edit);
        sarma_edit = findViewById(R.id.sarma_edit);
        kofte_edit = findViewById(R.id.kofte_edit);
        lazanya_edit = findViewById(R.id.lazanya_edit);
        kola_edit = findViewById(R.id.kola_edit);
        ayran_edit = findViewById(R.id.ayran_edit);
        kazandibi_edit = findViewById(R.id.kazandibi_edit);
        sutlac_edit = findViewById(R.id.sutlac_edit);



        myRef.child("Aksam Yemegi").addListenerForSingleValueEvent(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mercimek_txt.setText(snapshot.child("Mercimek Çorbası").getKey() + " " +snapshot.child("Mercimek Çorbası").getValue() +" kcal");
                pilav_txt.setText(snapshot.child("Pilav").getKey()+" " +snapshot.child("Pilav").getValue()+" kcal");
                sarma_txt.setText(snapshot.child("Yaprak Sarması").getKey()+ " " +snapshot.child("Yaprak Sarması").getValue() +" kcal");
                kofte_txt.setText(snapshot.child("Köfte").getKey() +" " +snapshot.child("Köfte").getValue()+ " kcal");
                lazanya_txt.setText(snapshot.child("Lazanya").getKey()+" " + snapshot.child("Lazanya").getValue()+" kcal");
                kola_txt.setText(snapshot.child("Kola").getKey()+" " +snapshot.child("Kola").getValue()+ " kcal");
                ayran_txt.setText(snapshot.child("Ayran").getKey()+" " +snapshot.child("Ayran").getValue()+ " kcal");
                kazandibi_txt.setText(snapshot.child("Kazandibi").getKey()+" " +snapshot.child("Kazandibi").getValue()+ " kcal");
                sutlac_txt.setText(snapshot.child("Sütlaç").getKey()+" " +snapshot.child("Sütlaç").getValue()+ " kcal");


                mercimek = String.valueOf(snapshot.child("Mercimek Çorbası").getValue());
                pilav = String.valueOf(snapshot.child("Pilav").getValue());
                sarma = String.valueOf(snapshot.child("Yaprak Sarması").getValue());
                kofte = String.valueOf(snapshot.child("Köfte").getValue());
                lazanya = String.valueOf(snapshot.child("Lazanya").getValue());
                kola = String.valueOf(snapshot.child("Kola").getValue());
                ayran = String.valueOf(snapshot.child("Ayran").getValue());
                kazandibi = String.valueOf(snapshot.child("Kazandibi").getValue());
                sutlac = String.valueOf(snapshot.child("Sütlaç").getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        hesaplamasayfasi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mercimek_edit.getText().toString().equals(""))
                    mercimek_edit.setText("0");
                if(pilav_edit.getText().toString().equals(""))
                    pilav_edit.setText("0");
                if(sarma_edit.getText().toString().equals(""))
                    sarma_edit.setText("0");
                if(kofte_edit.getText().toString().equals(""))
                    kofte_edit.setText("0");
                if(lazanya_edit.getText().toString().equals(""))
                    lazanya_edit.setText("0");
                if(kola_edit.getText().toString().equals(""))
                    kola_edit.setText("0");
                if(ayran_edit.getText().toString().equals(""))
                    ayran_edit.setText("0");
                if(kazandibi_edit.getText().toString().equals(""))
                    kazandibi_edit.setText("0");
                if(sutlac_edit.getText().toString().equals(""))
                    sutlac_edit.setText("0");

                int aksam_kalori = Integer.parseInt(mercimek_edit.getText().toString()) * Integer.parseInt(mercimek)+
                        Integer.parseInt(pilav_edit.getText().toString()) * Integer.parseInt(pilav) +
                        Integer.parseInt(sarma_edit.getText().toString()) * Integer.parseInt(sarma)+
                        Integer.parseInt(kofte_edit.getText().toString()) * Integer.parseInt(kofte)+
                        Integer.parseInt(lazanya_edit.getText().toString()) * Integer.parseInt(lazanya)+
                        Integer.parseInt(kola_edit.getText().toString()) * Integer.parseInt(kola)+
                        Integer.parseInt(ayran_edit.getText().toString()) * Integer.parseInt(ayran)+
                        Integer.parseInt(kazandibi_edit.getText().toString()) * Integer.parseInt(kazandibi)+
                        Integer.parseInt(sutlac_edit.getText().toString()) * Integer.parseInt(sutlac);





                Intent intent = new Intent(AksamYemegi.this,HesaplamaSayfasi.class);
                intent.putExtra("kahvalti_kalorisi",sabah_kalori);
                intent.putExtra("ogle_kalorisi",ogle_kalori);
                intent.putExtra("aksam_kalorisi",aksam_kalori);
                startActivity(intent);
            }
        });


    }
}