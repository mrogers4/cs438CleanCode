
/**
 * Write a description of class Maze here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Maze implements MazeMethods
{
   private int[][] theMaze = 
                     {{1,1,1,0,1,1,0,0,0,1,1,1,1},
                      {1,0,1,1,1,0,1,1,1,1,0,0,1},
                      {0,0,0,0,1,0,1,0,1,0,1,0,0},
                      {1,1,1,0,1,1,1,0,1,0,1,1,1},
                      {1,0,1,0,0,0,0,1,1,1,0,0,1},
                      {1,0,1,1,1,1,1,1,0,1,1,1,1},
                      {1,0,0,0,0,0,0,0,0,0,0,0,0},
                      {1,1,1,1,1,1,1,1,1,1,1,1,1}};
   
   public static final int MAX_NUMBER_OF_ROWS = 8;
   public static final int MAX_NUMBER_OF_COLUMNS = 13;
   public static final int MIN_ROW = 0;
   public static final int MAX_ROW = MAX_NUMBER_OF_ROWS - 1;
   public static final int MIN_COLUMN = 0;
   public static final int MAX_COLUMN = MAX_NUMBER_OF_COLUMNS - 1;
   private int theRow = 0;
   private int theColumn = 0;
    
    public void printMaze() {
       for (int r = MIN_ROW; r <= MAX_ROW; r++) {
           for (int c = MIN_COLUMN; c <= MAX_COLUMN; c++) {
               System.out.print(theGrid[r][c]);
           }
           System.out.println();
       }
   }
   
  
   public boolean solveTheMaze(int row, int column)
   {
       boolean bReturn = false;
       
       
       if(isAValidPoint(row, column)) {
           theMaze [row][column] = 3;
           
           //Are we at the end of the maze?
           if(row == MAX_ROW && column == MAX_COLUMN)  {
               theMaze [row][column] = 7;
               bReturn = true;
           }
           
           //Try Left
           else if (solveTheMaze(row - 1, column)) {
               theMaze [row][column] = 7;
               bReturn = true;
           }
           //Try Right
           else if (solveTheMaze(row + 1, column)) {
               theMaze [row][column] = 7;
               bReturn = true;
           }
           //Try Up
           else if (solveTheMaze(row, column - 1)) {
               theMaze [row][column] = 7;
               bReturn = true;
           }
           //Try Down
           else if (solveTheMaze(row, column + 1)) {
               theMaze [row][column] = 7;
               bReturn = true;
           } else {
               theMaze [row][column] = 3;
               bReturn = false;
           }
       } else {
           bReturn = false; 
       }
       return bReturn;
   }
   
 
   public boolean isAValidPoint(int row, int column) {
       boolean bIsWithinBounds = false;
       boolean bIsValidStep = false;
       //Check if we are in bounds
       if ((row >= MIN_ROW && row <= MAX_ROW) && 
       (column >= MIN_COLUMN && column <= MAX_COLUMN)) {
           bIsWithinBounds = true;
       } else {
           bIsWithinBounds = false;
       }
       
       if (bIsWithinBounds) { //Already knows bIsWithinBounds = true; 
    
           if(theMaze[row][column] == 1) {
               bIsValidStep = true;
           } else {
               bIsValidStep = false;
           }
       }
       return bIsWithinBounds && bIsValidStep;
       
   }
   
}
