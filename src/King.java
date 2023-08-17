public class King extends Piece {
    static final private String representation = "+";
    public King(boolean isWhite){
        super(isWhite);
    }
    @Override
    public String getRep(){
        return King.representation;
    }
    @Override
    public void setValidMoves(){}
}
