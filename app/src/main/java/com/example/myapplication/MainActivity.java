package com.example.myapplication;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private BarChart chart;
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chart = findViewById(R.id.chart);
        pieChart = findViewById(R.id.pieChart);

        initGraph();
        setGraph();
        initPieChart();
        setData();
    }

    private void initGraph(){
        chart.setDrawValueAboveBar(false);
        chart.setScaleEnabled(false);
        chart.getDescription().setEnabled(false);
        chart.setPinchZoom(false);
        chart.setDrawBarShadow(false); //charbar shadow
        chart.setDrawGridBackground(false);
        chart.getAxisLeft().setSpaceBottom(0f);
        chart.getAxisRight().setSpaceBottom(0f);
        chart.getAxisLeft().setSpaceTop(0f);
        chart.getAxisRight().setSpaceTop(0f);
        chart.setExtraOffsets(0, 20, 0, 38);
        chart.setAutoScaleMinMaxEnabled(false);
        //????????? ?????? ????????? ?????????
        chart.setMinOffset(0f);

        //????????? y?????? ???????????? ??????
        chart.getAxisLeft().setEnabled(false);

        //????????? y?????? ?????? ??????
        chart.getAxisRight().setDrawLabels(false);
        chart.getAxisRight().setDrawZeroLine(true); //?????? ?????? ?????? ??????
        chart.getAxisRight().setZeroLineColor(Color.parseColor("#4d4d4d"));
        chart.getAxisRight().setGridColor(Color.parseColor("#e5e5e5"));
        chart.getAxisRight().setAxisMinimum(0); //????????? ??????????????? ?????? ?????? ????????? 0?????? ???????????? ???????????? ???????????? ????????? 1
        chart.getAxisLeft().setAxisMinimum(0); //????????? ??????????????? ?????? ?????? ????????? 0?????? ???????????? ???????????? ???????????? ????????? 2

        // x??? ??????
        XAxis xLabels = chart.getXAxis();
        xLabels.setPosition(XAxis.XAxisPosition.BOTTOM);
        xLabels.setDrawGridLines(false);
        xLabels.setTextColor(Color.parseColor("#000000"));
        xLabels.setTextSize(12f);

        // x??? Legend ??????
        Legend legend = chart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);


    }

    private void setGraph(){
        // ???????????? ?????? max ??? ??????
        float maxValue = 100;

        chart.getAxisRight().setAxisMaximum(maxValue);
        chart.getAxisLeft().setAxisMaximum(maxValue);

        XAxis xAxis = chart.getXAxis();
        xAxis.setLabelCount(MonthAxisValueFormatter.xNames.length);
        xAxis.setValueFormatter(new MonthAxisValueFormatter());

        // ????????? ??????
        ArrayList<BarEntry> values = new ArrayList<>();
        values.add(new BarEntry(0, new float[]{10, 15, 25}));
        values.add(new BarEntry(1, new float[]{12, 13, 9}));
        values.add(new BarEntry(2, new float[]{15, 15, 0}));
        values.add(new BarEntry(3, new float[]{12, 21, 100}));
        values.add(new BarEntry(4, new float[]{19, 20, 2}));
        values.add(new BarEntry(5, new float[]{19, 19, 25}));
        values.add(new BarEntry(6, new float[]{16, 16, 20}));
        values.add(new BarEntry(7, new float[]{13, 14, 0}));
        values.add(new BarEntry(8, new float[]{10, 11, 11}));
        values.add(new BarEntry(9, new float[]{5, 6, 15}));
        values.add(new BarEntry(10, new float[]{1, 2, 12}));
        values.add(new BarEntry(11, new float[]{1, 2, 9}));
        values.add(new BarEntry(12, new float[]{1, 2, 15}));


        BarDataSet set;
        if(chart.getData() != null && chart.getData().getDataSetCount() > 0){
            set = (BarDataSet) chart.getData().getDataSetByIndex(0);
            set.setValues(values);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        }else{
            set = new BarDataSet(values, "Data set");
            set.setDrawValues(false);
            set.setDrawIcons(false);
            set.setHighlightEnabled(true);
            set.setColors(getColors());

            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set);

            BarData data = new BarData(dataSets);
            data.setBarWidth(0.6f);

            chart.setData(data);

        }

        chart.invalidate();
        chart.animateY(1500);


    }

    private int[] getColors(){
        int[] colors = new int[3];
        colors[0] = Color.parseColor("#996449");
        colors[1] = Color.parseColor("#fbb900");
        colors[2] = Color.parseColor("#1a9999");

        return colors;
    }

    private void initPieChart(){
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(25f, 30, 30, 0);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setDrawCenterText(false);
        pieChart.getLegend().setEnabled(false);
        pieChart.setRotationEnabled(false);
        pieChart.setHighlightPerTapEnabled(false);
        pieChart.setHoleColor(Color.parseColor("#ffffff"));
        pieChart.setHoleRadius(50f);
        pieChart.setTransparentCircleRadius(50f);

    }

    private void setData(){
        // setColor
        ArrayList<Integer> pieColors = new ArrayList<>();
        pieColors.add(Color.parseColor("#996449"));
        pieColors.add(Color.parseColor("#c59771"));
        pieColors.add(Color.parseColor("#937e5c"));
        pieColors.add(Color.parseColor("#cfbfa6"));
        pieColors.add(Color.parseColor("#095ea9"));
        pieColors.add(Color.parseColor("#fbb900"));

        // setData
        List<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(20f, "??????"));
        pieEntries.add(new PieEntry(60f, "??????"));
        pieEntries.add(new PieEntry(3f, "??????"));
        pieEntries.add(new PieEntry(6f, "??????"));
        pieEntries.add(new PieEntry(1f, "??????"));
        pieEntries.add(new PieEntry(1f, "??????"));
        pieEntries.add(new PieEntry(1f, "??????"));
        pieEntries.add(new PieEntry(1f, "??????"));
        pieEntries.add(new PieEntry(7f, "??????"));

        // pieEntry??? value ?????? ?????????????????? ??????
        pieEntries = pieEntries.stream().sorted(Comparator.comparing(PieEntry::getValue).reversed()).collect(Collectors.toList());


        PieDataSet set = new PieDataSet(pieEntries, "Data set");
        set.setValueTextSize(11f);
        set.setColors(pieColors);
        // draw value/label outside the pie chart
        set.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        set.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        set.setValueLinePart1OffsetPercentage(110f);
        set.setValueLinePart1Length(0.6f);
        set.setValueLinePart2Length(0.8f);
        set.setValueTextColor(Color.BLACK);
        set.setValueTypeface(Typeface.DEFAULT_BOLD);


        PieData pieData = new PieData(set);
        pieData.setValueTextColor(Color.BLACK);
        pieData.setDrawValues(true);
        pieData.setValueFormatter(new PercentFormatter(pieChart));
        pieData.setValueTextSize(11f);

        pieChart.setEntryLabelTypeface(Typeface.DEFAULT_BOLD);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setData(pieData);
        pieChart.highlightValue(pieEntries.get(0).getX(), pieEntries.get(0).getY(), 0, true);

//        pieChart.setRenderer(new CustomPieChartRenderer(pieChart, pieChart.getAnimator(), pieChart.getViewPortHandler()));
//        pieChart.setRenderer(new CustomPieChartRenderer2(pieChart, pieChart.getAnimator(), pieChart.getViewPortHandler()));
        pieChart.invalidate();


    }
}