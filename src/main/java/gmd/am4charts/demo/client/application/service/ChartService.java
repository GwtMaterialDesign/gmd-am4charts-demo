/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gmd.am4charts.demo.client.application.service;

import gmd.am4charts.demo.client.application.charts.ChartDemo;
import gmd.am4charts.demo.client.application.charts.basic.SlicedPyramidChart;
import gmd.am4charts.demo.client.application.charts.gauges.AnimatedGaugeDemo;
import gmd.am4charts.demo.client.application.charts.gauges.ClockDemo;
import gmd.am4charts.demo.client.application.charts.gauges.ClockWithTwoFacesDemo;
import gmd.am4charts.demo.client.application.charts.maps.*;
import gmd.am4charts.demo.client.application.charts.misc.JavascriptObjectChartDemo;
import gmd.am4charts.demo.client.application.charts.misc.JsonObjectChartDemo;
import gmd.am4charts.demo.client.application.charts.misc.PropertyFieldsChartDemo;
import gmd.am4charts.demo.client.application.charts.types.*;

import java.util.ArrayList;
import java.util.List;

public class ChartService {

    static List<ChartDemo> charts = new ArrayList<>();
    static List<ChartDemo> maps = new ArrayList<>();
    static List<ChartDemo> gauges = new ArrayList<>();
    static List<ChartDemo> data = new ArrayList<>();

    static {
        generateCharts();
        generateMaps();
        generateGauges();
        generateDataChart();
    }

    private static void generateDataChart() {
        data.add(new JavascriptObjectChartDemo());
        data.add(new JsonObjectChartDemo());
        data.add(new PropertyFieldsChartDemo());
    }

    private static void generateGauges() {
        gauges.add(new ClockDemo());
        gauges.add(new ClockWithTwoFacesDemo());
        gauges.add(new AnimatedGaugeDemo());
    }

    private static void generateMaps() {
        maps.add(new MultiSeriesMapDemo());
        maps.add(new AnimationsAlongLine());
        maps.add(new MapWithCurvedLinesDemo());
        maps.add(new ZoomingToContriesMapDemo());
        maps.add(new CapitalsMapDemo());
        maps.add(new ChangingMapProjectionDemo());
        maps.add(new UsHeatMap());
        //TODO: Maps with Pattern
        //TODO: Custom HTml
        //TODO: Flight Routes
        //TODO: Location Sensitive Map
        //TODO: Group Countries Map

    }

    private static void generateCharts() {
        charts.add(new StackedAreaDemo());
        charts.add(new SimplePieChartDemo());
        charts.add(new BubbleChartDemo());
        charts.add(new ChordDiagramNonRibbonDemo());
        charts.add(new ChordDiagramDemo());
        charts.add(new DumbbellPlotDemo());
        charts.add(new RadialHistogramDemo());
        charts.add(new PictorialFractionDemo());
        charts.add(new PolarAreaChartDemo());
        charts.add(new LineGraphDemo());
        charts.add(new RadarLineGraphDemo());
        charts.add(new CurvedColumnsDemo());
        charts.add(new SolidGaugeDemo());
        charts.add(new SimpleTreemap());
        charts.add(new PictorialColumnChart());
        charts.add(new PictorialStackedChart());
        charts.add(new FunnelChartDemo());
        charts.add(new AngularGaugeDemo());
        charts.add(new SlicedPyramidChart());
        charts.add(new HeatmapWithLegendDemo());
        charts.add(new RadialBarChartDemo());
        charts.add(new StackedBarDemo());
        charts.add(new ClusteredBarChart());
        charts.add(new SemiPieChartDemo());
        charts.add(new NestedDonutChartDemo());
        charts.add(new DonutChartDemo());
        charts.add(new WaterfallChartDemo());
        charts.add(new SparklineDemo());
        charts.add(new ScatterChartDemo());
        charts.add(new StepLineChartDemo());
        charts.add(new GanttChartDemo());

        //TODO: Map with bubbles
        //TODO: Bullet Chart
        //TODO: RangeAreaChart
        //TODO: Population Pyramid
    }

    public static List<ChartDemo> getCharts() {
        return charts;
    }

    public static List<ChartDemo> getMaps() {
        return maps;
    }

    public static List<ChartDemo> getGauges() {
        return gauges;
    }


    public static List<ChartDemo> getDataChart() {
        return data;
    }

    public static ChartDemo getChart(int index) {
        return getCharts().get(index);
    }

    public static ChartDemo getMap(int index) {
        return getMaps().get(index);
    }

    public static ChartDemo getGauge(int index) {
        return getGauges().get(index);
    }

    public static ChartDemo getDataChart(int index) {
        return getDataChart().get(index);
    }

}
