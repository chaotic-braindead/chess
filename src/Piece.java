import java.util.List;
import java.util.ArrayList;

public abstract class Piece {
    private boolean isWhite;
    private boolean isEaten;
    private List<Square> validMoves;

    public Piece(boolean isWhite){
        this.isWhite = isWhite;
        isEaten = false;
        validMoves = new ArrayList<>();
    }

    public boolean getIsWhite(){
        return this.isWhite;
    }

    public boolean getIsEaten(){
        return this.isEaten;
    } 

    public List<Square> getValidMoves(){
        return validMoves;
    }

    public void setIsWhite(boolean isWhite){
        this.isWhite = isWhite;
    }

    public void setIsEaten(boolean isEaten){
        this.isEaten = isEaten;
    }

    public abstract void setValidMoves();
    public abstract String asString();

}
