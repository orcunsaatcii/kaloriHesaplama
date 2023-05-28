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

public class OgleYemegi extends AppCompatActivity {

    private DatabaseReference myRef;
    private TextView makarna_txt,salata_txt,borek_txt,findik_txt,ceviz_txt,elma_txt,
            portakal_txt,limonata_txt,kepekekmegioglen_txt;

    private EditText makarna_edit,salata_edit,borek_edit,findik_edit,ceviz_edit,elma_edit,
            portakal_edit,limonata_edit,kepekekmegioglen_edit;

    private Button aksam_btn;

    String makarna,salata,borek,findik,ceviz,elma,portakal,limonata,kepekekmekoglen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogle_yemegi);

        int sabah_kalori = getIntent().getIntExtra("kahvalti_kalorisi",0);


        myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kalorihesap-c9f15-default-rtdb.firebaseio.com/");
        makarna_txt = findViewById(R.id.makarna_txt);
        salata_txt = findViewById(R.id.salata_txt);
        borek_txt = findViewById(R.id.borek_txt);
        findik_txt = findViewById(R.id.findik_txt);
        ceviz_txt= findViewById(R.id.ceviz_txt);
        elma_txt = findViewById(R.id.elma_txt);
        portakal_txt = findViewById(R.id.portakal_txt);
        limonata_txt= findViewById(R.id.limonata_txt);
        kepekekmegioglen_txt = findViewById(R.id.kepekekmegioglen_txt);
        aksam_btn = findViewById(R.id.aksam_btn);

        makarna_edit = findViewById(R.id.makarna_edit);
        salata_edit = findViewById(R.id.salata_edit);
        borek_edit = findViewById(R.id.borek_edit);
        findik_edit = findViewById(R.id.findik_edit);
        ceviz_edit = findViewById(R.id.ceviz_edit);
        elma_edit = findViewById(R.id.elma_edit);
        portakal_edit = findViewById(R.id.portakal_edit);
        limonata_edit = findViewById(R.id.limonata_edit);
        kepekekmegioglen_edit = findViewById(R.id.kepekekmegioglen_edit);



        myRef.child("Ogle Yemegi").addListenerForSingleValueEvent(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                makarna_txt.setText(snapshot.child("Makarna").getKey() + " " +snapshot.child("Makarna").getValue() +" kcal");
                salata_txt.setText(snapshot.child("Patates Salatası").getKey()+" " +snapshot.child("Patates Salatası").getValue()+" kcal");
                borek_txt.setText(snapshot.child("Çin Böreği").getKey()+ " " +snapshot.child("Çin Böreği").getValue() +" kcal");
                findik_txt.setText(snapshot.child("Fındık(Avuç)").getKey() +" " +snapshot.child("Fındık(Avuç)").getValue()+ " kcal");
                ceviz_txt.setText(snapshot.child("Ceviz(Avuç)").getKey()+" " + snapshot.child("Ceviz(Avuç)").getValue()+" kcal");
                elma_txt.setText(snapshot.child("Elma").getKey()+" " +snapshot.child("Elma").getValue()+ " kcal");
                portakal_txt.setText(snapshot.child("Portakal").getKey()+" " +snapshot.child("Portakal").getValue()+ " kcal");
                limonata_txt.setText(snapshot.child("Limonata(Bardak)").getKey()+" " +snapshot.child("Limonata(Bardak)").getValue()+ " kcal");
                kepekekmegioglen_txt.setText(snapshot.child("Kepek Ekmeği(İnce Dilim)").getKey()+" " +snapshot.child("Kepek Ekmeği(İnce Dilim)").getValue()+ " kcal");


                makarna = String.valueOf(snapshot.child("Makarna").getValue());
                salata = String.valueOf(snapshot.child("Patates Salatası").getValue());
                borek = String.valueOf(snapshot.child("Çin Böreği").getValue());
                findik = String.valueOf(snapshot.child("Fındık(Avuç)").getValue());
                ceviz = String.valueOf(snapshot.child("Ceviz(Avuç)").getValue());
                elma = String.valueOf(snapshot.child("Elma").getValue());
                portakal = String.valueOf(snapshot.child("Portakal").getValue());
                limonata = String.valueOf(snapshot.child("Limonata(Bardak)").getValue());
                kepekekmekoglen = String.valueOf(snapshot.child("Kepek Ekmeği(İnce Dilim)").getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        aksam_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(makarna_edit.getText().toString().equals(""))
                    makarna_edit.setText("0");
                if(salata_edit.getText().toString().equals(""))
                    salata_edit.setText("0");
                if(borek_edit.getText().toString().equals(""))
                    borek_edit.setText("0");
                if(findik_edit.getText().toString().equals(""))
                    findik_edit.setText("0");
                if(ceviz_edit.getText().toString().equals(""))
                    ceviz_edit.setText("0");
                if(elma_edit.getText().toString().equals(""))
                    elma_edit.setText("0");
                if(portakal_edit.getText().toString().equals(""))
                    portakal_edit.setText("0");
                if(limonata_edit.getText().toString().equals(""))
                    limonata_edit.setText("0");
                if(kepekekmegioglen_edit.getText().toString().equals(""))
                    kepekekmegioglen_edit.setText("0");
                else{

                }


                int ogle_kalori = Integer.parseInt(makarna_edit.getText().toString()) * Integer.parseInt(makarna)+
                        Integer.parseInt(salata_edit.getText().toString()) * Integer.parseInt(salata) +
                        Integer.parseInt(borek_edit.getText().toString()) * Integer.parseInt(borek)+
                        Integer.parseInt(findik_edit.getText().toString()) * Integer.parseInt(findik)+
                        Integer.parseInt(ceviz_edit.getText().toString()) * Integer.parseInt(ceviz)+
                        Integer.parseInt(elma_edit.getText().toString()) * Integer.parseInt(elma)+
                        Integer.parseInt(portakal_edit.getText().toString()) * Integer.parseInt(portakal)+
                        Integer.parseInt(limonata_edit.getText().toString()) * Integer.parseInt(limonata)+
                        Integer.parseInt(kepekekmegioglen_edit.getText().toString()) * Integer.parseInt(kepekekmekoglen);





                Intent intent2 = new Intent(OgleYemegi.this,AksamYemegi.class);
                intent2.putExtra("kahvalti_kalorisi",sabah_kalori);
                intent2.putExtra("ogle_kalorisi",ogle_kalori);
                startActivity(intent2);
            }
        });


    }


}