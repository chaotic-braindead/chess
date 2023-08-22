import java.util.Iterator;
import java.util.List;

public class Rook extends Piece {
    final static String path = "C:\\Users\\raf\\Desktop\\chess\\chess\\img\\rook.png";
    public Rook(boolean isWhite, String path){
        super(isWhite, path);
    }

   
    @Override
    public void setValidMoves(Board b, Square s){
        boolean playerColor = this.getIsWhite();
        boolean oppositeColorHit = false;
        Square[][] board = b.getBoard();
        Square pinned = null;
        // HORIZONTAL
        // right
        for(int i = s.getY() + 1; i < 8; ++i){
            Square possibleMove = board[s.getX()][i];
            if(oppositeColorHit){
                if(possibleMove.getPiece() == null) continue;
                if(possibleMove.getPiece().getClass().getName() == "King"){
                    pinned.getPiece().setCanMove(false);
                    break;
                }
                else {
                    pinned.getPiece().setCanMove(true);
                    break;
                }
            } 
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor) {
                if(possibleMove.getPiece().getClass().getName() == "King"){
                    King king = (King) possibleMove.getPiece();
                    king.setIsChecked(true);
                    king.setWhoChecked(s);
                    break;
                }
                pinned = possibleMove;
                oppositeColorHit = true;
            }
            this.addValidMove(possibleMove);
        }
        oppositeColorHit = false;
        // left 
        for(int i = s.getY() - 1; i >= 0; --i){
            Square possibleMove = board[s.getX()][i];
            if(oppositeColorHit){
                if(possibleMove.getPiece() == null) continue;
                if(possibleMove.getPiece().getClass().getName() == "King"){
                    pinned.getPiece().setCanMove(false);
                    break;
                }
                else {
                    pinned.getPiece().setCanMove(true);
                    break;
                }
            } 
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor) {
                if(possibleMove.getPiece().getClass().getName() == "King"){
                    King king = (King) possibleMove.getPiece();
                    king.setIsChecked(true);
                    king.setWhoChecked(s);
                    break;
                }
                pinned = possibleMove;
                oppositeColorHit = true;
            }
            this.addValidMove(possibleMove);
        }
        oppositeColorHit = false;

        // VERTICAL
        // up
        for(int i = s.getX() - 1; i >= 0; --i){
            Square possibleMove = board[i][s.getY()];
            if(oppositeColorHit){
                if(possibleMove.getPiece() == null) continue;
                if(possibleMove.getPiece().getClass().getName() == "King"){
                    pinned.getPiece().setCanMove(false);
                    break;
                }
                else {
                    pinned.getPiece().setCanMove(true);
                    break;
                }
            } 
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor) {
                if(possibleMove.getPiece().getClass().getName() == "King"){
                    King king = (King) possibleMove.getPiece();
                    king.setIsChecked(true);
                    king.setWhoChecked(s);
                    break;
                }
                pinned = possibleMove;
                oppositeColorHit = true;
            }
            this.addValidMove(possibleMove);
        }
        oppositeColorHit = false;

        // down
        for(int i = s.getX() + 1; i <= 7; ++i){
           Square possibleMove = board[i][s.getY()];
            if(oppositeColorHit){
                if(possibleMove.getPiece() == null) continue;
                if(possibleMove.getPiece().getClass().getName() == "King"){
                    pinned.getPiece().setCanMove(false);
                    break;
                }
                else {
                    pinned.getPiece().setCanMove(true);
                    break;
                }
            } 
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor) {
                if(possibleMove.getPiece().getClass().getName() == "King"){
                    King king = (King) possibleMove.getPiece();
                    king.setIsChecked(true);
                    king.setWhoChecked(s);
                    break;
                }
                pinned = possibleMove;
                oppositeColorHit = true;
            }
            this.addValidMove(possibleMove);
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
