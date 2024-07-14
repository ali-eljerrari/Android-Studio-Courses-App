package com.coding.dynasty.android_studio_course_app;


public class CoursesDomain {
    private final String title;
    private final double price;
    private final String picPath;

    public CoursesDomain(String title, double price, String picPath) {
        this.title = title;
        this.price = price;
        this.picPath = picPath;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getPicPath() {
        return picPath;
    }

}
