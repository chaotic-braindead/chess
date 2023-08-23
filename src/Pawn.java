import java.util.Iterator;
import java.util.List;
public class Pawn extends Piece{
    final static String path = "C:\\Users\\raf\\Desktop\\chess\\chess\\img\\pawn.png";
    boolean firstMove = true;

    public Pawn(boolean isWhite, String path){
        super(isWhite, path);
    }


    
    @Override
    public void setValidMoves(Board b, Square s){
        Square[][] board = b.getBoard();
        if(this.getIsWhite() && (s.getX() == 0)) return;
        if(!this.getIsWhite() && (s.getX() == 7)) return;
        
        if(this.getPinnedBy() != null && this.getPinnedBy().getPiece() == this){
            this.setPinnedBy(null);
            this.setCanMove(true);
        }
        Square forward = this.getIsWhite() ? board[s.getX() - 1][s.getY()] : board[s.getX() + 1][s.getY()];
        if(forward.getPiece() == null){
            this.addValidMove(forward);
        }
        if(this.firstMove && forward.getPiece() == null){
            Square fMove = this.getIsWhite() ? board[s.getX() - 2][s.getY()] : board[s.getX() + 2][s.getY()];
            if(fMove.getPiece() == null)
            this.addValidMove(fMove);
        }
        if(this.getIsWhite()){
            if(s.getY() > 0){
                Square diag = board[s.getX() - 1][s.getY() - 1];
                if(diag.getPiece() != null && !diag.getPiece().getIsWhite()){
                    if(diag.getPiece().getClass().getName() == "King"){
                        King king = (King) diag.getPiece();
                        king.setIsChecked(true);
                        king.setWhoChecked(s);
                    }
                    this.addValidMove(diag);
                }
            }
            if(s.getY() < 7){
                Square diag = board[s.getX() - 1][s.getY() + 1];
                if(diag.getPiece() != null && !diag.getPiece().getIsWhite()){
                    if(diag.getPiece().getClass().getName() == "King"){
                        King king = (King) diag.getPiece();
                        king.setIsChecked(true);
                        king.setWhoChecked(s);
                    }
                    this.addValidMove(diag);
                }
            }
        }
        else{
            if(s.getY() > 0){
                Square diag = board[s.getX() + 1][s.getY() - 1];
                if(diag.getPiece() != null && diag.getPiece().getIsWhite()){
                    if(diag.getPiece().getClass().getName() == "King"){
                        King king = (King) diag.getPiece();
                        king.setIsChecked(true);
                        king.setWhoChecked(s);
                    }
                    this.addValidMove(diag);
                }
            }
            if(s.getY() < 7){
                Square diag = board[s.getX() + 1][s.getY() + 1];
                if(diag.getPiece() != null && diag.getPiece().getIsWhite()){
                    if(diag.getPiece().getClass().getName() == "King"){
                        King king = (King) diag.getPiece();
                        king.setIsChecked(true);
                        king.setWhoChecked(s);
                    }
                    this.addValidMove(diag);
                }
            }
        }   
            // TODO: en passant (holy hell)
            // Square left = this.getIsWhite() ? board[s.getX()][s.getY() - 1] : board[s.getX()][s.getY() + 1];
            // Square right = this.getIsWhite() ? board[s.getX()][s.getY() + 1] : board[s.getX()][s.getY() - 1];
            // if(left.getPiece() != null && left.getPiece().getClass().getName() == "Pawn")
           
        // if(!this.getIsWhite())
        //     System.out.println(this + " " + b.getKing(this.getIsWhite()).getIsChecked());
        if(!this.getCanMove()){
            Iterator<Square> it = this.getValidMoves().iterator();
            while(it.hasNext()){
                Square i = it.next();
                if(i != this.getPinnedBy())
                    it.remove();
            }
        }
        if(b.getKing(this.getIsWhite()).getIsChecked() && b.getKing(this.getIsWhite()).getWhoChecked().getPiece() != null){
            Iterator<Square> it = this.getValidMoves().iterator();
            while(it.hasNext()){
                Square i = it.next();
                Square whoChecked = b.getKing(this.getIsWhite()).getWhoChecked();
                List<Square> moves = whoChecked.getPiece().getValidMoves();
                if(i != whoChecked && !moves.contains(i))
                    it.remove();
            }
        }   
    }
}
