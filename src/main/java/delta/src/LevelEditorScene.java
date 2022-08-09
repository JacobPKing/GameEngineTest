package delta.src;

import delta.components.Entity;
import delta.components.GameObject;
import delta.components.Rectangle;
import delta.components.SpriteRenderer;
import delta.renderer.Transform;
import delta.util.AssetPool;
import delta.util.Color;
import org.joml.Vector2f;
import org.joml.Vector4f;

import static org.lwjgl.glfw.GLFW.*;

public class LevelEditorScene extends Scene{

    public Entity ent;
    public double timepressed = 0;

    public LevelEditorScene() {
        System.out.println("In level editor Scene!");
    }

    @Override
    public void init() {
        loadResources();
        this.camera = new Camera(new Vector2f());

        Entity background = new Entity("bg",0,0,1600,900, AssetPool.getTexture("assets/textures/mariobackground.jpg"));
        this.addGameObjectToScene(background);

        Rectangle rect = new Rectangle("Rect1",0,0,1800,50,new Color(0f,1f,0f,1f));
        //this.gameObjects.add(rect);
        //this.addGameObjectToScene(rect);

        ent = new Entity("Mario2", 200, 120, 200, 200, AssetPool.getTexture("assets/textures/mario.png"));
        this.gameObjects.add(ent);
        this.addGameObjectToScene(ent);
    }

    private void loadResources() {
        AssetPool.getShader("assets/shaders/default.glsl");
    }

    @Override
    public void update(float dt) {
        //System.out.println(1.0f/dt);

        for (GameObject go : this.gameObjects) {
            go.update(dt);
        }

        if (KeyListener.isKeyPressed(GLFW_KEY_SPACE) && ent.getY() < 125) {
            if(timepressed < 60){
                ent.setAy(-150);
                ent.setVy(200);
            }
            timepressed += dt;
        }

        if (KeyListener.isKeyPressed(GLFW_KEY_A)) {

            ent.getComponent(SpriteRenderer.class).setTexCoords(new Vector2f[] {
                    new Vector2f(0,1),
                    new Vector2f(0,0),
                    new Vector2f(1,0),
                    new Vector2f(1,1)
            });

            ent.setVx(-200);
        }
        if (KeyListener.isKeyPressed(GLFW_KEY_D)) {

            ent.getComponent(SpriteRenderer.class).setTexCoords(new Vector2f[] {
                    new Vector2f(1,1),
                    new Vector2f(1,0),
                    new Vector2f(0,0),
                    new Vector2f(0,1)
            });

            ent.setVx(200);
        }

        if (!KeyListener.isKeyPressed(GLFW_KEY_A) && !KeyListener.isKeyPressed(GLFW_KEY_D)) {
            ent.setVx(0);
        }

        if(ent.getY() <= 120) {
            ent.setAy(0);
            ent.setY(120);
        }

        //ent.setY(Math.max(ent.getY(),25));
        //this.camera.moveCamera(ent.getX(),ent.getY());

        this.renderer.render();
    }
}
