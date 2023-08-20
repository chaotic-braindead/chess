public class Pawn extends Piece{
    final static String path = "C:\\Users\\raf\\Desktop\\chess\\chess\\img\\pawn.png";
    boolean firstMove = true;

    public Pawn(boolean isWhite, String path){
        super(isWhite, path);
    }
    
    @Override
    public void setValidMoves(Board b, Square s){
        this.clearValidMoves();
        Square[][] board = b.getBoard();
        if(this.getIsWhite() && (s.getX() == 0)) return;
        if(!this.getIsWhite() && (s.getX() == 7)) return;
        
        if(this.firstMove){
            Square fMove = this.getIsWhite() ? board[s.getX() - 2][s.getY()] : board[s.getX() + 2][s.getY()];
            if(fMove.getPiece() == null)
            this.addValidMove(fMove);
        }
        Square forward = this.getIsWhite() ? board[s.getX() - 1][s.getY()] : board[s.getX() + 1][s.getY()];
        if(forward.getPiece() == null)
            this.addValidMove(forward);
        
        if(s.getY() > 0 && s.getY() < 7){
            Square diag1 = this.getIsWhite() ? board[s.getX() - 1][s.getY() - 1] : board[s.getX() + 1][s.getY() + 1];
            Square diag2 = this.getIsWhite() ? board[s.getX() - 1][s.getY() + 1] : board[s.getX() + 1][s.getY() - 1];
            if(diag1.getPiece() != null)
                this.addValidMove(diag1);
            if(diag2.getPiece() != null)
                this.addValidMove(diag2);
        }
    }
}
