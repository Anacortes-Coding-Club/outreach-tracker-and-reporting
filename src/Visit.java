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
        // [{"name" : "scooby", "tagArray" : ["CC"], "noteArray" : ["bleep bloop", "bloop blorp", "blorp bleep"]},
            String temp;
            temp = "{\"firstName\" : \"" + person.getFirstName()+ "\", \"lastName\" : \"" + person.getLastName()+ "\", \"tagArray\" : [";
            ArrayList <Tag> tempTag = person.getTags();
            for(Tag tag : tempTag)
            {
                temp = temp + "\"" + tag.getTag() + "\", ";
            }
            temp = temp.substring(0,temp.length() - 2);
            temp = temp + "], \"noteArray\" : [";
            ArrayList <Note> tempNote = person.getNotes();
            for(Note note : tempNote)
            {
                temp = temp + "\"" + note.getNote() + "\", ";
            }
            temp = temp.substring(0,temp.length() - 2);
            temp = temp + "]} ,";

            System.out.println("\t\t" + temp);
            /*
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
             */
        }
    }
}