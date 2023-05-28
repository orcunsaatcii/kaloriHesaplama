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

public class AnaSayfa extends AppCompatActivity {
    private DatabaseReference myRef;
    private TextView beyazpeynir_txt,kasarpeynir_txt,zeytin_txt,bal_txt,cikolata_txt,kepekekmek_txt,
    beyazekmek_txt,cay_txt,domates_txt;

    private EditText beyazpeynir_edit,kasarpeynir_edit,zeytin_edit,bal_edit,cikolata_edit,kepekekmek_edit,
            beyazekmek_edit,cay_edit,domates_edit;

    private Button ogle_btn,loginpage_btn;

    String beyazpeynir,kasarpeynir,zeytin,bal,cikolata,kepekekmek,beyazekmek,cay,domates;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);

        myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kalorihesap-c9f15-default-rtdb.firebaseio.com/");
        beyazpeynir_txt = findViewById(R.id.beyazpeynir_txt);
        kasarpeynir_txt = findViewById(R.id.kasarpeynir_txt);
        zeytin_txt = findViewById(R.id.zeytin_txt);
        bal_txt = findViewById(R.id.bal_txt);
        cikolata_txt = findViewById(R.id.cikolata_txt);
        kepekekmek_txt = findViewById(R.id.kepekekmek_txt);
        beyazekmek_txt = findViewById(R.id.beyazekmek_txt);
        cay_txt = findViewById(R.id.cay_txt);
        domates_txt = findViewById(R.id.domates_txt);

        beyazpeynir_edit = findViewById(R.id.beyazpeynir_edit);
        kasarpeynir_edit = findViewById(R.id.kasarpeynir_edit);
        zeytin_edit = findViewById(R.id.zeytin_edit);
        bal_edit = findViewById(R.id.bal_edit);
        cikolata_edit = findViewById(R.id.cikolata_edit);
        kepekekmek_edit = findViewById(R.id.kepekekmek_edit);
        beyazekmek_edit = findViewById(R.id.beyazekmek_edit);
        cay_edit = findViewById(R.id.cay_edit);
        domates_edit = findViewById(R.id.domates_edit);


        ogle_btn = findViewById(R.id.oglen_btn);
        loginpage_btn = findViewById(R.id.loginpage_btn);


        myRef.child("Kahvalti").addListenerForSingleValueEvent(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                beyazpeynir_txt.setText(snapshot.child("Yumuşak Peynir").getKey() + " " +snapshot.child("Yumuşak Peynir").getValue() +" kcal");
                kasarpeynir_txt.setText(snapshot.child("Kaşar Peyniri").getKey()+" " +snapshot.child("Kaşar Peyniri").getValue()+" kcal");
                zeytin_txt.setText(snapshot.child("Zeytin").getKey()+ " " +snapshot.child("Zeytin").getValue() +" kcal");
                bal_txt.setText(snapshot.child("Bal").getKey() +" " +snapshot.child("Bal").getValue()+ " kcal");
                cikolata_txt.setText(snapshot.child("Sürülebilir Çikolata").getKey()+" " + snapshot.child("Sürülebilir Çikolata").getValue()+" kcal");
                kepekekmek_txt.setText(snapshot.child("Kepek Ekmeği(İnce Dilim)").getKey()+" " +snapshot.child("Kepek Ekmeği(İnce Dilim)").getValue()+ " kcal");
                beyazekmek_txt.setText(snapshot.child("Beyaz Ekmek(İnce Dilim)").getKey()+" " +snapshot.child("Beyaz Ekmek(İnce Dilim)").getValue()+ " kcal");
                cay_txt.setText(snapshot.child("Çay").getKey()+" " +snapshot.child("Çay").getValue()+ " kcal");
                domates_txt.setText(snapshot.child("Domates(Küçük)").getKey()+" " +snapshot.child("Domates(Küçük)").getValue()+ " kcal");

                beyazpeynir = String.valueOf(snapshot.child("Yumuşak Peynir").getValue());
                kasarpeynir = String.valueOf(snapshot.child("Kaşar Peyniri").getValue());
                zeytin = String.valueOf(snapshot.child("Zeytin").getValue());
                bal = String.valueOf(snapshot.child("Bal").getValue());
                cikolata = String.valueOf(snapshot.child("Sürülebilir Çikolata").getValue());
                kepekekmek = String.valueOf(snapshot.child("Kepek Ekmeği(İnce Dilim)").getValue());
                beyazekmek = String.valueOf(snapshot.child("Beyaz Ekmek(İnce Dilim)").getValue());
                cay = String.valueOf(snapshot.child("Çay").getValue());
                domates = String.valueOf(snapshot.child("Domates(Küçük)").getValue());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ogle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(beyazpeynir_edit.getText().toString().equals(""))
                    beyazpeynir_edit.setText("0");
                if(kasarpeynir_edit.getText().toString().equals(""))
                    kasarpeynir_edit.setText("0");
                if(zeytin_edit.getText().toString().equals(""))
                    zeytin_edit.setText("0");
                if(bal_edit.getText().toString().equals(""))
                    bal_edit.setText("0");
                if(cikolata_edit.getText().toString().equals(""))
                    cikolata_edit.setText("0");
                if(kepekekmek_edit.getText().toString().equals(""))
                    kepekekmek_edit.setText("0");
                if(beyazekmek_edit.getText().toString().equals(""))
                    beyazekmek_edit.setText("0");
                if(cay_edit.getText().toString().equals(""))
                    cay_edit.setText("0");
                if(domates_edit.getText().toString().equals(""))
                    domates_edit.setText("0");


                int kahvalti_kalori = Integer.parseInt(beyazpeynir_edit.getText().toString()) * Integer.parseInt(beyazpeynir)+
                        Integer.parseInt(kasarpeynir_edit.getText().toString()) * Integer.parseInt(kasarpeynir) +
                        Integer.parseInt(zeytin_edit.getText().toString()) * Integer.parseInt(zeytin)+
                        Integer.parseInt(bal_edit.getText().toString()) * Integer.parseInt(bal)+
                        Integer.parseInt(cikolata_edit.getText().toString()) * Integer.parseInt(cikolata)+
                        Integer.parseInt(kepekekmek_edit.getText().toString()) * Integer.parseInt(kepekekmek)+
                        Integer.parseInt(beyazekmek_edit.getText().toString()) * Integer.parseInt(beyazekmek)+
                        Integer.parseInt(cay_edit.getText().toString()) * Integer.parseInt(cay)+
                        Integer.parseInt(domates_edit.getText().toString()) * Integer.parseInt(domates);




                Intent intent = new Intent(AnaSayfa.this,OgleYemegi.class);
                intent.putExtra("kahvalti_kalorisi",kahvalti_kalori);
                startActivity(intent);
            }
        });

        loginpage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnaSayfa.this,MainActivity.class);
                startActivity(intent);
            }
        });










    }
}