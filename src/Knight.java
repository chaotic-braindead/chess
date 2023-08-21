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
                if((possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor)) this.addValidMove(possibleMove);
            }
            if(s.getY() - 1 >= 0){
                Square possibleMove = board[s.getX() - 2][s.getY() - 1];
                if((possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor)) this.addValidMove(possibleMove);

            }
        }
        if(s.getX() - 1 >= 0){
            if(s.getY() + 2 <= 7){
                Square possibleMove = board[s.getX() - 1][s.getY() + 2];
                if((possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor)) this.addValidMove(possibleMove);
            }
            if(s.getY() - 2 >= 0){
                Square possibleMove = board[s.getX() - 1][s.getY() - 2];
                if((possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor)) this.addValidMove(possibleMove);

            }
        }

        if(s.getX() + 2 <= 7){
            if(s.getY() + 1 <= 7){
                Square possibleMove = board[s.getX() + 2][s.getY() + 1];
                if((possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor)) this.addValidMove(possibleMove);
            }
            if(s.getY() - 1 >= 0){
                Square possibleMove = board[s.getX() + 2][s.getY() - 1];
                if((possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor)) this.addValidMove(possibleMove);

            }
        }
        if(s.getX() + 1 <= 7){
            if(s.getY() + 2 <= 7){
                Square possibleMove = board[s.getX() + 1][s.getY() + 2];
                if((possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor)) this.addValidMove(possibleMove);
            }
            if(s.getY() - 2 >= 0){
                Square possibleMove = board[s.getX() + 1][s.getY() - 2];
                if((possibleMove.getPiece() == null || possibleMove.getPiece().getIsWhite() != playerColor)) this.addValidMove(possibleMove);

            }
        }
    }
}
