package piece;

import chess.GamePanel;



public class Rook extends Piece{
    
    public Rook(int color, int col, int row) {
        super(color, col, row);
        
        if(color == GamePanel.WHITE){
            image = getImage("/piece/w-rook");
        }else{
            image = getImage("/piece/b-rook");
        }
    }

    public boolean canMove(int targetCol, int targerRow) {
        if(isWithinBoard(targetCol, targerRow) && isSameSquare(targetCol, targerRow) == false){
            if(targetCol == preCol || targerRow == preRow){
                if(isValidSquare(targetCol, targerRow) && pieceIsOnStraightLine(targetCol, targerRow) == false){
                    return true;
                }
            }
        }
        return false;
    }
}
