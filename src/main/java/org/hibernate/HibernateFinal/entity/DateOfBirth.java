package org.hibernate.HibernateFinal.entity;

import javax.persistence.Embeddable;

@Embeddable
public class DateOfBirth {
    private int date;
    private String month;

    private short year;

    public  DateOfBirth() {
       super();
    }
    public DateOfBirth(int date, String month, short year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "DateOfBirth{" +
                "date=" + date +
                ", month='" + month + '\'' +
                ", year=" + year +
                '}';
    }
}
