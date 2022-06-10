package com.example.myapplication;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;

public class PercentFormatter implements IValueFormatter, IAxisValueFormatter {
    protected DecimalFormat format;

    public PercentFormatter() {
        format = new DecimalFormat("####,####,##0.0");
    }

    public PercentFormatter(DecimalFormat format) {
        this.format = format;
    }
    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        return format.format(value) + " %";
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return format.format(value) + " %";
    }

    public int getDecimalDigits() {
        return 1;
    }
}
