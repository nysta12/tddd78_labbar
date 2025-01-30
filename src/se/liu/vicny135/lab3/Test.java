package se.liu.vicny135.lab3;

import se.liu.vicny135.lab1.Person;

import java.time.LocalDate;

public class Test
{
    public static void main(String[] args) {
	Person person1 = new Person("Person1", LocalDate.of(2001, 1, 1));
	Person person2 = new Person("Person2", LocalDate.of(2002, 2, 2));
	Person person3 = new Person("Person3", LocalDate.of(2003, 3, 3));
	Person person4 = new Person("Person4", LocalDate.of(2004, 4, 4));
	Person person5 = new Person("Person5", LocalDate.of(2005, 5, 5));

	Stack stack = new Stack();
	stack.add(person1);
	stack.add(person2);
	stack.add(person3);
	stack.add(person4);
	stack.add(person5);

	Queue queue = new Queue();
	queue.add(person1);
	queue.add(person2);
	queue.add(person3);
	queue.add(person4);
	queue.add(person5);

	System.out.println("Stack:");
	while (! stack.isEmpty()){
	    System.out.println(stack.pop());
	}
	System.out.println(System.lineSeparator() + "Queue:");
	while (!queue.isEmpty()){
	    System.out.println(queue.dequeue());
	}
    }
}
