package com.example.hyteprojekti;

import java.util.ArrayList;

public class AverageCounter {
    AverageCounter(){
    }

    public String Count(ArrayList<Integer> myList){
        float kaikki = 0, kArvo = 0;

        for (int i = 0; i<7; i++){
            kaikki += myList.get(i);
        }

        kArvo = kaikki/7;
        return String.format("%.1f", kArvo);
    }
}
