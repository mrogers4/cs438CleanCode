
/**
 * Write a description of interface MazeMethods here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface MazeMethods
{
    //prints the maze grid
    public void printMaze();
	
    //attempts to recursively traverse the maze
    public boolean solveTheMaze(int row, int column);
	
    //determines if a specific location is valid
    public boolean isValid(int row, int column);
}
