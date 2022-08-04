import java.util.Scanner;
class PaintCalculator {
    public static float SurfaceArea(float width, float height)
    {
        float SurfaceArea = width * height;
        return SurfaceArea;
    }
    public static float MetersPerPaintLitres(float area)
    {
        return area/6.5f;
    }
}
