package delta.components;

import delta.renderer.Transform;

public abstract class Shape extends GameObject{
    public Shape(String name, Transform transform) {
        super(name, transform);
    }
}
