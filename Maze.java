import java.util.Random;


public class Maze {
	private int width = 0;
	private int height = 0;
	int[][] mazePoints;


	/**
	 * Constructor
	 * 
	 * @param aWidth
	 *            the number of chambers in each row
	 * @param aHeight
	 *            the number of chamber in each column
	 */
	public Maze(int aWidth, int aHeight) {
		width = aWidth;
		height = aHeight;
		mazePoints =new int[height][width];
		createOuterWalls(aWidth, aHeight);
		createWalls(aWidth,aHeight,0,0);
	}

	/**
	 * getWidth
	 * 
	 * @return the width of this maze
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * getHeight
	 * 
	 * @return the height of this maze
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * isNorthWall
	 * 
	 * @param row
	 *            the row identifier of a chamber
	 * @param column
	 *            the column identifier of a chamber
	 * @return true if the chamber at row row and column column contain a north
	 *         wall. Otherwise, return false
	 */
	public boolean isNorthWall(int row, int column) {
		int hold=mazePoints[row][column];
		String holdString=null;
		holdString=Integer.toString(hold);
		if(holdString.length()==1){
			holdString="000"+holdString;
		} else if(holdString.length()==2){
			holdString="00"+holdString;
		} else if(holdString.length()==3){
			holdString="0"+holdString;
		}
		if(holdString.substring(0, 1).equals("1")){
			return true;
		}
		return false;
	}

	/**
	 * isEastWall
	 * 
	 * @param row
	 *            the row identifier of a chamber
	 * @param column
	 *            the column identifier of a chamber
	 * @return true if the chamber at row row and column column contain an east
	 *         wall. Otherwise, return false
	 */
	public boolean isEastWall(int row, int column) {
		int hold=mazePoints[row][column];
		String holdString=null;
		holdString=Integer.toString(hold);
		if(holdString.length()==1){
			holdString="000"+holdString;
		} else if(holdString.length()==2){
			holdString="00"+holdString;
		} else if(holdString.length()==3){
			holdString="0"+holdString;
		}
		if(holdString.substring(1, 2).equals("1")){
			return true;
		}
		return false;
	}

	/**
	 * isSouthWall
	 * 
	 * @param row
	 *            the row identifier of a chamber
	 * @param column
	 *            the column identifier of a chamber
	 * @return true if the chamber at row row and column column contain a south
	 *         wall. Otherwise, return false
	 */
	public boolean isSouthWall(int row, int column) {
		int hold=mazePoints[row][column];
		String holdString=null;
		holdString=Integer.toString(hold);
		if(holdString.length()==1){
			holdString="000"+holdString;
		} else if(holdString.length()==2){
			holdString="00"+holdString;
		} else if(holdString.length()==3){
			holdString="0"+holdString;
		}
		if(holdString.substring(2, 3).equals("1")){
			return true;
		}
		return false;
	}

	/**
	 * isWestWall
	 * 
	 * @param row
	 *            the row identifier of a chamber
	 * @param column
	 *            the column identifier of a chamber
	 * @return true if the chamber at row row and column column contain a west
	 *         wall. Otherwise, return false
	 */
	public boolean isWestWall(int row, int column) {
		int hold=mazePoints[row][column];
		String holdString=null;
		holdString=Integer.toString(hold);
		if(holdString.length()==1){
			holdString="000"+holdString;
		} else if(holdString.length()==2){
			holdString="00"+holdString;
		} else if(holdString.length()==3){
			holdString="0"+holdString;
		}
		if(holdString.substring(3).equals("1")){
			return true;
		}
		return false;
		
	}

	public void createWalls(int aWidth, int aHeight, int startWidth,
			int startHeight) {
		int gap=0;
		int newWidth=0;
		int newHeight=0;
		int totalChamberWidth=aWidth-startWidth;
		int totalChamberHeight=aHeight-startHeight;
		if (totalChamberWidth == 1 || totalChamberHeight == 1) {
			return;
		} else {
			newWidth=(int)(Math.random()*totalChamberWidth-1)+startWidth;
			
			newHeight=(int)(Math.random()*totalChamberHeight-1)+startHeight;
			
			for(int i=startHeight;i<aHeight;i++){
				mazePoints[i][newWidth]+=100;
				mazePoints[i][newWidth+1]+=1;
			}
			for(int i=startWidth;i<aWidth;i++){
				mazePoints[newHeight][i]+=10;
				mazePoints[newHeight+1][i]+=1000;
			}
			int keepWall=(int)(Math.random()*4)+1;
				if(keepWall!=1){
					gap=(int)(Math.random()*(newWidth-startWidth-1))+startWidth;
					mazePoints[newHeight][gap]=mazePoints[newHeight][gap]-10;
					mazePoints[newHeight+1][gap]=mazePoints[newHeight+1][gap]-1000;
				}
				if(keepWall!=2){
					gap=(int)(Math.random()*(aWidth-newWidth-1))+newWidth+1;
					mazePoints[newHeight][gap]=mazePoints[newHeight][gap]-10;
					mazePoints[newHeight+1][gap]=mazePoints[newHeight+1][gap]-1000;
				}
				if(keepWall!=3){
					gap=(int)(Math.random()*(newHeight-startHeight))+startHeight;
					mazePoints[gap][newWidth]=mazePoints[gap][newWidth]-100;
					mazePoints[gap][newWidth+1]=mazePoints[gap][newWidth+1]-1;
				}
				if(keepWall!=4){
					gap=(int)(Math.random()*(aHeight-newHeight-1))+newHeight+1;
					mazePoints[gap][newWidth]=mazePoints[gap][newWidth]-100;
					mazePoints[gap][newWidth+1]=mazePoints[gap][newWidth+1]-1;
				}
				createWalls(newWidth+1,newHeight+1,startWidth,startHeight);
				createWalls(aWidth,newHeight+1,newWidth+1,startHeight);
				createWalls(aWidth,aHeight,newWidth+1,newHeight+1);
				createWalls(newWidth+1,aHeight,startWidth,newHeight+1);
		}
	}
	public void createOuterWalls(int aWidth, int aHeight){
		for(int i=0;i<aWidth;i++){
			mazePoints[0][i]=mazePoints[0][i]+1000;
			mazePoints[aHeight-1][i]=mazePoints[aHeight-1][i]+10;
		}
		for(int i=0;i<aHeight;i++){
			mazePoints[i][0]=mazePoints[i][0]+1;
			mazePoints[i][aWidth-1]=mazePoints[i][aWidth-1]+100;
		}
	}

}