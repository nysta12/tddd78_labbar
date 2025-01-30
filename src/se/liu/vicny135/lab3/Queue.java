package se.liu.vicny135.lab3;

import se.liu.vicny135.lab1.Person;


public class Queue extends ListManipulators
{

    public void enqueue(Person person){
	elements.add(person);
    }

    public Person dequeue(){
	return elements.remove(0);
    }

}
