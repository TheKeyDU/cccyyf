package com.example.cyf;

public class SelectBean {
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public SelectBean(String text, String value1, String value2, boolean isSelect) {
        this.text = text;
        this.value1 = value1;
        this.value2 = value2;
        this.isSelect = isSelect;
    }

    String text;
    String value1;
    String value2;
    boolean isSelect;
}
