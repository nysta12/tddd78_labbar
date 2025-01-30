package se.liu.vicny135.lab1;
import java.time.LocalDate;
import java.time.Period;

public class Person
{
    public String name;
    private LocalDate birthDay;
    public Person(String name, LocalDate birthDay){
	this.name = name;
	this.birthDay = birthDay;
    }
    public int getAge(){
	return Period.between(birthDay,LocalDate.now()).getYears();
    }
    public String toString(){

	return name + " " + getAge();
    }
    public static void main(String[] args) {
	Person p1 = new Person("Victor", LocalDate.of(2000,5,26));
	Person p2 = new Person("Ludvig", LocalDate.of(2002,2,26));
	Person p3 = new Person("José", LocalDate.of(2001,8,24));
	System.out.println(p1);
	System.out.println(p2);
	System.out.println(p3);
    }
}
