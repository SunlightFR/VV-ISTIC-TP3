package fr.istic.vv;

class Date implements Comparable<Date> {
    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    private int day, month, year;


    public Date(int day, int month, int year) {
        if(!isValidDate(day, month, year)){
            throw new IllegalArgumentException();
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isValidDate(int day, int month, int year) {
        if(month < 1 || month > 12){
            return false;
        }


        return day > 0 && day <= getNumberOfDays(month, year);
    }

    public static int getNumberOfDays(int month, int year){
        int numberOfDays;
        if(month<=7 && month%2==1 || month>7 && month%2==0){
            numberOfDays = 31;
        }
        else{
            numberOfDays = 30;
        }
        if(month == 2){
            if(isLeapYear(year)){
                numberOfDays = 29;
            }
            else{
                numberOfDays = 28;
            }
        }
        return numberOfDays;
    }

    public static boolean isLeapYear(int year) {
        return year%4==0 && year%100!=0 || year%400==0;
    }


    public Date nextDate() {
        if(day == getNumberOfDays(month, year)){
            if(month == 12){
                return new Date(1,1,year+1);
            }else{
                return new Date(1, month+1, year);
            }
        }else{
            return new Date(day+1,month, year);
        }
    }

    public Date previousDate() {
        if(day == 1){
            if(month == 1){
                return new Date(31, 12, year-1);
            }else{
                return new Date(getNumberOfDays(month-1, year), month-1, year);
            }
        }else{
            return new Date(day-1,month, year);
        }
    }

    public int compareTo(Date other) {
        if(other.getYear() > this.year){
            return -1;
        }
        if(this.year > other.getYear()){
            return 1;
        }
        if(other.getMonth() > this.month){
            return -1;
        }
        if(this.month > other.getMonth()){
            return 1;
        }
        if(other.getDay() > this.day){
            return -1;
        }
        if(this.day > other.getDay()){
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Date){
            Date otherAsDate = (Date) other;
            return otherAsDate.day == this.day
                    && otherAsDate.month == this.month
                    && otherAsDate.year == this.year;
        }
        return false;
    }

}