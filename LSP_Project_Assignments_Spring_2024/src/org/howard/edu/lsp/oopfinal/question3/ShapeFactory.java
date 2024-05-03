package org.howard.edu.lsp.oopfinal.question3;

public class ShapeFactory {
	 public static Shape createShape(String type) {
	        if (type.equalsIgnoreCase("circle")) return new Circle();
	        if (type.equalsIgnoreCase("rectangle")) return new Rectangle();
	        return null;
	    }

}
