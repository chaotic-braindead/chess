import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class King extends Piece {
    final static String path = "C:\\Users\\raf\\Desktop\\chess\\chess\\img\\king.png";
    private boolean[] canCastle = {false, false};
    private boolean firstMove = false;
    private boolean isChecked = false;
    private Square whoChecked = null;
    List<Square> illegalMoves = new ArrayList<>();

    
    public King(boolean isWhite, String path){
        super(isWhite, path);
    }

    public boolean getCanCastle(int idx){
        return this.canCastle[idx];
    }

    public void setCanCastle(boolean canCastle, int idx){
        this.canCastle[idx] = canCastle;
    }

    public boolean getIsChecked(){
        return this.isChecked;
    }
    public void setIsChecked(boolean isChecked){
        this.isChecked = isChecked;
    }
    public Square getWhoChecked(){
        return this.whoChecked;
    }
    public void setWhoChecked(Square whoChecked){
        this.whoChecked = whoChecked;
    }
    public boolean getFirstMove(){
        return this.firstMove;
    }
    public void setFirstMove(boolean firstMove){
        this.firstMove = firstMove;
    }
    @Override
    public void setValidMoves(Board b, Square s){
        Square[][] board = b.getBoard();
        boolean playerColor = this.getIsWhite();
        boolean clear = true;
        if(!this.firstMove && !this.isChecked){
            for(int i = s.getY() - 1; i >= 0; --i){
                Square sq = board[s.getX()][i];
                if(sq.getPiece() != null && sq.getPiece().getClass().getName() != "Rook"){ clear = false; break;}            
            }
            this.canCastle[0] = clear;
            clear = true;
            for(int i = s.getY() + 1; i <= 7; ++i){
                Square sq = board[s.getX()][i];
                if(sq.getPiece() != null && sq.getPiece().getClass().getName() != "Rook"){ clear = false; break;}            
            }
            this.canCastle[1] = clear;
        }
        if(this.canCastle[0]  && !this.isChecked){
            this.addValidMove(board[s.getX()][s.getY()-2]);
        }
        if(this.canCastle[1]  && !this.isChecked){
            this.addValidMove(board[s.getX()][s.getY()+2]);
        }
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
        if(s.getY() - 1 >= 0){
            Square possibleMove = board[s.getX()][s.getY()-1];
            if(possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor) this.addValidMove(possibleMove);
        }

        if(s.getY() + 1 <= 7){
            Square possibleMove = board[s.getX()][s.getY()+1];
            if(possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor) this.addValidMove(possibleMove);
        }


        if(b.getKing(this.getIsWhite()).getIsChecked() && b.getKing(this.getIsWhite()).getWhoChecked().getPiece() != null){
            Iterator<Square> it = this.getValidMoves().iterator();
            while(it.hasNext()){
                Square i = it.next();
                if(this.illegalMoves.contains(i)) it.remove();
            }
        }
        // TODO: castling
    }
}
