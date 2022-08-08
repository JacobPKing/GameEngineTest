package delta.src;

import delta.components.GameObject;
import delta.components.SpriteRenderer;
import delta.renderer.Transform;
import delta.util.AssetPool;
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

        GameObject obj2 = new GameObject("Obj2", new Transform(new Vector2f(500,200), new Vector2f(200, 100)));
        obj2.addComponent(new SpriteRenderer(new Vector4f(0.2f,0.2f,0.2f,0f)));
        this.addGameObjectToScene(obj2);

        this.obj1 = new GameObject("Object1", new Transform(new Vector2f(100,100),new Vector2f(100,200)));
        obj1.addComponent(new SpriteRenderer(AssetPool.getTexture("assets/textures/mario.png")));
        this.addGameObjectToScene(obj1);



        loadResources();
    }

    private void loadResources() {
        AssetPool.getShader("assets/shaders/default.glsl");
    }

    @Override
    public void update(float dt) {
        System.out.println(1.0f/dt);

        obj1.transform = new Transform(new Vector2f(obj1.transform.position.x+dt*200,obj1.transform.position.y+dt*20),obj1.transform.scale);
        //System.out.println(obj1.transform.position.x);


        for (GameObject go : this.gameObjects) {
            go.update(dt);
        }

        this.renderer.render();
    }
}
