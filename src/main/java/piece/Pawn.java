package piece;

import chess.GamePanel;

public class Pawn extends Piece{
    
    public Pawn(int color, int col, int row) {
        super(color, col, row);
        
        if(color == GamePanel.WHITE){
            image = getImage("/piece/w-pawn");
        }else{
            image = getImage("/piece/b-pawn");
        }
    }

    public boolean canMove(int targetCol, int targerRow) {
        if(isWithinBoard(targetCol, targerRow) && isSameSquare(targetCol, targerRow) == false){

            //Difine the move value based on its color
            int moveValue;
            if(color == GamePanel.WHITE){
                moveValue = -1;
            }else{
                moveValue = 1;
            }

            //Check the hitting piece
            hittingP = getHittingP(targetCol, targerRow);

            // 1 square movement
            if(targetCol == preCol && targerRow == preRow + moveValue && hittingP == null){
                return true;
            }

            // 2 square movement
            if(targetCol == preCol && targerRow == preRow + moveValue*2 && hittingP == null && moved == false &&
                pieceIsOnStraightLine(targetCol, targerRow) == false){
                return true;
            }

            //Diagonal movement
            if(Math.abs(targetCol - preCol) == 1 && targerRow == preRow + moveValue && hittingP != null &&
                hittingP.color != color){
                return true;
            }
        }

        return false;
    }
}
