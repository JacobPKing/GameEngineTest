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
        this.x = x;
        this.y = y;
        this.xSize = xSize;
        this.ySize = ySize;
        this.texture = texture;
    }

    public Entity(String name, float x, float y, float vx, float vy, float xSize, float ySize, Texture texture) {
        super(name, new Transform(new Vector2f(x, y), new Vector2f(xSize,ySize)));
        this.addComponent(new SpriteRenderer(texture));
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.xSize = xSize;
        this.ySize = ySize;
        this.texture = texture;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getVx() {
        return vx;
    }

    public void setVx(float vx) {
        this.vx = vx;
    }

    public float getVy() {
        return vy;
    }

    public void setVy(float vy) {
        this.vy = vy;
    }

    public float getAx() {
        return ax;
    }

    public void setAx(float ax) {
        this.ax = ax;
    }

    public float getAy() {
        return ay;
    }

    public void setAy(float ay) {
        this.ay = ay;
    }

    public float getxSize() {
        return xSize;
    }

    public void setxSize(float xSize) {
        this.xSize = xSize;
    }

    public float getySize() {
        return ySize;
    }

    public void setySize(float ySize) {
        this.ySize = ySize;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void update(float dt) {
        this.x += vx * dt;
        this.y += vy * dt;
        this.vx+=(this.ax*dt);
        this.vy+=(this.ay*dt);

        this.transform = new Transform(new Vector2f(this.x, this.y), this.transform.scale);

        for( int i = 0; i < components.size(); i++) {
            components.get(i).update(dt);
        }
    }

}
