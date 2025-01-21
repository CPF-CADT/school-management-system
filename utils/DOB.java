package utils;
import java.util.Scanner;  
public class DOB {
    private int day;
    private int month;
    private int year;
    public DOB(){
      day=0;
      month=0;
      year=0;
    }
    public DOB(String date){
        this.day = Integer.parseInt(date.substring(0, 2));
        this.month = Integer.parseInt(date.substring(3, 5));
        this.year = Integer.parseInt(date.substring(6, 10));
        // date
    }
    public DOB(int day,int month,int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
}
