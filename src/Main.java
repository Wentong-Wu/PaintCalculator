import java.util.Scanner;


public class Main {
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
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        //Ask user for number of walls input
        System.out.println("Enter number of walls to paint: ");
        int walls = input.nextInt();
        float length,width,coating;
        float WallsToPaint = 0;
        float ObjectsToExclude =0;
        float TotalAreaToPaint=0;
        float PaintPerLitre=0;

        //Ask for each wall details.
        for (int i =1;i<=walls;i++)
        {
            //Ask user to enter length
            System.out.println("Enter length of wall number ("+i+") in meters: ");
            length = input.nextFloat();
            //Ask user to enter width
            System.out.println("Enter width of wall number ("+i+") in meters: ");
            width = input.nextFloat();
            System.out.println("Enter number of coating for this wall: ");
            coating = input.nextFloat();
            WallsToPaint += SurfaceAreaOfWall(width,length)*coating;
        }

        //Get object to exclude from the paint such as windows or doors.
        System.out.println("Enter number of object to exclude from the paint (doors/windows): ");
        int object_to_exclude = input.nextInt();
        //Get the surface area of the objects to exclude.
        for (int i =0;i<object_to_exclude;i++)
        {
            System.out.println("Enter length of object number ("+i+") in meters: ");
            length = input.nextFloat();
            System.out.println("Enter width of object number ("+i+") in meters: ");
            width = input.nextFloat();
            ObjectsToExclude += SurfaceAreaOfWall(width,length);
        }
        //Calculate the total amount of area required for the area to paint.
        TotalAreaToPaint = WallsToPaint - ObjectsToExclude;
        System.out.println(TotalAreaToPaint+" meter squared required painting");

        PaintPerLitre = MetersPerPaintLitres(TotalAreaToPaint);
        System.out.println(PaintPerLitre+" litres of paint needed."); //Tell the user how much litre of paint needed.
        System.out.println(Math.ceil(PaintPerLitre)+" litres of paint you should buy."); //Tell the user how much litre of paint needed.
    }
}
