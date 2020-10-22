package references.parameters;

public class ReferencesMain {

    public static void main(String[] args) {
        Person person = new Person("John Doe", 27);
        Person otherPerson = person;

        otherPerson.setName("Jack Doe");

        System.out.println(person.getName() + " " + person.getAge());
        System.out.println(otherPerson.getName() + " " + otherPerson.getAge());
        //Mindkettő változott, mert a referencia másolása történt, így ugyanarra az objektumra mutatnak.

        int number1 = 24;
        int number2 = number1;

        number2++;

        System.out.println(number1);
        System.out.println(number2); //Csak a number2 változott, mert az érték átmásolása történt.

        otherPerson = new Person("Jane Doe", 32);
        System.out.println(person.getName() + " " + person.getAge());
        System.out.println(otherPerson.getName() + " " + otherPerson.getAge());
        //A két változóban más-más érték van, mert az otherPerson változóban lecserélődött a referencia, így már két külön objektumra mutatnak.
    }
}
