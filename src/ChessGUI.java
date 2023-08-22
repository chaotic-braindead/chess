import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.util.ArrayList;


// TODO: fix this mess of what I call "code" although i'm contemplating since it kinda works

public class ChessGUI extends JFrame{
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    static final int ROWS = (WIDTH / 8);
    static final int COLS = (HEIGHT / 8);
    static final int GAPX = (WIDTH / ROWS) * 10;
    static final int GAPY = (HEIGHT / COLS) * 10;
    boolean isRunning = true;

    Game game = new Game();
    Board b = game.board;
    JPanel p = new ChessPanel();
    Square active = null;
    Square prev = null;
    boolean white = true;
    

    public ChessGUI(){
        this.setSize(WIDTH, HEIGHT); 
        this.setTitle("Chess");
        this.setVisible(true);
        p.addMouseListener(new ChessMouseListener(this));
        this.add(p);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }

    public class ChessMouseListener extends MouseAdapter{
        private ChessGUI p;
        public ChessMouseListener(ChessGUI p){
            this.p = p;
        }
        public void processMove(Square oldSpot, Square newSpot){
            Piece oldPiece = oldSpot.getPiece();
            List<Square> validMoves = oldPiece.getValidMoves();
            if(oldPiece.getClass().getName() == "Pawn"){
                Pawn pawn = (Pawn) oldPiece;
                pawn.firstMove = false;
            } 
            else if(oldPiece.getClass().getName() == "King"){
                King king = (King) oldPiece;
                if((king.getCanCastle(0) || king.getCanCastle(1)) && !king.getFirstMove()) {
                    if(oldSpot.getY() + 2 == newSpot.getY()){
                        Square rookSquare = b.getBoard()[newSpot.getX()][newSpot.getY() + 1];
                        Rook rook = (Rook) rookSquare.getPiece();
                        rookSquare.setPiece(null);
                        newSpot.setPiece(oldPiece);
                        b.getBoard()[newSpot.getX()][newSpot.getY()-1].setPiece(rook);
                    }
                    else if(oldSpot.getY() - 2 == newSpot.getY()){
                        Square rookSquare = b.getBoard()[newSpot.getX()][newSpot.getY() - 2];
                        Rook rook = (Rook) rookSquare.getPiece();
                        rookSquare.setPiece(null);
                        Square newRook = b.getBoard()[newSpot.getX()][newSpot.getY() + 1];
                        newSpot.setPiece(oldPiece);
                        newRook.setPiece(rook);
                    }
                }
                king.setCanCastle(false, 0);
                king.setCanCastle(false, 1);
                king.setFirstMove(true);
            }
            validMoves.get(validMoves.indexOf(newSpot)).setPiece(oldPiece);
            b.getBoard()[oldSpot.getX()][oldSpot.getY()].setPiece(null);

            oldSpot.setIsActive(false);
            for(Square s : oldPiece.getValidMoves())
                s.setIsActive(false);

            if(b.getKing(oldPiece.getIsWhite()).getIsChecked()) b.getKing(oldPiece.getIsWhite()).setIsChecked(false);
            b.generateMoves();
        }
      
        @Override 
        public void mouseClicked(MouseEvent e){
            if(e.getButton() != 1) return; 
            int y = e.getX() / GAPX;
            int x = e.getY() / GAPY;

            // if the coordinate is out of bounds, return
            if(!(x >= 0 && x <= 7) && !(y >=0 && y <= 7)) return;
            if(b.getKing(this.p.white).getIsChecked()){
                b.generateMoves();
            }
            // move a piece
            if(this.p.active != null && this.p.active.getPiece() != null && b.getBoard()[x][y].getIsActive()){
                this.processMove(this.p.active, b.getBoard()[x][y]);
                this.p.white = !this.p.white;
                this.p.repaint();
                return;
            }


            // if there was an active piece before this method call, transfer it to prev
            if(this.p.active != null) this.p.prev = this.p.active; 

            this.p.active = b.getBoard()[x][y];
            Piece piece = this.p.active.getPiece();
            

            // TODO: remove upon completion
            // String w = piece.getIsWhite() ? "white" : "black";
            // System.out.printf("Clicked board[%d][%d] || Piece type = %s %s\n", x, y, w, piece.getClass().getName());
            
            // Iterator<Square> it = piece.getValidMoves().iterator();
            // while(it.hasNext()){
            //     Square i = it.next();
            //     if(i.getPiece() != null && !i.getPiece().getCanMove())
            //         it.remove();
            // }
            

            if(piece != null){
                this.p.active.setIsActive(true);
                for(Square s : piece.getValidMoves()){
                    if(piece.getIsWhite() != white || !piece.getCanMove()) continue;
                    s.setIsActive(true);
                }
            }
            // stores common elements from active and previous elements
            List<Square> retain = null;
            if(this.p.active.getPiece() != null)
                retain = new ArrayList<>(this.p.active.getPiece().getValidMoves());

            if(this.p.prev != null && this.p.prev.getPiece() != null && retain != null)
                retain.retainAll(this.p.prev.getPiece().getValidMoves());

            // remove highlight if not active anymore
            if(this.p.prev != null && this.p.prev.getPiece() != null){
                this.p.prev.setIsActive(false);
                for(Square s : this.p.prev.getPiece().getValidMoves()){
                    if(retain != null && retain.contains(s)) continue; // skip if the square should still be active
                    s.setIsActive(false);
                }
            }

            this.p.repaint();
        }
    }

    public class ChessPanel extends JPanel {
        Square[][] board = b.getBoard();

        @Override
        public void paint(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            boolean isWhite = false;
            Square[][] board = b.getBoard();

            // draw board
            for(int i = 0; i < 8; ++i){
                for(int j = 0; j < 8; ++j){
                    Rectangle r = new Rectangle(i * GAPX, j * GAPY, GAPX, GAPY);
                    if(board[j][i].getPiece() != null && board[j][i].getPiece().getClass().getName() == "King"){
                        King king = (King) board[j][i].getPiece();
                        if(king.getIsChecked()){
                            g2.setColor(new Color(255, 0, 0));
                            g2.fill(r);
                            board[i][j].setRect(r);
                            isWhite = !isWhite;
                            continue;
                        }
                    }
                    if(isWhite && !board[j][i].getIsActive())
                        g2.setColor(new Color(118, 150, 86));
                    else if(!isWhite && !board[j][i].getIsActive())
                        g2.setColor(new Color(238, 238, 210));
                    else
                        g2.setColor(new Color(255, 0, 0));
                    g2.fill(r);
                    board[i][j].setRect(r);
                    isWhite = !isWhite;
                }
                isWhite = !isWhite;
            }

            // draw pieces
            for(int i = 0; i < 8; ++i){
                for(int j = 0; j < 8; ++j){
                    if(board[j][i].getPiece() != null){
                        g.drawImage(board[j][i].getPiece().getIcon(), i*GAPX + 2, j*GAPY + 3, this);
                    }
                }
            }
        }
    }
}