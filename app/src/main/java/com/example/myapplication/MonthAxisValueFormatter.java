package com.example.myapplication;

import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

public class MonthAxisValueFormatter extends IndexAxisValueFormatter {

    public static String[] xNames = new String[]{"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월", "평균" };
//    public static String[] xNames = new String[]{"1월", "2월", "3월", "4월", "5월", "6월", "평균" };
//    public static String[] xNames = new String[]{"1월", "2월", "3월", "평균" };

    @Override
    public String getFormattedValue(float value) {
        return getMonth((int) value);
    }

    private String getMonth(int position){
        int pos = position % xNames.length;
        if(pos > xNames.length -1)
            pos = 4;

        return xNames[pos];
    }
}
