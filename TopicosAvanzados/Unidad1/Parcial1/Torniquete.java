import java.util.Vector;

import util.ToolBox;

public class Torniquete {
    private Person[] people;
    private Vector<Person> vipPeople;

    public Torniquete(int vipOrigin)
    {
        people = new Person[ToolBox.randInt(50, 100)];
        for (int i = 0; i < people.length; i++) {
            people[i] = new Person(i + 1);
        }
        int vipIndex = vipOrigin;
        vipPeople = new Vector<>(5);
        for (int i = vipIndex - 5; i < vipIndex; i++) {
            people[i].setVipAccess(true);
            people[i].setName(ToolBox.randName(2));
            vipPeople.add(people[i]);
            System.out.println(people[i].getId() + "| " + people[i].getName() + " |" + people[i].getAccessTokens()
                    + "| VIP: " + people[i].isVipAccess());
        }
    }

    public boolean enter(String id)
    {
        Person curPerson = searchPerson(id);
        if(!curPerson.HasEntered())
        {
            curPerson.setHasEntered();
            curPerson.discountToken();
            return true;
        }
        else
            return false;
            //ToolBox.Alert("Esta persona ya se encuentra adentro", "Error");
    }

    public boolean exit(String id)
    {
        Person curPerson = searchPerson(id);
        if(curPerson.HasEntered())
        {
            curPerson.setHasEntered();
            curPerson.discountToken();
            return true;
        }
        else
            return false;
            //ToolBox.Alert("Esta persona ya no se encuetra adentro", "Error");
    }

    private Person searchPerson(String id)
    {
        for (Person person : people) {
            if(id.equals(Integer.toString(person.getId())) || id.equals(person.getName()))
            {
                return person;
            }
        }
        return null;
    }

    public Person[] getPeople() {
        return people;
    }

    public Person getPeople(int index)
    {
        return people[index];
    }

    public Vector<Person> getVipPeople() {
        return vipPeople;
    }

    public Person getVipPeople(int index)
    {
        return vipPeople.get(index);
    }
}
