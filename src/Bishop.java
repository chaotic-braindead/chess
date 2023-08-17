public class Bishop extends Piece{
    static final private String representation = "/";
    
    public Bishop(boolean isWhite){
        super(isWhite);
    }
    @Override
    public String getRep(){
        return Bishop.representation;
    }
    @Override
    public void setValidMoves(){}
}
