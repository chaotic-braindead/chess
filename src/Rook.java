public class Rook extends Piece {
    final static String path = "C:\\Users\\raf\\Desktop\\chess\\chess\\img\\rook.png";
    public Rook(boolean isWhite, String path){
        super(isWhite, path);
    }

   
    @Override
    public void setValidMoves(Board b, Square s){
        this.clearValidMoves();
        boolean playerColor = this.getIsWhite();
        boolean oppositeColorHit = false;
        Square[][] board = b.getBoard();

        // HORIZONTAL
        // right
        for(int i = s.getY() + 1; i < 8; ++i){
            if(oppositeColorHit) break;
            Square possibleMove = board[s.getX()][i];
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor) oppositeColorHit = true;
            this.addValidMove(possibleMove);
        }
        oppositeColorHit = false;
        // left 
        for(int i = s.getY() - 1; i >= 0; --i){
            if(oppositeColorHit) break;
            Square possibleMove = board[s.getX()][i];
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor) oppositeColorHit = true;
            this.addValidMove(possibleMove);
        }
        oppositeColorHit = false;

        // VERTICAL
        // up
        for(int i = s.getX() - 1; i >= 0; --i){
            if(oppositeColorHit) break;
            Square possibleMove = board[i][s.getY()];
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor) oppositeColorHit = true;
            this.addValidMove(possibleMove);
        }
        oppositeColorHit = false;

        // down
        for(int i = s.getX() + 1; i <= 7; ++i){
            if(oppositeColorHit) break;
            Square possibleMove = board[i][s.getY()];
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor) oppositeColorHit = true;
            this.addValidMove(possibleMove);
        }
    }
}
