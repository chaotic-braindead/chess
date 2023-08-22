import java.util.Iterator;
import java.util.List;

public class Queen extends Piece{
    final static String path = "C:\\Users\\raf\\Desktop\\chess\\chess\\img\\queen.png";

    public Queen(boolean isWhite, String path){
        super(isWhite, path);
    }
    // literally just copied bishop and rook
    @Override
    public void setValidMoves(Board b, Square s){
        Square[][] board = b.getBoard();
        int j = s.getY() + 1;
        boolean playerColor = this.getIsWhite();
        boolean oppositeColorHit = false;

        for(int i = s.getX() - 1; i >= 0 && j <= 7; --i){
            if(oppositeColorHit) break;
            Square possibleMove = board[i][j];
            j++;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor) {
                if(possibleMove.getPiece().getClass().getName() == "King"){
                    King king = (King) possibleMove.getPiece();
                    king.setIsChecked(true);
                    king.setWhoChecked(s);
                }
                oppositeColorHit = true;
            }
            this.addValidMove(possibleMove);
        }
        j = s.getY() - 1;
        oppositeColorHit = false;
        for(int i = s.getX() - 1; i >= 0 && j >= 0; --i){
            if(oppositeColorHit) break;
            Square possibleMove = board[i][j];
            j--;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor) {
                if(possibleMove.getPiece().getClass().getName() == "King"){
                    King king = (King) possibleMove.getPiece();
                    king.setIsChecked(true);
                    king.setWhoChecked(s);
                }
                oppositeColorHit = true;
            }
            this.addValidMove(possibleMove);
        }
        j = s.getY() + 1;
        oppositeColorHit = false;
        for(int i = s.getX() + 1; i <= 7 && j <= 7; ++i){
            if(oppositeColorHit) break;
            Square possibleMove = board[i][j];
            j++;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor) {
                if(possibleMove.getPiece().getClass().getName() == "King"){
                    King king = (King) possibleMove.getPiece();
                    king.setIsChecked(true);
                    king.setWhoChecked(s);
                }
                oppositeColorHit = true;
            }
            this.addValidMove(possibleMove);
        }
        j = s.getY() - 1;
        oppositeColorHit = false;
        for(int i = s.getX() + 1; i <= 7 && j >= 0; ++i){
            if(oppositeColorHit) break;
            Square possibleMove = board[i][j];
            j--;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor) {
                if(possibleMove.getPiece().getClass().getName() == "King"){
                    King king = (King) possibleMove.getPiece();
                    king.setIsChecked(true);
                    king.setWhoChecked(s);
                }
                oppositeColorHit = true;
            }
            this.addValidMove(possibleMove);
        }

        oppositeColorHit = false;
         // HORIZONTAL
        // right
        for(int i = s.getY() + 1; i < 8; ++i){
            if(oppositeColorHit) break;
            Square possibleMove = board[s.getX()][i];
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor){
                if(possibleMove.getPiece().getClass().getName() == "King") {
                    King king = (King) possibleMove.getPiece();
                    king.setIsChecked(true);
                    king.setWhoChecked(s);
                }
                oppositeColorHit = true;
            }
            this.addValidMove(possibleMove);
        }
        oppositeColorHit = false;
        // left 
        for(int i = s.getY() - 1; i >= 0; --i){
            if(oppositeColorHit) break;
            Square possibleMove = board[s.getX()][i];
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor){
                if(possibleMove.getPiece().getClass().getName() == "King") {
                    King king = (King) possibleMove.getPiece();
                    king.setIsChecked(true);
                    king.setWhoChecked(s);
                }
                oppositeColorHit = true;
            }
            this.addValidMove(possibleMove);
        }
        oppositeColorHit = false;

        // VERTICAL
        // up
        for(int i = s.getX() - 1; i >= 0; --i){
            if(oppositeColorHit) break;
            Square possibleMove = board[i][s.getY()];
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor){
                if(possibleMove.getPiece().getClass().getName() == "King") {
                    King king = (King) possibleMove.getPiece();
                    king.setIsChecked(true);
                    king.setWhoChecked(s);
                }
                oppositeColorHit = true;
            }
            this.addValidMove(possibleMove);
        }
        oppositeColorHit = false;

        // down
        for(int i = s.getX() + 1; i <= 7; ++i){
            if(oppositeColorHit) break;
            Square possibleMove = board[i][s.getY()];
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor){
                if(possibleMove.getPiece().getClass().getName() == "King") {
                    King king = (King) possibleMove.getPiece();
                    king.setIsChecked(true);
                    king.setWhoChecked(s);
                }
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
