
/**
 * This class represents the persons at the group
 *
 * @author Rina Gantz
 * @version 16/03/2020
 */
public class Group
{
    // attributes and declaration
    private Person [] _group;
    private int _numOfPersons;
    public final static  int MAX=10;

    /**
     * creates a new Group object with the default values- 10 cell in the array and 0 persons
     */
    public Group()
    {
        _group=new Person[MAX];
        _numOfPersons=0;
    }

    /**
     * Add a person to the array. If the person already exists in the array or the array is already full - do not add the person.
     * @param p a new person to add to array
     * @ return true if it adds the person to the array and false if the array is already full or if the person already exists in the array
     */
    public boolean addPerson(Person p)
    {
        if (_numOfPersons==MAX)
            return false;
        for(int i=0; i<_numOfPersons; i++)
            if (_group[i].equals(p)) //already exists in the group
                return false;
        _group[_numOfPersons]=new Person(p);// add the person 
        _numOfPersons++;
        return true;
    }

    /**
     * count how many persons were born on the given date
     * @param d a date to check how many were born on 
     * @return how many persons were born on the given date
     */
    public int bornInDate(Date d)
    {
        int sum=0;
        for(int i=0; i<_numOfPersons; i++)
            if (_group[i].getDateOfBirth().equals(d))
                sum++;
        return sum;
    }

    /**
     * count how many persons were born on the given month
     * @param m a month to check how many were born on 
     * @return how many persons were born on the given month
     */
    public int bornInMonth(int m)
    {
        int sum=0;
        for(int i=0; i<_numOfPersons; i++)
        {
            if(m==_group[i].getDateOfBirth().getMonth()) 
                sum++;
        }
        return sum;
    }

    /**
     * check who is the oldest person in the group
     * @return the oldest person in the group
     */
    public Person oldestPerson()
    {
        if (_numOfPersons==0)
            return null;
        Person oldest=_group[0];
        for(int i=1; i<_numOfPersons; i++)
            if(_group[i].older(oldest))
                oldest=_group[i];
        return new Person(oldest);
    }

    /**
     *  Return the first person's first name in the dictionary according to the last name. If that last name belongs to several people-
     *  return the first name of the first person among them in the dictionary according to the first name.
     * @return the first name of the first person in the dictionary according to the last name. 
     */
    public String firstPerson()
    {
        if (_numOfPersons==0)
            return null;
        int first=0;
        for(int i=0; i<_numOfPersons; i++)
        {
            if (_group[i].getLastName().compareTo(_group[first].getLastName())<0) //the last name is before in the dictionary
                first=i;
            else if (_group[i].getLastName().compareTo(_group[first].getLastName())==0) //the same last name
                if (_group[i].getFirstName().compareTo(_group[first].getFirstName())<0)// the first name is before
                    first=i;
        }
        return _group[first].getFirstName();
    }

    /**
     * returns a String that represents all the persons in the group
     * @return String that represents all the persons in the following format for example:
     * Last Name: Netanyahu, First Name: Binyamin, ID: 123456789, Date of birth: 14/06/2017 
     */
    public String toString()
    {
        String s="";
        for(int i=0; i<_numOfPersons; i++)
            s+=_group[i]+"\n";
        return s;
    }
}//end of class Group
