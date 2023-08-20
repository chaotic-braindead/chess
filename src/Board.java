public class Board {
    private Square[][] board;
    public Board(){
        this.resetBoard();
    }

    public void print(){
        for(int i = 0; i < 8; ++i){
            System.out.println("---------------------------------");
            System.out.print("|");
            for(int j = 0; j < 8; ++j){
                if(this.board[i][j].getPiece() != null)
                    System.out.print(" " + this.board[i][j].getPiece().asString() + " |");
                else
                    System.out.print("   |");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
    }

    private void resetBoard(){
        // black
        this.board = new Square[8][8];
        this.board[0][0] = new Square(0, 0, new Rook(false));
        this.board[0][1] = new Square(0, 1, new Knight(false));
        this.board[0][2] = new Square(0, 2, new Bishop(false));
        this.board[0][3] = new Square(0, 3, new Queen(false));
        this.board[0][4] = new Square(0, 4, new King(false));
        this.board[0][5] = new Square(0, 5, new Bishop(false));
        this.board[0][6] = new Square(0, 6, new Knight(false));
        this.board[0][7] = new Square(0, 7, new Rook(false));
        
        for(int i = 0; i < 8; ++i)
            this.board[1][i] = new Square(1, i, new Pawn(false));


        //white

        for(int i = 0; i < 8; ++i)
            this.board[6][i] = new Square(6, i, new Pawn(true));

        this.board[7][0] = new Square(7, 0, new Rook(true));
        this.board[7][1] = new Square(7, 1, new Knight(false));
        this.board[7][2] = new Square(7, 2, new Bishop(false));
        this.board[7][3] = new Square(7, 3, new Queen(false));
        this.board[7][4] = new Square(7, 4, new King(false));
        this.board[7][5] = new Square(7, 5, new Bishop(false));
        this.board[7][6] = new Square(7, 6, new Knight(false));
        this.board[7][7] = new Square(7, 7, new Rook(false));

        for(int i = 2; i < 6; ++i){
            for(int j = 0; j < 8; ++j){
                this.board[i][j] = new Square(i, j, null);
            }
        }
    }

    public Square[][] getBoard(){
        return board;
    }
}
