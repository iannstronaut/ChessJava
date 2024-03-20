package piece;

import chess.GamePanel;



public class Queen extends Piece{
    
    public Queen(int color, int col, int row) {
        super(color, col, row);
        
        if(color == GamePanel.WHITE){
            image = getImage("/piece/w-queen");
        }else{
            image = getImage("/piece/b-queen");
        }
    }
    public boolean canMove(int targetCol, int targerRow) {
        if(isWithinBoard(targetCol, targerRow) && isSameSquare(targetCol, targerRow) == false){

            //Vertical & Horizontal
            if (targetCol == preCol || targerRow == preRow){
                if(isValidSquare(targetCol, targerRow) && pieceIsOnStraightLine(targetCol, targerRow) == false){
                    return true;
                }
            }

            //Diagonal
            if(Math.abs(targetCol - preCol) == Math.abs(targerRow - preRow)){
                if(isValidSquare(targetCol, targerRow) && pieceIsOnDiagonalLine(targetCol, targerRow) == false){
                    return true;
                }
            }
        }
        return false;
    }
}
