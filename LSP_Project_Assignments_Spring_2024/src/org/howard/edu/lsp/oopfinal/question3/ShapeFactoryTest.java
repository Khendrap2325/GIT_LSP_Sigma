package org.howard.edu.lsp.oopfinal.question3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShapeFactoryTest {
    @Test
    void testCreateCircle() {
        Shape circle = ShapeFactory.createShape("circle");
        Assertions.assertTrue(circle instanceof Circle);
        Assertions.assertFalse(circle instanceof Rectangle);
    }

    @Test
    void testCreateRectangle() {
        Shape rectangle = ShapeFactory.createShape("rectangle");
        Assertions.assertTrue(rectangle instanceof Rectangle);
        Assertions.assertFalse(rectangle instanceof Circle);
    }
}
