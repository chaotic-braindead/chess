public class Queen extends Piece{
    static final private String representation = "*";

    public Queen(boolean isWhite){
        super(isWhite);
    }
    @Override
    public String asString(){
        return Queen.representation;
    }
    @Override
    public void setValidMoves(){}
}
