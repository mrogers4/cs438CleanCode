
/**
 * demonstrate how to solve a maze using recursion
 * 
 * @author Mia Rogers
 * @version November 5, 2016
 */
public class MazeSearch
{
    //  Creates a new maze, prints its original form, attempts
    //  to solve it, and prints out its final form.
    public static void main (String[] args) {
       Maze maze = new Maze();
       
       //Part of the recursion example in the Maze class
       //maze.recursionTest(1);
       
       System.out.println("Maze input data");
       maze.printMaze();
       System.out.println();
       System.out.println("Testing to make sure the valid function works");
       testValid(); //Calls the test function  tests all the possibilities
       
       System.out.println();
       System.out.println("Now testing if maze is solved or not");
       //Assumes that (0,0) is a valid point to start at 
       if (maze.solve(0, 0))
          System.out.println ("Maze solved!");
          
       else
          System.out.println ("No solution.");
          
       maze.printMaze();
    } 
    public static void testValid()
    {
       Maze maze = new Maze();
        
        if (maze.valid(5, 5))
       {
           System.out.println("Point (5, 5) is valid");
       }
       else
       {
           System.out.println("Point (5, 5) is invalid");
       }
       //The row was too small
       if (maze.valid(-1, 5))
       {
           System.out.println("Point (-1, 5) is valid");
       }
       else
       {
           System.out.println("Point (-1, 5) is invalid");
       }
       //T  He column was too big
       if (maze.valid(5, 15))
       {
           System.out.println("Point (5, 15) is valid");
       }
       else
       {
           System.out.println("Point (5, 15) is invalid");
       }
       //THe row was too big
       if (maze.valid(15, 5))
       {
           System.out.println("Point (15, 5) is valid");
       }
       else
       {
           System.out.println("Point (15, 5) is invalid");
       }
       //THe column was too small
       if (maze.valid(5, -5))
       {
           System.out.println("Point (5, -5) is valid");
       }
       else
       {
           System.out.println("Point (5, -5) is invalid");
       }
    }
}
