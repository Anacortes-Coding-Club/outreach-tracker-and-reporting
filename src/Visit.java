import java.util.ArrayList;
public class Visit
{
    private ArrayList<Person> personStorage = new ArrayList<>();

    public ArrayList<Person> getPersons()
    {
        return personStorage;
    }
    public void setPerson(ArrayList<Person> input)
    {
        personStorage = input;
    }
    public void addPerson(Person input)
    {
        personStorage.add(input);
    }
    public void printPersons()
    {
        for (Person person : personStorage)
        {
            System.out.print("\t");
            person.printFirstName();
            System.out.print(" ");
            person.printLastName();
            System.out.println();
            System.out.print("\t\t");
            person.printTags();
            System.out.println();
            person.printNotes();
            System.out.println();
        }
    }
}