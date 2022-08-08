package delta.components;

import delta.renderer.Transform;
import delta.util.Color;
import org.joml.Vector2f;

public class Rectangle extends Shape{

    public Rectangle(String name, Transform transform) {
        super(name, transform);
    }

    public Rectangle(String name, int x, int y, int xsize, int ysize, Color color) {
        super(name, new Transform(new Vector2f(x, y), new Vector2f(xsize,ysize)));
        this.addComponent(new SpriteRenderer(color.getColor()));
    }

}
