import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    static float MetersPerPaintLitres(float area)
    {
        return area/6.5f;
    }
    static void DisplayMenu() //Display the menu
    {
        System.out.println(
                """
                        ====Display=Menu====
                        1...Add wall dimensions.
                        2...Add objects to exclude.
                        3...Remove wall dimensions you last entered.
                        4...Remove object to exclude you last entered.
                        5...Run Calculation.
                        
                        0...Quit
                        Select your option (1-5) :
                        """
        );
    }
    static float AddWallDimension(Scanner input)
    {
        System.out.println("Enter length of wall in meters: ");
        float length = input.nextFloat();
        System.out.println("Enter width of wall in meters: ");
        float width = input.nextFloat();
        System.out.println("Enter number of coating: ");
        float coat = input.nextFloat();
        return length*width*coat;
    }
    static float AddObjectDimension(Scanner input)
    {
        System.out.println("Enter length of object in meters: ");
        float length = input.nextFloat();
        System.out.println("Enter width of object in meters: ");
        float width = input.nextFloat();
        return length*width;
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int useroption;
        boolean quit = false;
        List WallDimension = new ArrayList();
        List ObjectDimension = new ArrayList();
        float totalWallDimension=0;
        float totalObjectDimension=0;
        float totalPaintNeeded;
        float paintPerLitre;
        while (!quit) {
            System.out.println();
            DisplayMenu();
            useroption = input.nextInt();
            switch (useroption) {
                case 1:
                    WallDimension.add(AddWallDimension(input));
                    break;
                case 2:
                    ObjectDimension.add(AddObjectDimension(input));
                    break;
                case 3:
                    try {
                        WallDimension.remove(WallDimension.size()-1);
                    }
                    catch (Exception e)
                    {
                        System.out.println("Please add a wall first.");
                    }
                    break;
                case 4:
                    try {
                        ObjectDimension.remove(ObjectDimension.size()-1);
                    }
                    catch (Exception e)
                    {
                        System.out.println("Please add a object first.");
                    }
                    break;
                case 5:
                    if (WallDimension.size() != 0){
                        for (int i = 0; i <WallDimension.size();i++)
                        {
                            totalWallDimension += (float) WallDimension.get(i);
                        }
                        if (ObjectDimension.size() != 0)
                        {
                            for(int i = 0; i < ObjectDimension.size();i++)
                            {
                                totalObjectDimension += (float) ObjectDimension.get(i);
                            }
                        }
                        totalPaintNeeded = totalWallDimension - totalObjectDimension;
                        paintPerLitre = MetersPerPaintLitres(totalPaintNeeded);
                        System.out.println(totalPaintNeeded+" meter squared required painting");
                        System.out.println(paintPerLitre+" litres of paint needed."); //Tell the user how much litre of paint needed.
                        System.out.println(Math.ceil(paintPerLitre)+" litres of paint you should buy."); //Tell the user how much litre of paint needed.
                    }
                    else
                        System.out.println("Please add a wall to calculate");
                    break;

                case 0:
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }
        System.out.println("Application Closed.");
    }
}
