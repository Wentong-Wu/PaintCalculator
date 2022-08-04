import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        PaintCalculator Pcalc = new PaintCalculator();
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
            WallsToPaint += Pcalc.SurfaceAreaOfWall(width,length)*coating;
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
            ObjectsToExclude += Pcalc.SurfaceAreaOfWall(width,length);
        }
        //Calculate the total amount of area required for the area to paint.
        TotalAreaToPaint = WallsToPaint - ObjectsToExclude;
        System.out.println(TotalAreaToPaint+" meter squared required painting");

        PaintPerLitre = Pcalc.MetersPerPaintLitres(TotalAreaToPaint);
        System.out.println(PaintPerLitre+" litres of paint needed."); //Tell the user how much litre of paint needed.
        System.out.println(Math.ceil(PaintPerLitre)+" litres of paint you should buy."); //Tell the user how much litre of paint needed.
    }
}
