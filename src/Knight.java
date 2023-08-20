public class Knight extends Piece{
    static final private String representation = "7";
    public Knight(boolean isWhite){
        super(isWhite);
    }
    @Override
    public String asString(){
        return Knight.representation;
    }
    @Override
    public void setValidMoves(){}
}
