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
        if(!this.getIsWhite() && (s.getX() + 1 == 7)) return;
        
        if(this.firstMove){
            if(this.getIsWhite())
                this.addValidMove(board[s.getX() - 2][s.getY()]);
            else
                this.addValidMove(board[s.getX() + 2][s.getY()]);
        }
        if(this.getIsWhite())
            this.addValidMove(board[s.getX() - 1][s.getY()]);
        else
            this.addValidMove(board[s.getX() + 1][s.getY()]);
    }
}
