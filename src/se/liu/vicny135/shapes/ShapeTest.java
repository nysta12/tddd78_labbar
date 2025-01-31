package se.liu.vicny135.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeTest
{
    public static void main(String[] args) {
	final List<Shape> shapes = new ArrayList<>();
	Circle circle1 = new Circle(1, 1, 1, Color.red);
	Circle circle2 = new Circle(2, 2, 2, Color.blue);
	Circle circle3 = new Circle(3, 3, 3, Color.green);
	Text text1 = new Text(1, 1, 12, Color.cyan, "Hello");
	Text text2 = new Text(1, 1, 12, Color.orange, "World");
	Rectangle rectangle1 = new Rectangle(1, 1, 1, 1, Color.red);
	Rectangle rectangle2 = new Rectangle(2, 2, 2, 2, Color.blue);
	Rectangle rectangle3 = new Rectangle(3, 3, 3, 3, Color.green);
	shapes.add(circle1);
	shapes.add(circle2);
	shapes.add(circle3);
	shapes.add(rectangle1);
	shapes.add(rectangle2);
	shapes.add(rectangle3);
	shapes.add(text1);
	shapes.add(text2);
	for (Shape shape : shapes) {
	    //shape.draw();
	}
    }
}
