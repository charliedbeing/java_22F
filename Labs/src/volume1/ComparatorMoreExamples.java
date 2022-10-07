package volume1;

import java.util.Arrays;
import java.util.Comparator;

class Person{
    private String firstname;
    private String lastname;

    public String getFirstname(){
        return firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public Person(String f, String l){
        this.firstname =f;
        this.lastname =l;
    }

    @Override
    public String toString() {
        return this.firstname + '-'+ this.lastname;
    }
}

public class ComparatorMoreExamples {
    public static void main(String[] args) {
        Person[] people = new Person[5];
        people[0]= new Person("Charlie","ding");
        people[1]= new Person("Nike","bai");
        people[2]= new Person("Fiona","yanguangmei");
        people[3]= new Person("Daniel","ding");
        people[4]= new Person("Nancy","wangermazishiren");
        sortPerson_1(people);
        Arrays.asList(people).forEach(System.out::println);
        sortPerson_2(people);
        System.out.println("----------------------");
        Arrays.asList(people).forEach(System.out::println);

        System.out.println("----------------------");
        sortPerson_3(people);

        Arrays.asList(people).forEach(System.out::println);
    }

    public static void sortPerson_1(Person[] people ){
        Arrays.sort(people, Comparator.comparing(Person::getFirstname,(s,t)->Integer.compare(s.length(),t.length())));
    }

    public static void sortPerson_2(Person[] people ){
        Arrays.sort(people, Comparator.comparingInt(p-> p.getFirstname().length()));
    }

    public static void sortPerson_3(Person[] people ){
        Arrays.sort(people,
                Comparator.comparing(Person::getFirstname,(s,t)->Integer.compare(s.length(),t.length()))
                .thenComparing(Person::getLastname,(s,t)->Integer.compare(s.length(),t.length())));
    }


}
