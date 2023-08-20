import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

public class ChessGUI extends JFrame implements MouseListener{
    static final int width = 800;
    static final int height = 800;
    static final int rows = (width / 8);
    static final int cols = (height / 8);
    static final int gapX = (width / rows) * 10;
    static final int gapY = (height / cols) * 10;

    Board b = new Board();
    JPanel p = new JPanel(){
        @Override
        public void paint(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            boolean isWhite = true;
            Square[][] board = b.getBoard();

            // draw board
            for(int i = 0; i < 8; ++i){
                for(int j = 0; j < 8; ++j){
                    Rectangle r = new Rectangle(i * gapX, j * gapY, gapX, gapY);
                    if(isWhite){
                        g2.setColor(new Color(118, 150, 86));
                    }
                    else{
                        g2.setColor(new Color(238, 238, 210));
                    }
                    g2.fill(r);
                    board[i][j].setRect(r);
                    isWhite = !isWhite;
                }
                isWhite = !isWhite;
            }

            // draw pieces
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(board[j][i].getPiece() != null){
                        g.drawImage(board[j][i].getPiece().getIcon(), i*gapX + 2, j*gapY + 3, this);
                    }
                }
            }
        }
    };

    public ChessGUI(){
        this.setSize(width, height); 
        this.setVisible(true);
        p.addMouseListener(this);
        this.add(p);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override 
    public void mouseClicked(MouseEvent e){
        int y = e.getX() / gapX;
        int x = e.getY() / gapY;
        if(e.getButton() == 1 && b.getBoard()[x][y].getPiece() != null){
            System.out.println("Clicked board[" + x + "][" + y + "]");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e){
        
    }
    @Override
    public void mouseEntered(MouseEvent e){

    }
    @Override
    public void mousePressed(MouseEvent e){

    }
    @Override
    public void mouseExited(MouseEvent e){

    }
}