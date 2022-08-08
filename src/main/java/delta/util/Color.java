package delta.util;

import org.joml.Vector4f;

public class Color {
    private float r;
    private float g;
    private float b;
    private float a;

    public static final Color RED = new Color(1f,0f,0f,1f);

    public Color(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Color(int r, int g, int b, int a) {
        this.r = r / 255;
        this.g = g / 255;
        this.b = b / 255;
        this.a = a / 255;
    }

    public Vector4f getColor() {
        return new Vector4f(r,g,b,a);
    }
}
