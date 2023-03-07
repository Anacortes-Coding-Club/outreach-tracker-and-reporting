import java.util.ArrayList;
public class Visit
{
    private ArrayList<Person> personStorage = new ArrayList<>();

    public ArrayList<Person> getPersons()
    {
        return personStorage;
    }
    public void setPerson(ArrayList<Person> input){
        personStorage = input;
    }
    public void addPerson(Person input)
    {
        personStorage.add(input);
    }
    public void printPersons()
    {
        for (Person person : personStorage) {
            person.printFirstName();
            System.out.print(" ");
            person.printLastName();
            System.out.println();
            person.printNotes();
            person.printTags();
            System.out.println();
        }
    }
}