
public class Main {

	public static void main(String[] args) {
		Chessboard cb = new Chessboard(8,8);
		cb.placeQueensRecur(0);
		for(int i = 0; i < cb.getBoard().length; i++){
			for(int j = 0; j < cb.getBoard()[i].length; j++){
				if(cb.getBoard()[i][j] == 1){
					System.out.print("Q  ");
				}
				else{
					System.out.print("X  ");
				}
				
			}
			System.out.println();
		}

	}
}
