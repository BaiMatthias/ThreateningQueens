
public class Chessboard {

	private int[][] board;
	private final int QUEENS2PLACE = 8;
	
	public Chessboard(int maxWidth,int maxHeight){
		board = new int[maxWidth][maxHeight];
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board[i].length; j++){
				board[i][j] = -1;
			}
		}
	}
	public int[][] getBoard(){
		return board;
	}
	private void placeQueen(Queen queen){
		board[queen.getX()][queen.getY()] = 1;
	}
	private void removeQueen(Queen queen){
		board[queen.getX()][queen.getY()] = -1;
	}
	public boolean isPlaceforQueenFree(int x, int y){
		// Nicht durch das gesamte Array gehen
		// Stattdessen ausgehend von der Queen Felder checken
		if(!isQueenHorizontal(x,y)&&!isQueenVertical(x,y) && !isQueenLeftDownDiagonal(x,y)&& !isQueenRightDownDiagonal(x,y)){
			return true;
		} 
		else return false;
		
	}
	private boolean isQueenHorizontal(int x,int y){
		for(int i = 0; i<board.length && y <board[i].length; i++){
			if(i != x){
				if(board[i][y] == 1){
					return true;
				}
			}
		}
		return false;
	}
	private boolean isQueenVertical(int x, int y){
		for(int j = 0; j<board[x].length; j++){
			if(j != y){
				if(board[x][j] == 1){
					return true;
				}
			}
		}
		return false;
	}
	private boolean isQueenRightDownDiagonal(int x, int y){ 
		// in beide Richtungen suchen
		// rechts runter = x+1 und y+1
		for(int i = x+1, j = y+1; i < board.length && j < board[i].length; i++,j++){
			if(board[i][j] == 1){
				return true;
			}
		}
		// und links hoch == x-1 und y-1
		for(int i = x-1,j = y-1; i > -1 && j > -1; i--,j--){
			if(board[i][j] == 1){
				return true;
			}
		}
		return false;
	}
	private boolean isQueenLeftDownDiagonal(int x, int y){ 
			// In beide Richtungen gehen
			// Links runter = x-1und y+1
		for(int i = x-1, j = y +1; i > -1 && j < board[i].length; i--, j++){
			if(board[i][j] == 1){
				return true;
			}
		}
		// rechts hoch =  x+1 und y-1
		for(int i = y+1, j = y-1; i < board.length && j > -1; i++, j--){
			if(board[i][j] == 1){
				return true;
			}
		}
		return false;
	}

	
	private void backtracking(int x, int y){
		for(int i = x; i >= 0; i--){
			for(int j = y; j >= 0; j--){
				if(board[i][j] == 1){
					board[i][j] = -1;
					return;
				}
			}
		}
	}
	
	public boolean placeQueensRecur(int x){
		if(x >= board.length){
			return true;
		}
		else{
			boolean isQueenPlaced = false;
			int y = 0;
			while(!isQueenPlaced && y < board.length){
				if(!isPlaceforQueenFree(x,y)){
					y++;
				}
				else{
					Queen queen = new Queen(x, y);
					placeQueen(queen);
					isQueenPlaced = placeQueensRecur(x+1);
					if(!isQueenPlaced){
						removeQueen(queen);
						y++;
					}
				}
			}
			return isQueenPlaced;
		}
	}
	
	
	// Test für die Rekursion
	public static String test(String name){
		if(name.length() == 0){
			return name;
		}
		else{
			System.out.println(name.substring(0,1));
			return name.substring(0,1) + test(  name.substring(1,name.length()  ));
			
		}
		
	}
	
}
