
/**
 * demonstrate how to solve a maze using recursion
 * 
 * @author Mia Rogers
 * @version November 5, 2016
 */
public class MazeSearch
{

    public static void main (String[] args) {
       Maze maze = new Maze();
       

       
       System.out.println("Maze input data");
       maze.printMaze();
       System.out.println();
       System.out.println("Testing to make sure the valid function works");
       testValidPoints();
       
       System.out.println();
       System.out.println("Now testing if maze is solved or not");
       //Assumes that (0,0) is a valid point to start at 
       if (maze.solveTheMaze(0, 0))
          System.out.println ("Maze solved!");
          
       else
          System.out.println ("No solution.");
          
       maze.printMaze();
    } 
    public static void testValidPoints()
    {
       Maze maze = new Maze();
        
        if (maze.isAValidPoint(5, 5))
       {
           System.out.println("Point (5, 5) is valid");
       }
       else
       {
           System.out.println("Point (5, 5) is invalid");
       }
       //The row was too small
       if (maze.isAValidPoint(-1, 5))
       {
           System.out.println("Point (-1, 5) is valid");
       }
       else
       {
           System.out.println("Point (-1, 5) is invalid");
       }
       //T  He column was too big
       if (maze.isAValidPoint(5, 15))
       {
           System.out.println("Point (5, 15) is valid");
       }
       else
       {
           System.out.println("Point (5, 15) is invalid");
       }
       //THe row was too big
       if (maze.isAValidPoint(15, 5))
       {
           System.out.println("Point (15, 5) is valid");
       }
       else
       {
           System.out.println("Point (15, 5) is invalid");
       }
       //THe column was too small
       if (maze.isAValidPoint(5, -5))
       {
           System.out.println("Point (5, -5) is valid");
       }
       else
       {
           System.out.println("Point (5, -5) is invalid");
       }
    }
}
