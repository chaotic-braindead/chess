import java.util.Iterator;
import java.util.List;

public class Bishop extends Piece{
    final static String path = "C:\\Users\\raf\\Desktop\\chess\\chess\\img\\bishop.png";
    public Bishop(boolean isWhite, String path){
        super(isWhite, path);
    }

    // god this is depressing and abhorrent i should fix this when i'm in a better state of mind
    @Override
    public void setValidMoves(Board b, Square s){
        Square[][] board = b.getBoard();
        int j = s.getY() + 1;
        boolean playerColor = this.getIsWhite();
        boolean oppositeColorHit = false;
        Square pinned = this.getPinned();
        if(this.getPinnedBy() != null && this.getPinnedBy().getPiece() == this){
            this.setPinnedBy(null);
            this.setCanMove(true);
        }
        for(int i = s.getX() - 1; i >= 0 && j <= 7; --i){
            Square possibleMove = board[i][j];
            j++;
            if(oppositeColorHit){
                if(possibleMove.getPiece() == null) continue;
                if(possibleMove.getPiece().getClass().getName() == "King"){
                    pinned.getPiece().setCanMove(false);
                    break;
                }
                else {
                    possibleMove.getPiece().setCanMove(true);
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
        j = s.getY() - 1;
        oppositeColorHit = false;
        for(int i = s.getX() - 1; i >= 0 && j >= 0; --i){
            Square possibleMove = board[i][j];
            j--;
            if(oppositeColorHit){
                if(possibleMove.getPiece() == null) continue;
                if(possibleMove.getPiece().getClass().getName() == "King"){
                    pinned.getPiece().setCanMove(false);
                    break;
                }
                else {
                    possibleMove.getPiece().setCanMove(true);
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
        j = s.getY() + 1;
        oppositeColorHit = false;
        for(int i = s.getX() + 1; i <= 7 && j <= 7; ++i){
            Square possibleMove = board[i][j];
            j++;
            if(oppositeColorHit){
                if(possibleMove.getPiece() == null) continue;
                if(possibleMove.getPiece().getClass().getName() == "King"){
                    pinned.getPiece().setCanMove(false);
                    break;
                }
                else {
                    possibleMove.getPiece().setCanMove(true);
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
        j = s.getY() - 1;
        oppositeColorHit = false;
        for(int i = s.getX() + 1; i <= 7 && j >= 0; ++i){
            Square possibleMove = board[i][j];
            j--;
            if(oppositeColorHit){
                if(possibleMove.getPiece() == null) continue;
                if(possibleMove.getPiece().getClass().getName() == "King"){
                    pinned.getPiece().setCanMove(false);
                    break;
                }
                else {
                    possibleMove.getPiece().setCanMove(true);
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

