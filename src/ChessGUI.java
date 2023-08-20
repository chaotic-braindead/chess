import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Color;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class ChessGUI extends JFrame implements WindowListener{
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

    public ChessGUI(){
        this.setSize(WIDTH, HEIGHT); 
        this.setVisible(true);
        p.addMouseListener(new ChessMouseListener());
        this.add(p);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }

    @Override
    public void windowActivated(WindowEvent e){}
    @Override
    public void windowClosing(WindowEvent e){}
    @Override
    public void windowIconified(WindowEvent e){}
    @Override
    public void windowOpened(WindowEvent e){}
    @Override
    public void windowClosed(WindowEvent e){ this.isRunning = false; }
    @Override
    public void windowDeiconified(WindowEvent e){}
    @Override
    public void windowDeactivated(WindowEvent e){}

    public class ChessMouseListener extends MouseAdapter{
        @Override 
        public void mouseClicked(MouseEvent e){
            int y = e.getX() / GAPX;
            int x = e.getY() / GAPY;
            if((x >= 0 && x <= 7) && (y >=0 && y <= 7)){
                Piece p = b.getBoard()[x][y].getPiece();
                if(e.getButton() == 1 && p != null){
                    String w = p.getIsWhite() ? "white" : "black";
                    System.out.printf("Clicked board[%d][%d] || Piece type = %s %s\n", x, y, w, p.getClass().getName());
                    System.out.println("Available moves:");
                    
                    // this piece of code moves the piece. TODO: implement highlight and click movement.
                    p.getValidMoves().get(0).setPiece(p);
                    b.getBoard()[x][y].setPiece(null);
                    if(p.getClass().getName() == "Pawn"){
                        Pawn pawn = (Pawn) p;
                        pawn.firstMove = false;
                    }
                    b.generateMoves();
                    for(Square s : p.getValidMoves()){
                        System.out.printf("%d %d\n", s.getX(), s.getY());
                    }
                }
            }
        }
    }

    public class ChessPanel extends JPanel {
        Square[][] board = b.getBoard();

        @Override
        public void paint(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            boolean isWhite = true;
            Square[][] board = b.getBoard();

            // draw board
            for(int i = 0; i < 8; ++i){
                for(int j = 0; j < 8; ++j){
                    Rectangle r = new Rectangle(i * GAPX, j * GAPY, GAPX, GAPY);
                    if(isWhite)
                        g2.setColor(new Color(118, 150, 86));
                    else
                        g2.setColor(new Color(238, 238, 210));
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