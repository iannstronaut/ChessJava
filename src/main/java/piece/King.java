package piece;

import chess.GamePanel;

public class King extends Piece{
    
    public King(int color, int col, int row) {
        super(color, col, row);
        
        if(color == GamePanel.WHITE){
            image = getImage("/piece/w-king");
        }else{
            image = getImage("/piece/b-king");
        }
    }

    public boolean canMove(int targetCol, int targerRow) {

        if(isWithinBoard(targetCol, targerRow)){
            if(Math.abs(targetCol - preCol) + Math.abs(targerRow - preRow) == 1 ||
                Math.abs(targetCol - preCol) * Math.abs(targerRow - preRow) == 1){

                if(isValidSquare(targetCol, targerRow)){
                    return true;
                }
            }
        }

        return false;
    }
}
