
/**
 * Write a description of class Maze here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Maze implements MazeMethods
{
   private int[][] theGrid = 
                     {{1,1,1,0,1,1,0,0,0,1,1,1,1},
                      {1,0,1,1,1,0,1,1,1,1,0,0,1},
                      {0,0,0,0,1,0,1,0,1,0,1,0,0},
                      {1,1,1,0,1,1,1,0,1,0,1,1,1},
                      {1,0,1,0,0,0,0,1,1,1,0,0,1},
                      {1,0,1,1,1,1,1,1,0,1,1,1,1},
                      {1,0,0,0,0,0,0,0,0,0,0,0,0},
                      {1,1,1,1,1,1,1,1,1,1,1,1,1}};
   
   public static final int MAX_NUMBER_OF_ROWS   = 8;
   public static final int MAX_NUMBER_OF_COLUMNS = 13;
   public static final int MIN_ROW    = 0;
   public static final int MAX_ROW    = MAX_NUMBER_OF_ROWS - 1;
   public static final int MIN_COLUMN = 0;
   public static final int MAX_COLUMN = MAX_NUMBER_OF_COLUMNS - 1;
   private int theRow    = 0;
   private int theColumn = 0;
    
    public void printMaze()
   {
       for (int r = MIN_ROW; r <= MAX_ROW; r++)
       {
           for (int c = MIN_COLUMN; c <= MAX_COLUMN; c++)
           {
               System.out.print(theGrid[r][c]);
           }
           System.out.println();
       }
   }
   
   //Solve calls itself to move through the maze following the valid path 
   //which is represented by ones 
   //False is returned when a zero is found 
   //True is returned when the cell maxrow & maxcolumn is reached
   public boolean solve(int row, int column)
   {
       boolean bReturn = false;
       //boolean bSuccess = false;
       
       if(valid(row, column))
       {
           theGrid [row][column] = 3;
           //System.out.println("At location: " + row + ", " + column);
           //Are we at the end of the maze?
           if(row == MAX_ROW && column == MAX_COLUMN)
           {
               theGrid [row][column] = 7;
               bReturn = true;
           }
           
           //Try Left
           else if (solve(row - 1, column))
           {
               theGrid [row][column] = 7;
               bReturn = true;
           }
           //Try Right
           else if (solve(row + 1, column))
           {
               theGrid [row][column] = 7;
               bReturn = true;
           }
           //Try Up
           else if (solve(row, column - 1))
           {
               theGrid [row][column] = 7;
               bReturn = true;
           }
           //Try Down
           else if (solve(row, column + 1))
           {
               theGrid [row][column] = 7;
               bReturn = true;
           }
           else
           {
               theGrid [row][column] = 3;
               bReturn = false;
           }
       }
       else
       {
           bReturn = false; 
       }
       return bReturn;
   }
   
   //Making sure the point that is being passed in is in bounds and has a one in it
   public boolean valid(int row, int column)
   {
       boolean bIsWithinBounds = false;
       boolean bIsValidStep = false;
       //Check if we are in bounds
       if ((row >= MIN_ROW && row <= MAX_ROW) && 
       (column >= MIN_COLUMN && column <= MAX_COLUMN))
       {
           bIsWithinBounds = true;
       }
       else
       {
           bIsWithinBounds = false;
       }
       //Now that we know if the point is within bounds, we need to test its value
       if (bIsWithinBounds) //Already knows bIsWithinBounds = true;
       {
           if(theGrid[row][column] == 1)
           {
               bIsValidStep = true;
           }
           else
           {
               bIsValidStep = false;
           }
       }
       return bIsWithinBounds && bIsValidStep;
       
   }
   
   
   //Small example of a recursion code
   /*public void recursionTest(int inNumber)
   {
       int temp;
       for (int i = 0; i < inNumber * 3; i++) 
       {
           System.out.print(" ");
       }
       System.out.println("Entering with: " + inNumber);
       temp = inNumber;
       temp++;
       if (inNumber < 5)
       {
           recursionTest(temp); //calling its own method
       }
       for (int i = 0; i < inNumber * 3; i++) 
       {
               System.out.print(" ");
       }    
           
       System.out.println("Returning with " + inNumber);
       return;
       }
   }*/
}
