package com.example.androidstudy.bean;

import java.util.List;

public class TestData {
    String title;
    List<String> tag;

    public TestData(){}

    public TestData(String title) {
        this.title = title;
    }

    public TestData(String title, List<String> tag) {
        this.title = title;
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "title='" + title + '\'' +
                ", tag=" + tag +
                '}';
    }


}
