public class King extends Piece {
    final static String path = "C:\\Users\\raf\\Desktop\\chess\\chess\\img\\king.png";
    private boolean[] canCastle = {false, false};
    private boolean firstMove = false;
    private boolean isChecked = false;
    private Square whoChecked = null;
    
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
        if(!this.firstMove){
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
        if(this.canCastle[0]){
            System.out.println("long castle available");
            this.addValidMove(board[s.getX()][s.getY()-2]);
        }
        if(this.canCastle[1]){
            System.out.println("short castle available");
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

        // // some pieces should not be able to move if they are pinned to the king.
        // int j = s.getY() + 1;
        // boolean oppositeColorHit = false;
        // Square cantMove = null;
        // for(int i = s.getX() - 1; i >= 0 && j <= 7; --i){
        //     if(oppositeColorHit) break;
        //     Square possibleMove = board[i][j];
        //     j++;
        //     if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) {
        //         if(cantMove != null) { possibleMove.getPiece().setCanMove(true); break; }
        //         cantMove = possibleMove;
        //         continue;
        //     }
        //     if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor){
        //         oppositeColorHit = true;
        //     }
        //     if(oppositeColorHit && cantMove != null && (possibleMove.getPiece().getClass().getName() == "Bishop" || possibleMove.getPiece().getClass().getName() == "Queen"))
        //         cantMove.getPiece().setCanMove(false);
                
        // }
        // j = s.getY() - 1;
        // oppositeColorHit = false;
        // cantMove = null;
        // for(int i = s.getX() - 1; i >= 0 && j >= 0; --i){
        //     if(oppositeColorHit) break;
        //     Square possibleMove = board[i][j];
        //     j--;
        //     if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) {
        //         if(cantMove != null) { possibleMove.getPiece().setCanMove(true); break; }
        //         cantMove = possibleMove;
        //         continue;
        //     }
        //     if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor){
        //         oppositeColorHit = true;
        //     }
        //     if(oppositeColorHit && cantMove != null && (possibleMove.getPiece().getClass().getName() == "Bishop" || possibleMove.getPiece().getClass().getName() == "Queen"))
        //         cantMove.getPiece().setCanMove(false);
        // }
        // j = s.getY() + 1;
        // oppositeColorHit = false;
        // cantMove = null;
        // for(int i = s.getX() + 1; i <= 7 && j <= 7; ++i){
        //     if(oppositeColorHit) break;
        //     Square possibleMove = board[i][j];
        //     j++;
        //     if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) {
        //         if(cantMove != null) { possibleMove.getPiece().setCanMove(true); break; }
        //         cantMove = possibleMove;
        //         continue;
        //     }
        //     if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor){
        //         oppositeColorHit = true;
        //     }
        //     if(oppositeColorHit && cantMove != null && (possibleMove.getPiece().getClass().getName() == "Bishop" || possibleMove.getPiece().getClass().getName() == "Queen"))
        //         cantMove.getPiece().setCanMove(false);
        // }
        // j = s.getY() - 1;
        // oppositeColorHit = false;
        // cantMove = null;

        // for(int i = s.getX() + 1; i <= 7 && j >= 0; ++i){
        //     if(oppositeColorHit) break;
        //     Square possibleMove = board[i][j];
        //     j--;
        //     if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) {
        //         if(cantMove != null) { possibleMove.getPiece().setCanMove(true); break; }
        //         cantMove = possibleMove;
        //         continue;
        //     }
        //     if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor){
        //         oppositeColorHit = true;
        //     }
        //     if(oppositeColorHit && cantMove != null && (possibleMove.getPiece().getClass().getName() == "Bishop" || possibleMove.getPiece().getClass().getName() == "Queen"))
        //         cantMove.getPiece().setCanMove(false);
        // }

        // // HORIZONTAL
        // // right
        // oppositeColorHit = false;
        // cantMove = null;

        // for(int i = s.getY() + 1; i < 8; ++i){
        //     if(oppositeColorHit) break;
        //     Square possibleMove = board[s.getX()][i];
        //     if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) {
        //         if(cantMove != null) { cantMove.getPiece().setCanMove(true); break; }
        //         cantMove = possibleMove;
        //         continue;
        //     }
        //     if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor){
        //         oppositeColorHit = true;
        //     }
        //     if(oppositeColorHit && cantMove != null && (possibleMove.getPiece().getClass().getName() == "Rook" || possibleMove.getPiece().getClass().getName() == "Queen"))
        //         cantMove.getPiece().setCanMove(false);
        // }
        // oppositeColorHit = false;
        // cantMove = null;

        // // left 
        // for(int i = s.getY() - 1; i >= 0; --i){
        //     if(oppositeColorHit) break;
        //     Square possibleMove = board[s.getX()][i];
        //    if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) {
        //         if(cantMove != null) { cantMove.getPiece().setCanMove(true); break; }
        //         cantMove = possibleMove;
        //         continue;
        //     }
        //     if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor){
        //         oppositeColorHit = true;
        //     }
        //     if(oppositeColorHit && cantMove != null && (possibleMove.getPiece().getClass().getName() == "Rook" || possibleMove.getPiece().getClass().getName() == "Queen"))
        //         cantMove.getPiece().setCanMove(false);
        // }
        // oppositeColorHit = false;
        // cantMove = null;

        // // VERTICAL
        // // up
        // for(int i = s.getX() - 1; i >= 0; --i){
        //     if(oppositeColorHit) break;
        //     Square possibleMove = board[i][s.getY()];
        //     if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) {
        //         if(cantMove != null) { cantMove.getPiece().setCanMove(true); break; }
        //         cantMove = possibleMove;
        //         continue;
        //     }
        //     if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor){
        //         oppositeColorHit = true;
        //     }
        //     if(oppositeColorHit && cantMove != null && (possibleMove.getPiece().getClass().getName() == "Rook" || possibleMove.getPiece().getClass().getName() == "Queen"))
        //         cantMove.getPiece().setCanMove(false);
        // }
        // oppositeColorHit = false;
        // cantMove = null;

        // // down
        // for(int i = s.getX() + 1; i <= 7; ++i){
        //     if(oppositeColorHit) break;
        //     Square possibleMove = board[i][s.getY()];
        //     if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) {
        //         if(cantMove != null) { cantMove.getPiece().setCanMove(true); break; }
        //         cantMove = possibleMove;
        //         continue;
        //     }
        //     if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor){
        //         oppositeColorHit = true;
        //     }
        //     if(oppositeColorHit && cantMove != null && (possibleMove.getPiece().getClass().getName() == "Rook" || possibleMove.getPiece().getClass().getName() == "Queen"))
        //         cantMove.getPiece().setCanMove(false);
        // }
    

        // TODO: castling
    }
}
