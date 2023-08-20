public class Bishop extends Piece{
    static final private String representation = "/";

    public Bishop(boolean isWhite){
        super(isWhite);
    }
    @Override
    public String asString(){
        return Bishop.representation;
    }
    @Override
    public void setValidMoves(){}
}
