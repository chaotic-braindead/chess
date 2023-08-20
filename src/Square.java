import java.awt.*;
import java.awt.geom.Rectangle2D;
public class Square {
    private int x;
    private int y;
    private Piece p;
    private Rectangle r;


    public Square(int x, int y, Piece p){
        this.x = x;
        this.y = y;
        this.p = p;
        
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Piece getPiece(){
        return this.p;
    }

    public Rectangle getRect(){
        return this.r;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setPiece(Piece p){
        this.p = p;
    }
    
    public void setRect(Rectangle r){
        this.r = r;
    }
}
