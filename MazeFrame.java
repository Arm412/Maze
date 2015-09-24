import java.util.ArrayList;
import javax.swing.JFrame;

public class MazeFrame
{
	public static void main(String[] args) throws InterruptedException
	{
		int width = 25;
		int height = 25;
		JFrame frame = new JFrame();
		Maze maze = new Maze(width, height);
		ArrayList<Pair<Integer,Integer>> solution = new ArrayList<Pair<Integer,Integer>>();
		MazeComponent mc = new MazeComponent(maze, solution);
		frame.setSize(800,800);
		frame.setTitle("Maze");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mc);
		frame.setVisible(true);
		
		solution.add(new Pair<Integer,Integer>(0,0));
		Thread.sleep(1000);
		solveMaze(solution, mc, maze, 0,0,4);
		mc.repaint();
	}
	
	/** Solve Maze: recursively solve the maze
	 * 
	 * @param solution   : The array list solution is needed so that every recursive call,
	 *                     a new (or more) next position can be added or removed.
	 * @param mc         : This is the MazeComponent. We need that only for the purpose of
	 *                     animation. We need to call mc.repaint() every time a new position
	 *                     is added or removed. For example,
	 *                       :
	 *                     solution.add(...);
	 *                     mc.repaint();
	 *                     Thread.sleep(sleepTime);
	 *                       :
	 *                     solution.remove(...);
	 *                     mc.repaint();
	 *                     Thread.sleep(sleepTime);
	 *                       :
	 * @param maze       : The maze data structure to be solved. 
	 * @return a boolean value to previous call to tell the previous call whether a solution is
	 *         found.
	 * @throws InterruptedException: We need this because of our Thread.sleep(50);
	 */
	
	public static boolean solveMaze(ArrayList<Pair<Integer,Integer>> solution, MazeComponent mc, Maze maze,int xPosition,int yPosition,int dontTestThisWay) throws InterruptedException
	{
		boolean solved=false;
		if(xPosition==maze.getWidth()-1 && yPosition==maze.getHeight()-1){
			return true;
		}
		if(maze.isNorthWall(yPosition,xPosition)==false && dontTestThisWay!=1){
			Pair<Integer,Integer> position=new Pair<Integer,Integer>(yPosition-1,xPosition);
			solution.add(position);
			mc.repaint();
			Thread.sleep(10);
			solved=solveMaze( solution,  mc,  maze, xPosition,yPosition-1,3);
			if(solved==true){
				return solved;
			}
			solution.remove(position);
			mc.repaint();
			Thread.sleep(10);
		} 
		if(maze.isEastWall(yPosition, xPosition)==false && dontTestThisWay!=2){
			Pair<Integer,Integer> position=new Pair<Integer,Integer>(yPosition,xPosition+1);
			solution.add(position);
			mc.repaint();
			Thread.sleep(10);
			solved=solveMaze( solution,  mc,  maze, xPosition+1,yPosition,4);
			if(solved==true){
				return solved;
			}
			solution.remove(position);
			mc.repaint();
			Thread.sleep(10);
		} 
		if(maze.isSouthWall(yPosition,xPosition)==false && dontTestThisWay!=3){
			Pair<Integer,Integer> position=new Pair<Integer,Integer>(yPosition+1,xPosition);
			solution.add(position);
			mc.repaint();
			Thread.sleep(10);
			solved=solveMaze( solution,  mc,  maze, xPosition,yPosition+1,1);
			if(solved==true){
				return solved;
			}
			solution.remove(position);
			mc.repaint();
			Thread.sleep(10);
		} 
		if(maze.isWestWall(yPosition, xPosition)==false && dontTestThisWay!=4){
			Pair<Integer,Integer> position=new Pair<Integer,Integer>(yPosition,xPosition-1);
			solution.add(position);
			mc.repaint();
			Thread.sleep(10);
			solved=solveMaze( solution,  mc,  maze, xPosition-1,yPosition,2);
			if(solved==true){
				return solved;
			}
			solution.remove(position);
			mc.repaint();
			Thread.sleep(10);
		}
		return false;
	} 
} 