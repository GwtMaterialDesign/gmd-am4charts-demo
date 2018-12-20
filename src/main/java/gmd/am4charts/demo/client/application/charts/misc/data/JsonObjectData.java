package gmd.am4charts.demo.client.application.charts.misc.data;

public class JsonObjectData {


    private String category;
    private int value;
    private String color;

    public JsonObjectData(String category, int value, String color) {
        this.category = category;
        this.value = value;
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
