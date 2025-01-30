package se.liu.vicny135.shapes;

import java.awt.*;
import java.util.ArrayList;

public class CircleTest
{
    public static void main(String[] args) {
	final ArrayList<Circle> circles = new ArrayList<>();
	Circle circle1 = new Circle(1, 1, 1, Color.red);
	Circle circle2 = new Circle(2, 2, 2, Color.blue);
	Circle circle3 = new Circle(3, 3, 3, Color.green);
	circles.add(circle1);
	circles.add(circle2);
	circles.add(circle3);
	for (Circle circle : circles) {
	    System.out.println(circle.getX() + ", " + circle.getY());
	}
    }
}
