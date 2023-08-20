public class Pawn extends Piece{
    static final private String representation = "i";
    public Pawn(boolean isWhite){
        super(isWhite);
    }

    @Override
    public String asString(){
        return Pawn.representation;
    }

    @Override
    public void setValidMoves(){
        
    }
}
