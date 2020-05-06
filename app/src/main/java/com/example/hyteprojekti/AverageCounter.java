package com.example.hyteprojekti;

import java.util.ArrayList;

public class AverageCounter {
    AverageCounter(){
    }

    //Used to count weekly average of smokes smoked.
    public String CountWeek(ArrayList<Integer> myList){
        float kaikki = 0, kArvo = 0;

        for (int i = 0; i<7; i++){
            kaikki += myList.get(i);
        }

        kArvo = kaikki/7;
        return String.format("%.1f", kArvo);
    }

    //Used to count monthly average of smokes smoked.
    public String CountMonth(ArrayList<Integer> myList){
        float kaikki = 0, kArvo = 0;

        for (int i = 0; i<30; i++){
            kaikki += myList.get(i);
        }
        kArvo = kaikki/30;
        return String.format("%.1f", kArvo);
    }
}
