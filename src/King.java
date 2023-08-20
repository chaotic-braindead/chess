public class King extends Piece {
    final static String path = "C:\\Users\\raf\\Desktop\\chess\\chess\\img\\king.png";

    private boolean canCastle = true;

    public King(boolean isWhite, String path){
        super(isWhite, path);
    }

    public boolean getCanCastle(){
        return this.canCastle;
    }

    public void setCanCastle(boolean canCastle){
        this.canCastle = canCastle;
    }

    @Override
    public void setValidMoves(Board b, Square s){}
}
