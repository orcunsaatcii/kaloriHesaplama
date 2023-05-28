package com.example.kalorihesap;

import java.util.HashMap;

public class Kaloriler {

    protected HashMap<String,String> kahvalti;
    protected HashMap<String,String> ogle;
    protected HashMap<String,String> aksam;

    public Kaloriler(){
        kahvalti = new HashMap<>();
        kahvalti.put("Yumuşak Peynir","268");
        kahvalti.put("Kaşar Peyniri","337");
        kahvalti.put("Zeytin","115");
        kahvalti.put("Bal","304");
        kahvalti.put("Sürülebilir Çikolata","544");
        kahvalti.put("Kepek Ekmeği(İnce Dilim)","54");
        kahvalti.put("Beyaz Ekmek(İnce Dilim)","60");
        kahvalti.put("Çay","1");
        kahvalti.put("Domates(Küçük)","85");
        kahvalti.put("Salatalık","20");

        ogle = new HashMap<>();
        ogle.put("Makarna","314");
        ogle.put("Patates Salatası","143");
        ogle.put("Çin Böreği","250");
        ogle.put("Fındık(Avuç)","154");
        ogle.put("Ceviz(Avuç)","164");
        ogle.put("Elma","52");
        ogle.put("Portakal","47");
        ogle.put("Limonata(Bardak)","74");
        ogle.put("Kepek Ekmeği(İnce Dilim)","54");
        ogle.put("Beyaz Ekmek(İnce Dilim)","60");

        aksam = new HashMap<>();
        aksam.put("Mercimek Çorbası","137");
        aksam.put("Pilav","283");
        aksam.put("Yaprak Sarması","125");
        aksam.put("Köfte","200");
        aksam.put("Lazanya","494");
        aksam.put("Kola","149");
        aksam.put("Ayran","80");
        aksam.put("Kazandibi","200");
        aksam.put("Sütlaç","260");
        aksam.put("Beyaz Ekmek(İnce Dilim)","60");


    }


}
