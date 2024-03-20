package piece;

import chess.Board;
import chess.GamePanel;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Piece {
    public BufferedImage image;
    public int x, y;
    public int col, row, preCol, preRow;
    public int color;
    public Piece hittingP;
    
    public Piece(int color, int col, int row){
        this.color = color;
        this.col = col;
        this.row = row;
        x = getX(col);
        y = getY(row);
        preCol = col;
        preRow = row;
    }
    
    //Get Image
    public BufferedImage getImage(String imagePath){
        BufferedImage image = null;
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
    
    //Get X & Y
    public int getX(int col){
        return col * Board.SQUARE_SIZE;
    }
    public int getY(int row){
        return row * Board.SQUARE_SIZE;
    }

    //Get Col & Row
    public int getCol(int x){
        return (x + Board.HALF_SQUARE_SIZE)/Board.SQUARE_SIZE;
    }
    public int getRow(int y){
        return (y + Board.HALF_SQUARE_SIZE)/Board.SQUARE_SIZE;
    }
    public int getIndex(){
        for (int index = 0; index < GamePanel.simPieces.size(); index++){
            if (GamePanel.simPieces.get(index) == this){
                return index;
            }
        }
        return 0;
    }
    //Update position of piece
    public void updatePosition(){
        x = getX(col);
        y = getY(row);
        preCol = getCol(x);
        preRow = getRow(y);
    }
    public void resetPosition(){
        col = preCol;
        row = preRow;
        x = getX(col);
        y = getY(row);
    }
    public boolean canMove(int targetCol, int targerRow){
        return false;
    }

    public boolean isWithinBoard(int targetCol, int targetRow){
        if(targetCol >= 0 && targetCol <= 7 && targetRow >= 0 && targetRow <= 7){
            return true;
        }
        return false;
    }

    public Piece getHittingP(int targerCol, int targetRow){
        for (Piece piece : GamePanel.simPieces){
            if(piece.col == targerCol && piece.row == targetRow && piece != this){
                return piece;
            }
        }
        return null;
    }

    public boolean isValidSquare(int targerCol, int targetRow){

        hittingP = getHittingP(targerCol, targetRow);

        if (hittingP == null){
            //If this square is empty
            return true;
        }else{
            //If this square is occupied
            if (hittingP.color != this.color){
                return true;
            }else{
                hittingP = null;
            }
        }
        return false;
    }
    //Draw
    public void draw(Graphics2D g2){
        g2.drawImage(image, x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE, null);
    }
}
