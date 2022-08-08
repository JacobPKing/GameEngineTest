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

public class LevelEditorScene extends Scene{

    public GameObject obj1;

    public LevelEditorScene() {
        System.out.println("In level editor Scene!");
    }

    @Override
    public void init() {
        this.camera = new Camera(new Vector2f());

        Rectangle rect = new Rectangle("Rect1",0,0,100,100,Color.RED);
        this.addGameObjectToScene(rect);

        this.obj1 = new GameObject("Object1", new Transform(new Vector2f(300,300),new Vector2f(200,200)));
        obj1.addComponent(new SpriteRenderer(AssetPool.getTexture("assets/textures/mario.png")));
        this.addGameObjectToScene(obj1);

        Entity ent = new Entity("Mario2", 500, 500, 20, 200, AssetPool.getTexture("assets/textures/mario.png"));
        this.addGameObjectToScene(ent);


        loadResources();
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

        this.renderer.render();
    }
}
