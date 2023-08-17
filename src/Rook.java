public class Rook extends Piece {
    static final private String representation = "#";
    
    public Rook(boolean isWhite){
        super(isWhite);
    }
    @Override
    public String getRep(){
        return Rook.representation;
    }
    @Override
    public void setValidMoves(){}
}
