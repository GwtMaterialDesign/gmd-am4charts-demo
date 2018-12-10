package gmd.am4charts.demo.client.application.charts.basic;

import com.google.gwt.core.client.JsDate;
import com.google.gwt.user.client.ui.Widget;
import gmd.am4charts.demo.client.application.charts.ChartDemo;
import gwt.material.design.amcharts.client.Am4Charts;
import gwt.material.design.amcharts.client.Chart;
import gwt.material.design.amcharts.client.PieChart;
import gwt.material.design.amcharts.client.XYChart;
import gwt.material.design.amcharts.client.axis.DateAxis;
import gwt.material.design.amcharts.client.axis.ValueAxis;
import gwt.material.design.amcharts.client.cursor.XYCursor;
import gwt.material.design.amcharts.client.scrollbar.XYChartScrollbar;
import gwt.material.design.amcharts.client.series.LineSeries;
import gwt.material.design.amcharts.client.series.PieSeries;
import gwt.material.design.amcore.client.Am4Core;
import gwt.material.design.amcore.client.color.Color;
import gwt.material.design.amcore.client.constants.Align;
import gwt.material.design.amcore.client.constants.VerticalAlign;
import gwt.material.design.amcore.client.export.ExportMenu;
import gwt.material.design.amcore.client.language.Locale;
import gwt.material.design.client.ui.MaterialToast;

import java.util.Date;

public class LineChartDemo implements ChartDemo {

    private XYChart xyChart;

    @Override
    public void generate(Widget container) {
        // XYChart Demo
        xyChart = (XYChart) Am4Core.create(container, Am4Charts.XYChart);
        // Language
        xyChart.language.locale = Locale.ru_RU.getValue();
        // DateAxis
        DateAxis dateAxis = (DateAxis) xyChart.xAxes.push(new DateAxis());
        // ValueAxis
        ValueAxis valueAxis = (ValueAxis) xyChart.yAxes.push(new ValueAxis());
        // Number Formatter
        valueAxis.numberFormatter.numberFormat = "'$' #.a";
        // Series
        LineSeries lineSeries = (LineSeries) xyChart.series.push(new LineSeries());
        lineSeries.dataFields.valueY = "value";
        lineSeries.dataFields.dateX = "day";
        lineSeries.strokeWidth = 1.8;
        xyChart.dataSource.url = "data/large-data.json";
        // Scrollbar
        XYChartScrollbar scrollbarX = new XYChartScrollbar();
        scrollbarX.series.push(lineSeries);
        xyChart.scrollbarX = scrollbarX;
        xyChart.scrollbarX.updateWhileMoving = false;
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
    public String getSourceCode() {
        return null;
    }

    @Override
    public Chart getChart() {
        return xyChart;
    }
}
