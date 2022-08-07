package delta.src;

import delta.components.GameObject;
import delta.components.SpriteRenderer;
import delta.renderer.Transform;
import org.joml.Vector2f;
import org.joml.Vector4f;

public class LevelEditorScene extends Scene{

    public LevelEditorScene() {
        System.out.println("In level editor Scene!");
    }

    @Override
    public void init() {
        this.camera = new Camera(new Vector2f());

        int xOffset = 10;
        int yOffset = 10;

        float totalWidth = (float) (500 - xOffset * 2);
        float totalHeight = (float) (500 - yOffset * 2);

        float sizeX = totalWidth / 100f;
        float sizeY = totalWidth / 100f;

        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                float xPos = xOffset + (x * sizeX);
                float yPos = yOffset + (y * sizeY);

                GameObject go = new GameObject("Obj" + x + "" + y, new Transform(new Vector2f(xPos, yPos), new Vector2f(sizeX, sizeY)));
                go.addComponent(new SpriteRenderer(new Vector4f(xPos / totalWidth, yPos/ totalHeight,(xPos + yPos) / (totalHeight + totalWidth),1)));
                this.addGameObjectToScene(go);
            }
        }
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
