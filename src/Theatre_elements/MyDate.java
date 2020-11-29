package Theatre_elements;

import java.util.Date;

public class MyDate {
    int year;
    int month;
    int day;
    int hour;
    int minute;

    public MyDate(Date date){
        year = date.getDate();
        month = date.getMonth();
        day = date.getDay();
        hour = date.getHours();
        minute = date.getMinutes();
    }

    public MyDate(int year, int month, int day, int hour, int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public boolean compareDates(MyDate anotherDate){
        if(year == anotherDate.getYear() && month == anotherDate.getMonth() && day == anotherDate.getDay()
                && hour == anotherDate.getHour() && minute == anotherDate.getMinute()){
            return true;
        }
        else{
            return false;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
