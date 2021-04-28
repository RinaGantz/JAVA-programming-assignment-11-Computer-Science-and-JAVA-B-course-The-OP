
/**
 * This class represents a Person object
 *
 * @author Rina Gantz
 * @version 15/03/2020
 */
public class Person
{
    // attributes
    private String _firstName;
    private String _lastName;
    private long _id;
    private Date _dateOfBirth;
    public static final int DEFAULT_ID=123456789;
    public static final String DEFAULT_FIRST_NAME="Binyamin";
    public static final String DEFAULT_LAST_NAME="Netanyahu";

    /**
     * creates a new Person object 
     */
    public Person(String firstName, String lastName, long id, int day, int month, int year)
    {
        _firstName=(firstName!="")?firstName:DEFAULT_FIRST_NAME;
        _lastName=(lastName!="")? lastName:DEFAULT_LAST_NAME;
        _id=(id>0)? id: DEFAULT_ID;   
        _dateOfBirth=new Date(day, month, year);
    }

    /**
     * copy constructor
     * @param p the person to be copied
     */
    public Person(Person p)
    {
        _firstName=p._firstName;
        _lastName=p._lastName;
        _id=p._id;
        _dateOfBirth=new Date(p._dateOfBirth);

    }

    /**
     * gets the first name
     * @return the first name
     */
    public String getFirstName()
    {
        return _firstName;
    }

    /**
     * gets the last name
     * @return the last name
     */
    public String getLastName()
    {
        return _lastName;
    }

    /**
     * gets the ID
     * @return the ID
     */
    public long getId()
    {
        return _id;
    }

    /**
     * gets the date of birth
     * @return the date of birth
     */
    public Date getDateOfBirth()
    {
        return new Date(_dateOfBirth);
    }

    /**
     * set the first name 
     * @param name first name to be set
     */
    public void setFirstName(String name)
    {
        if(name!="")
            _firstName=name;
    }

    /**
     * set the last name 
     * @param name last name to be set
     */
    public void setLastName(String name)
    {
        if(name!="")
            _lastName=name;
    }

    /**
     * set the id (only if id remains valid)
     * @param id id to be set
     */
    public void setId(long id)
    {
        if (id>0)
            _id=id;
    }

    /**
     * set the date of birth(only if date remains valid)
     * @param day day of birth to be set
     * @param month month of birth to be set
     * @param year year of birth to be set
     */
    public void setDateOfBirth(int day, int month, int year)
    {
        final  int  minDay=1,maxDay=31, minMonth=1,maxMonth=12, minYear=1000, maxYear=9999;
        if (day>=minDay&&day<=maxDay&&month>=minMonth&&month<=maxMonth&&year>=minYear&&year<maxYear)
            _dateOfBirth=new Date(day,month,year);
    }

    /** 
     *  check if 2 persons are the same
     * @param other the person to compare this person to
     * @return true if they are equal, oterwise false. 
     */
    public boolean equals(Person other)
    {
        return (_firstName.equals(other._firstName)&&_lastName.equals(other._lastName)&&_id==other._id&&sameBirthday(other));
    }

    /**
     * check if this person has the same birth day like to other person
     * @param other the person to compare his birth to this person's birth
     * @return true if they birth day are the same
     */
    public boolean sameBirthday(Person other)
    {
        return _dateOfBirth.equals(other._dateOfBirth);
    }

    /**
     * check if this person is older than other person
     * @param other person to compare this person to
     * @return true if this person is older than other person 
     */
    public boolean older(Person other)
    {
        return _dateOfBirth.before(other._dateOfBirth);
    }

    /**
     * returns a String that represents this person
     * @return String that represents this person in the following format:
     * Last Name: Netanyahu, First Name: Binyamin, ID: 123456789, Date of birth: 14/06/2017 
     */
    public String toString()
    {
        return "Last Name: "+_lastName+", First Name: "+_firstName+", ID: "+_id+", Date of birth: "+_dateOfBirth;
    }
}//end of class Person
