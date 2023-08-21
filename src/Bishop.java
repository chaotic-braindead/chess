public class Bishop extends Piece{
    final static String path = "C:\\Users\\raf\\Desktop\\chess\\chess\\img\\bishop.png";
    public Bishop(boolean isWhite, String path){
        super(isWhite, path);
    }

    @Override
    public void setValidMoves(Board b, Square s){
        this.clearValidMoves();
        Square[][] board = b.getBoard();
        int j = s.getY() + 1;
        boolean playerColor = this.getIsWhite();
        boolean oppositeColorHit = false;
        
        for(int i = s.getX() - 1; i >= 0 && j <= 7; --i){
            if(oppositeColorHit) break;
            Square possibleMove = board[i][j];
            j++;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor) oppositeColorHit = true;
            this.addValidMove(possibleMove);
        }
        j = s.getY() - 1;
        oppositeColorHit = false;
        for(int i = s.getX() - 1; i >= 0 && j >= 0; --i){
            if(oppositeColorHit) break;
            Square possibleMove = board[i][j];
            j--;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor) oppositeColorHit = true;
            this.addValidMove(possibleMove);
        }
        j = s.getY() + 1;
        oppositeColorHit = false;
        for(int i = s.getX() + 1; i <= 7 && j <= 7; ++i){
            if(oppositeColorHit) break;
            Square possibleMove = board[i][j];
            j++;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor) oppositeColorHit = true;
            this.addValidMove(possibleMove);
        }
        j = s.getY() - 1;
        oppositeColorHit = false;
        for(int i = s.getX() + 1; i <= 7 && j >= 0; ++i){
            if(oppositeColorHit) break;
            Square possibleMove = board[i][j];
            j--;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() == playerColor) break;
            if(possibleMove.getPiece() != null && possibleMove.getPiece().getIsWhite() != playerColor) oppositeColorHit = true;
            this.addValidMove(possibleMove);
        }

        // System.out.println(possibleMove.getX() + " " + possibleMove.getY());
    }
}

