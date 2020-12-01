package Theatre_elements;

import java.util.Date;

/**
 * A custom representation of a date/time combination
 * @author Luka Petrovic, Vic Phan
 * @since 11/29/20
 */
public class MyDate {
	/**
	 * The year of this date
	 */
    int year;
    /**
     * The month of this date (1-12)
     */
    int month;
    /**
     * The day of the month
     */
    int day;
    /**
     * The hour of the day
     */
    int hour;
    /**
     * The minute of this hour
     */
    int minute;

    /**
     * Constructor converting a java.util.Date object into MyDate object
     * @param date the Date to be converted
     */
    public MyDate(Date date){
        year = date.getYear() + 1900;
        month = date.getMonth() + 1;
        day = date.getDate();
        hour = date.getHours();
        minute = date.getMinutes();
    }

    /**
     * Constructor given a year/month/day/hour/minute
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     */
    public MyDate(int year, int month, int day, int hour, int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }
    
    /**
     * Checks two MyDate objects for equality
     * @param anotherDate The Date to be compared
     * @return true if the year/month/day are equivalent, false otherwise
     */
    public boolean compareDates(MyDate anotherDate){
        if(year == anotherDate.getYear() && month == anotherDate.getMonth() && day == anotherDate.getDay()){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Returns a String representing the Date, in the format Month/Day/Year
     * @return A date string
     */
    public String getDateString() {
    	String date = Integer.toString(month)+"/"+Integer.toString(day)+"/"+Integer.toString(year);
    	return date;
    }
    
    /**
     * Returns a String representing the time, in the format Hour:Minute
     * @return A time string
     */
    public String getTimeString() {
    	String time = String.format("%02d", hour)+":"+String.format("%02d", minute);
    	return time;
    }
    
    @Override
    public String toString() {
    	return getDateString()+" "+getTimeString();
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
