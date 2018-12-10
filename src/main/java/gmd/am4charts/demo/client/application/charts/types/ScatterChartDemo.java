package gmd.am4charts.demo.client.application.charts.types;

import com.google.gwt.user.client.ui.Widget;
import gmd.am4charts.demo.client.application.charts.ChartDemo;
import gwt.material.design.amcharts.client.Am4Charts;
import gwt.material.design.amcharts.client.Chart;
import gwt.material.design.amcharts.client.XYChart;
import gwt.material.design.amcharts.client.axis.ValueAxis;
import gwt.material.design.amcharts.client.bullet.Bullet;
import gwt.material.design.amcharts.client.series.LineSeries;
import gwt.material.design.amcore.client.Am4Core;
import gwt.material.design.amcore.client.scrollbar.Scrollbar;
import gwt.material.design.amcore.client.ui.Triangle;

public class ScatterChartDemo implements ChartDemo {

    private XYChart chart;

    @Override
    public void generate(Widget widget) {
        chart = (XYChart) Am4Core.create(widget, Am4Charts.XYChart);

        chart.dataSource.url = "data/scatter-chart.json";

        // Create axes
        ValueAxis valueAxisX = (ValueAxis) chart.xAxes.push(new ValueAxis());
        valueAxisX.title.text = "X Axis";
        valueAxisX.renderer.minGridDistance = 40;

        // Create value axis
        ValueAxis valueAxisY = (ValueAxis) chart.yAxes.push(new ValueAxis());
        valueAxisY.title.text = "Y Axis";

        // Create series
        LineSeries lineSeries = (LineSeries) chart.series.push(new LineSeries());
        lineSeries.dataFields.valueY = "ay";
        lineSeries.dataFields.valueX = "ax";
        lineSeries.strokeOpacity = 0;

        LineSeries lineSeries2 = (LineSeries) chart.series.push(new LineSeries());
        lineSeries2.dataFields.valueY = "by";
        lineSeries2.dataFields.valueX = "bx";
        lineSeries2.strokeOpacity = 0;

        // Add a bullet
        Bullet bullet = lineSeries.bullets.push(new Bullet());

        // Add a triangle to act as am arrow
        Triangle arrow = (Triangle) bullet.createChild(Am4Core.Triangle);
        arrow.horizontalCenter = "middle";
        arrow.verticalCenter = "middle";
        arrow.strokeWidth = 0;
        arrow.fill = chart.colors.getIndex(0);
        arrow.direction = "top";
        arrow.width = 12;
        arrow.height = 12;

        // Add a bullet
        Bullet bullet2 = lineSeries2.bullets.push(new Bullet());

        // Add a triangle to act as am arrow
        Triangle arrow2 = (Triangle) bullet2.createChild(Am4Core.Triangle);
        arrow2.horizontalCenter = "middle";
        arrow2.verticalCenter = "middle";
        arrow2.rotation = 180;
        arrow2.strokeWidth = 0;
        arrow2.fill = chart.colors.getIndex(3);
        arrow2.direction = "top";
        arrow2.width = 12;
        arrow2.height = 12;

        //add the trendlines
        LineSeries trend = (LineSeries) chart.series.push(new LineSeries());
        trend.dataFields.valueY = "value2";
        trend.dataFields.valueX = "value";
        trend.strokeWidth = 2;
        trend.stroke = chart.colors.getIndex(0);
        trend.strokeOpacity = 0.7;
        trend.dataSource.url = "data/trend/data-2.json";

        LineSeries trend2 = (LineSeries) chart.series.push(new LineSeries());
        trend2.dataFields.valueY = "value2";
        trend2.dataFields.valueX = "value";
        trend2.strokeWidth = 2;
        trend2.stroke = chart.colors.getIndex(3);
        trend2.strokeOpacity = 0.7;
        trend2.dataSource.url = "data/trend/data-1.json";
        //scrollbars
        chart.scrollbarX = new Scrollbar();
        chart.scrollbarY = new Scrollbar();
    }

    @Override
    public String getTitle() {
        return "Scatter Chart";
    }

    @Override
    public String getSourceCode() {
        return null;
    }

    @Override
    public Chart getChart() {
        return chart;
    }
}
