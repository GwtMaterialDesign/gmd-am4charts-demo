package gmd.am4charts.demo.client.application.charts.basic;

import com.google.gwt.core.client.JsDate;
import com.google.gwt.user.client.ui.Widget;
import gmd.am4charts.demo.client.application.charts.ChartDemo;
import gwt.material.design.amcharts.client.Am4Charts;
import gwt.material.design.amcharts.client.Chart;
import gwt.material.design.amcharts.client.XYChart;
import gwt.material.design.amcharts.client.axis.DateAxis;
import gwt.material.design.amcharts.client.axis.ValueAxis;
import gwt.material.design.amcharts.client.cursor.XYCursor;
import gwt.material.design.amcharts.client.scrollbar.XYChartScrollbar;
import gwt.material.design.amcharts.client.series.ColumnSeries;
import gwt.material.design.amcharts.client.series.LineSeries;
import gwt.material.design.amcore.client.Am4Core;
import gwt.material.design.amcore.client.color.Color;
import gwt.material.design.amcore.client.language.Locale;
import gwt.material.design.client.ui.MaterialToast;

import java.util.Date;

public class ColumnDemo implements ChartDemo {

    private XYChart xyChart;

    @Override
    public void generate(Widget container) {
        // XYChart Demo
        xyChart = (XYChart) Am4Core.create(container, Am4Charts.XYChart);
        // DateAxis
        DateAxis dateAxis = (DateAxis) xyChart.xAxes.push(new DateAxis());
        // ValueAxis
        ValueAxis valueAxis = (ValueAxis) xyChart.yAxes.push(new ValueAxis());
        // Number Formatter
        valueAxis.numberFormatter.numberFormat = "'$' #.a";

        // Titles
        valueAxis.title.text = "Turnover ($M)";
        valueAxis.title.fontWeight = "bold";

        // Grid
        valueAxis.renderer.grid.template.strokeOpacity = 1;
        valueAxis.renderer.grid.template.stroke = new Color("#A0CA92");
        valueAxis.renderer.grid.template.strokeWidth = 2;

        // Labels
        valueAxis.renderer.labels.template.fill = new Color("#A0CA92");
        valueAxis.renderer.labels.template.fontSize = 20;

        // Ticks
        valueAxis.renderer.ticks.template.strokeOpacity = 1;
        valueAxis.renderer.ticks.template.stroke = new Color("#495C43");
        valueAxis.renderer.ticks.template.strokeWidth = 2;
        valueAxis.renderer.ticks.template.length = 10;

        // Series
        ColumnSeries columnSeries = (ColumnSeries) xyChart.series.push(new ColumnSeries());
        columnSeries.dataFields.valueY = "value";
        columnSeries.dataFields.dateX = "day";
        columnSeries.strokeWidth = 1.8;
        columnSeries.columns.template.tooltipText = "THIS IS A TOOLTIP: {name}\nCategory: {categoryX}\nValue: {valueY}";
        xyChart.dataSource.url = "data/large-data.json";
        // Scrollbar
        XYChartScrollbar scrollbarX = new XYChartScrollbar();
        scrollbarX.series.push(columnSeries);
        xyChart.scrollbarX = scrollbarX;
        xyChart.scrollbarX.updateWhileMoving = false;
        // TODO : Just a workaround to hide the chart
        //xyChart.height = 60;
        // Cursor
        xyChart.cursor = new XYCursor();
        // Events implementation
        xyChart.events.on("hit", param1 -> {
            MaterialToast.fireToast("Event Fired: click");
        }, this);
        // Zooming
        xyChart.zoomToIndexes(0, 23);
        xyChart.events.on("datavalidated", param1 -> {
            dateAxis.zoomToDates(JsDate.create(new Date(117, 11, 1).getTime()), JsDate.create(new Date(117, 11, 31).getTime()));
            MaterialToast.fireToast("Event Fired: datavalidated");
        }, this);
    }

    @Override
    public String getTitle() {
        return "Column Chart";
    }

    @Override
    public String getSourceCode() {
        return null;
    }

    @Override
    public Chart getChart() {
        return xyChart;
    }
}
