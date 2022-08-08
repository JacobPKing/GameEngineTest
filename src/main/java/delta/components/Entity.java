package delta.components;

import delta.renderer.Texture;
import delta.renderer.Transform;
import org.joml.Vector2f;

public class Entity extends GameObject{
    private float x;
    private float y;
    private float vx = 0;
    private float vy = 0;
    private float ax = 0;
    private float ay = 0;
    private float xSize;
    private float ySize;
    private Texture texture;

    public Entity(String name, Transform transform) {
        super(name, transform);
    }

    public Entity(String name, float x, float y, float xSize, float ySize, Texture texture) {
        super(name, new Transform(new Vector2f(x, y), new Vector2f(xSize,ySize)));
        this.addComponent(new SpriteRenderer(texture));
    }

    public void update(float dt) {
        this.transform = new Transform(new Vector2f(this.transform.position.x + vx * dt, this.transform.position.y + vy * dt), this.transform.scale);
        this.vx+=(this.ax*dt);
        this.vy+=(this.ay*dt);
        for( int i = 0; i < components.size(); i++) {
            components.get(i).update(dt);
        }

    }

}
