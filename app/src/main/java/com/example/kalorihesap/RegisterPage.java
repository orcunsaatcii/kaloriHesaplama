package com.example.kalorihesap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterPage extends AppCompatActivity {

    private EditText ad_reg_txt,email_reg_txt,sifre_reg_txt,sifretekrar_reg_txt;
    private Button kayit_reg_btn;
    private String email,sifre,ad,sifretekrar;
    private DatabaseReference myRef;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        ad_reg_txt =  findViewById(R.id.ad_reg_txt);
        email_reg_txt = findViewById(R.id.email_reg_txt);
        sifre_reg_txt =  findViewById(R.id.sifre_reg_txt);
        sifretekrar_reg_txt =  findViewById(R.id.sifretekrar_reg_txt);
        kayit_reg_btn= findViewById(R.id.kayit_reg_btn);
        myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kalorihesap-c9f15-default-rtdb.firebaseio.com/");

        kayit_reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ad = ad_reg_txt.getText().toString();
                email = email_reg_txt.getText().toString();
                sifre = sifre_reg_txt.getText().toString();
                sifretekrar =  sifretekrar_reg_txt.getText().toString();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(sifre) || TextUtils.isEmpty(ad)){
                    Toast.makeText(RegisterPage.this, "Lütfen tüğm alanları doldurun", Toast.LENGTH_SHORT).show();
                }
                if(!sifre.equals(sifretekrar)){
                    Toast.makeText(RegisterPage.this, "Şifreler uyuşmuyor", Toast.LENGTH_SHORT).show();
                }
                else{
                    myRef.child("Kullanicilar").child(ad).child("isim").setValue(ad);
                    myRef.child("Kullanicilar").child(ad).child("email").setValue(email);
                    myRef.child("Kullanicilar").child(ad).child("sifre").setValue(sifre);
                    Toast.makeText( RegisterPage.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterPage.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}