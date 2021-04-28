
/**
 * This class represents a Date object
 *
 * @author Rina Gantz
 * @version 18/12/2019
 */
public class Date
{
    // attributes and declarations
    private int _day;
    private int _month;
    private int _year;
    public final static  int DEFAULT_DAY=01;
    public final static  int DEFAULT_MONTH=01;
    public final static  int DEFAULT_YEAR=2000;

    /**
     * creates a new Date object if the date is valid, otherwise creates the date 1/1/2000
     * @param day the day in the month (1-31)
     * @param month the month in the year (1-12)
     * @param year the year (4 digits)
     * 
     */
    public Date(int day, int month, int year)
    {
        if (checkDate(day,month,year))//Check if the parameters are legal parameters
        {
            _day=day;
            _month=month;
            _year=year;
        }
        else//if the parameters are illegal parameters
        {
            _day=DEFAULT_DAY;
            _month=DEFAULT_MONTH;
            _year=DEFAULT_YEAR;
        }

    }

    /**
     * copy constructor
     * @param other the date to be copied
     */
    public Date(Date other)
    {
        this(other._day,other._month,other._year);

    }
    //methods

    /**
     * gets the day
     * @return The day
     */
    public int getDay()
    {
        return _day;
    }

    /**
     *gets the month
     * @return The month
     */
    public int getMonth()
    {
        return _month;

    }

    /**
     *  gets the year
     * @return The year
     */
    public int getYear()
    {
        return _year;

    }

    // Checks if a given date is in a valid and return true or false
    private boolean checkDate(int day, int month,int year){
        //declarations
        final int MIN_DAY=1,MAX_DAYS=31,MIN_MONTH=1,MONTH_OF_YEAR=12, MAX_YEAR=9999,MIN_YEAR=1000;
        if(year>=MIN_YEAR&&year<=MAX_YEAR&&month>=MIN_MONTH&&month<=MONTH_OF_YEAR&&day>=MIN_DAY&&day<=MAX_DAYS)
            return true;
        return false;//The given parameters can't constitute a legal date
    }

    /**
     * sets the day (only if date remains valid)
     * @param dayToSet the day value to be set
     */
    public void setDay(int dayToSet)
    {
        if (checkDate(dayToSet,_month,_year))
            _day=dayToSet;  
    }

    /**
     * sets the month (only if date remains valid)
     * @param monthToSet the month value to be set
     */
    public void setMonth(int monthToSet)
    {
        if (checkDate(_day,monthToSet,_year))
            _month= monthToSet;
    }

    /**
     *sets the year (only if date remains valid)
     * @param yearToSet the year value to be set
     */
    public void setYear(int yearToSet)
    {
        if (checkDate(_day,_month,yearToSet))
            _year=yearToSet;
    }

    /** 
     *  check if 2 dates are the same
     * @param other the date to compare this date to
     * @return true if they are equal, oterwise false. 
     */
    public boolean equals(Date other)
    {
        return (other._day==_day&&other._month==_month&&other._year==_year);
    }

    /** 
     * check if this date is before other date
     * @param other date to compare this date to
     * @return true if the dates are the same
     */

    public boolean before(Date other)
    {
        //Check which date is the first date according to the years, months and days of the two dates
        if (_year<other._year)
            return true;
        if (_year>other._year)
            return false;
        if (_month<other._month)
            return true;
        if (_month>other._month)
            return false;
        if (_day<other._day)
            return true;
        return false;
    }

    /** 
     * check if this date is after other date
     * @param other date to compare this date to
     * @rtrue if this date is after other date
     * 
     */
    public boolean after(Date other)

    {
        return other.before(this);
    }

    /**
     * returns a String that represents this date
     * @return String that represents this date in the following format: day/month/year for example: 02/03/1998
     */
    public String toString()
    {
        final int CHECK_STRING=10;
        String s = "";
        //Check if to add zeros before the num in the print
        if (_day<CHECK_STRING)
            s = s+"0";
        s = s + _day +"/";
        if (_month<CHECK_STRING)
            s = s+"0";
        s = s +_month+"/"+_year;

        return s;
    }
}//end of class Date
