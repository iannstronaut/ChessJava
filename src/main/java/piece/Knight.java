package piece;

import chess.GamePanel;



public class Knight extends Piece{
    
    public Knight(int color, int col, int row) {
        super(color, col, row);
        
        if(color == GamePanel.WHITE){
            image = getImage("/piece/w-knight");
        }else{
            image = getImage("/piece/b-knight");
        }
    }

    public boolean canMove(int targetCol, int targerRow) {
        if(isWithinBoard(targetCol, targerRow)){
            if(Math.abs(targetCol - preCol) * Math.abs(targerRow - preRow) == 2){
                if(isValidSquare(targetCol, targerRow)){
                    return true;
                }
            }
        }
        return false;
    }
}
