import java.util.Scanner;
class PaintCalculator {
    public static float SurfaceAreaOfWall(float width, float height)
    {
        return width * height;
    }
    public static float AreaOfCircle(float radius)
    {
        return 3.1416f*radius*radius;
    }
    public static float AreaOfTriangle(float base, float height)
    {
        return 0.5f*base*height;
    }
    public static float MetersPerPaintLitres(float area)
    {
        return area/6.5f;
    }
    public static float FeetPerMeters(float feet)
    {
        return feet*3.28084f;
    }
    public static float CentimeterPerMeter(float cm){
        return cm*100;
    }
    public static float InchesPerMeter(float inch)
    {
        return inch*39.3701f;
    }
}
