
/**
 * This is a driver for the other classes- Date Person and Group
 *
 * @author Rina Gantz
 * @version 16/03/2020
 */

public class Driver
{
    public static void main (String[] args)
    {
        Group array=new Group();
        Person man1=new Person("Dan","Danino",123456789,23,05,2000);
        Person man2=new Person("Gad","Levy",987654321,37,07,2002);
        Person man3=new Person("Yoel","Danino",123123123,20,04,2001);
        array.addPerson(man1);
        array.addPerson(man2);
        array.addPerson(man3);
        System.out.println("All the data of the persons in the group: \n"+array);
        System.out.println("The oldest person in the group is: "+array.oldestPerson());
        System.out.println("The first person's first name in the dictionary according to the last name is: "+array.firstPerson());
        System.out.println("The number of persons that were born on the given date- 23/05/2000: "+array.bornInDate(new Date(23,05,2000)));
        System.out.println("The number of persons that were born on the given month- April: "+array.bornInMonth(4));
    }// end of method main
}//end of class Driver