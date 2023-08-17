public class King extends Piece {
    static final private String representation = "+";
    
    private boolean canCastle = true;

    public King(boolean isWhite){
        super(isWhite);
    }

    public boolean getCanCastle(){
        return this.canCastle;
    }

    public void setCanCastle(boolean canCastle){
        this.canCastle = canCastle;
    }

    @Override
    public String getRep(){
        return King.representation;
    }
    @Override
    public void setValidMoves(){}
}
