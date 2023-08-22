import java.util.Iterator;
import java.util.List;

public class Knight extends Piece{
    final static String path = "C:\\Users\\raf\\Desktop\\chess\\chess\\img\\knight.png";
    public Knight(boolean isWhite, String path){
        super(isWhite, path);
    }
    
    // how does the horsey move
    @Override
    public void setValidMoves(Board b, Square s){
        Square[][] board = b.getBoard();
        boolean playerColor = this.getIsWhite();
        if(s.getX() - 2 >= 0){
            if(s.getY() + 1 <= 7){
                Square possibleMove = board[s.getX() - 2][s.getY() + 1];
                if((possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor)) {
                    if(possibleMove.getPiece() != null && possibleMove.getPiece().getClass().getName() == "King"){
                        King king = (King) possibleMove.getPiece();
                        king.setIsChecked(true);
                        king.setWhoChecked(s);
                    }
                    this.addValidMove(possibleMove);
                }
            }
            if(s.getY() - 1 >= 0){
                Square possibleMove = board[s.getX() - 2][s.getY() - 1];
                if((possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor)) {
                    if(possibleMove.getPiece() != null && possibleMove.getPiece().getClass().getName() == "King"){
                        King king = (King) possibleMove.getPiece();
                        king.setIsChecked(true);
                        king.setWhoChecked(s);
                    }
                    this.addValidMove(possibleMove);
                }
            }
        }
        if(s.getX() - 1 >= 0){
            if(s.getY() + 2 <= 7){
                Square possibleMove = board[s.getX() - 1][s.getY() + 2];
                if((possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor)) {
                    if(possibleMove.getPiece() != null && possibleMove.getPiece().getClass().getName() == "King"){
                        King king = (King) possibleMove.getPiece();
                        king.setIsChecked(true);
                        king.setWhoChecked(s);
                    }
                    this.addValidMove(possibleMove);
                }
            }
            if(s.getY() - 2 >= 0){
                Square possibleMove = board[s.getX() - 1][s.getY() - 2];
                if((possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor)) {
                    if(possibleMove.getPiece() != null && possibleMove.getPiece().getClass().getName() == "King"){
                        King king = (King) possibleMove.getPiece();
                        king.setIsChecked(true);
                        king.setWhoChecked(s);
                    }
                    this.addValidMove(possibleMove);
                }
            }
        }

        if(s.getX() + 2 <= 7){
            if(s.getY() + 1 <= 7){
                Square possibleMove = board[s.getX() + 2][s.getY() + 1];
                if((possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor)) {
                    if(possibleMove.getPiece() != null && possibleMove.getPiece().getClass().getName() == "King"){
                        King king = (King) possibleMove.getPiece();
                        king.setIsChecked(true);
                        king.setWhoChecked(s);
                    }
                    this.addValidMove(possibleMove);
                }
            }
            if(s.getY() - 1 >= 0){
                Square possibleMove = board[s.getX() + 2][s.getY() - 1];
                if((possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor)) {
                    if(possibleMove.getPiece() != null && possibleMove.getPiece().getClass().getName() == "King"){
                        King king = (King) possibleMove.getPiece();
                        king.setIsChecked(true);
                        king.setWhoChecked(s);
                    }
                    this.addValidMove(possibleMove);
                }
            }
        }
        if(s.getX() + 1 <= 7){
            if(s.getY() + 2 <= 7){
                Square possibleMove = board[s.getX() + 1][s.getY() + 2];
                if((possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor)) {
                    if(possibleMove.getPiece() != null && possibleMove.getPiece().getClass().getName() == "King"){
                        King king = (King) possibleMove.getPiece();
                        king.setIsChecked(true);
                        king.setWhoChecked(s);
                    }
                    this.addValidMove(possibleMove);
                }
            }
            if(s.getY() - 2 >= 0){
                Square possibleMove = board[s.getX() + 1][s.getY() - 2];
                if((possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor)) {
                    if(possibleMove.getPiece() != null && possibleMove.getPiece().getClass().getName() == "King"){
                        King king = (King) possibleMove.getPiece();
                        king.setIsChecked(true);
                        king.setWhoChecked(s);
                    }
                    this.addValidMove(possibleMove);
                }
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
