

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
    public void setValidMoves(Board b, Square s){
        Square[][] board = b.getBoard();
        boolean playerColor = this.getIsWhite();
        int y = s.getY();
        for(int i = s.getY() - 1; i <= s.getY() + 1 && (i >= 0 && i <= 7); i++){
            if(s.getX() - 1 >= 0){
                Square possibleMove = board[s.getX() - 1][i];
                if(possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor) this.addValidMove(possibleMove);
            }
        }
        for(int i = s.getY() - 1; i <= s.getY() + 1 &&  (i >= 0 && i <= 7); i++){
            if(s.getX() + 1 <= 7){
                Square possibleMove = board[s.getX() + 1][i];
                if(possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor) this.addValidMove(possibleMove);
            }
        }
        // Square possibleMove = board[s.getX()][s.getY()-1];
        // Square possibleMove1 = board[s.getX()][s.getY()+1];
    }
}
