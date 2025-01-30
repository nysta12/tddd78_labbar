package se.liu.vicny135.lab3;

import se.liu.vicny135.lab1.Person;


public class Stack extends ListManipulators
{

    public void push(Person person){
	elements.add(person);
    }

    public Person pop(){
	return elements.remove(elements.size() - 1);
    }

}
