import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        //Ask user to enter length
        System.out.println("Enter length of wall in meters: ");
        float length = input.nextFloat();
        //Ask user to enter width
        System.out.println("Enter width of wall in meters: ");
        float width = input.nextFloat();
        //Surface Area
        float surfaceArea = length*width;
        //Windows or doors?
        System.out.println("Enter number of windows and doors: ");
        int area_to_exclude = input.nextInt();
        float exclude_length = 0;
        float exclude_width = 0;
        float exclude_area = 0;
        for (int i = 0; i < area_to_exclude;i++)
        {
            System.out.println("Enter length of windows/doors in meters: ");
            exclude_length = input.nextFloat();
            System.out.println("Enter width of windows/doors in meters: ");
            exclude_width = input.nextFloat();
            exclude_area = exclude_length*exclude_width;
        }
        surfaceArea -= exclude_area; //Area to exclude.
        //Ask how many coats of paint.
        System.out.println("Enter the number of coats you want apply: ");
        float coat = input.nextFloat();
        // Calculate the surface area of the height and width of the wall and the number of coats.
        float volume = surfaceArea * coat;
        System.out.println(volume+" metres squared."); //Print surface area needed.
        float paint_per_litre = volume/6.5f; //Estimate around 6.5 litres per meter squared.
        System.out.println(paint_per_litre+" litres of paint needed."); //Tell the user how much litre of paint needed.
        System.out.println(Math.ceil(paint_per_litre)+" litres of paint you should buy."); //Tell the user how much litre of paint needed.
    }
}
