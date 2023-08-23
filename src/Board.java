public class Board {
    private Square[][] board;
    private King whiteKing;
    private King blackKing;

    public Board(){
        this.resetBoard();
        this.whiteKing = (King) board[7][4].getPiece();
        this.blackKing = (King) board[0][4].getPiece();
        this.generateMoves();
    }
  
    public King getKing(boolean isWhite){
        return isWhite ? this.whiteKing : this.blackKing;
    }

    private void resetBoard(){
        // black
        this.board = new Square[8][8];
        this.board[0][0] = new Square(0, 0, new Rook(false, Rook.path));
        this.board[0][1] = new Square(0, 1, new Knight(false, Knight.path));
        this.board[0][2] = new Square(0, 2, new Bishop(false, Bishop.path));
        this.board[0][3] = new Square(0, 3, new Queen(false, Queen.path));
        this.board[0][4] = new Square(0, 4, new King(false, King.path));
        this.board[0][5] = new Square(0, 5, new Bishop(false, Bishop.path));
        this.board[0][6] = new Square(0, 6, new Knight(false, Knight.path));
        this.board[0][7] = new Square(0, 7, new Rook(false, Rook.path));
        
        for(int i = 0; i < 8; ++i)
            this.board[1][i] = new Square(1, i, new Pawn(false, Pawn.path));


        //white

        for(int i = 0; i < 8; ++i)
            this.board[6][i] = new Square(6, i, new Pawn(true, Pawn.path));

        this.board[7][0] = new Square(7, 0, new Rook(true, Rook.path));
        this.board[7][1] = new Square(7, 1, new Knight(true, Knight.path));
        this.board[7][2] = new Square(7, 2, new Bishop(true, Bishop.path));
        this.board[7][3] = new Square(7, 3, new Queen(true, Queen.path));
        this.board[7][4] = new Square(7, 4, new King(true, King.path));
        this.board[7][5] = new Square(7, 5, new Bishop(true, Bishop.path));
        this.board[7][6] = new Square(7, 6, new Knight(true, Knight.path));
        this.board[7][7] = new Square(7, 7, new Rook(true, Rook.path));

        for(int i = 2; i < 6; ++i){
            for(int j = 0; j < 8; ++j){
                this.board[i][j] = new Square(i, j, null);
            }
        }
    }

    public void generateMoves(){
        for(int i = 0; i < 8; ++i){
            for(int j = 0; j < 8; ++j){
                Square s = this.board[i][j];
                Piece p = s.getPiece();
                if(p != null) {
                    p.clearValidMoves();
                    p.setValidMoves(this, s);
                    for(Square move : p.getValidMoves()){
                        King king = this.getKing(!p.getIsWhite());
                        king.illegalMoves.add(move);
                    }
                }
            }
        }
        System.out.println("Generated moves");
    }

    public Square[][] getBoard(){
        return board;
    }
}
