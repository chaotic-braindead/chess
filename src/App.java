import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class App {
    public static void main(String[] args) throws Exception {
        Test t = new Test();

    }
    public static class Test extends JFrame implements MouseListener{
        final int width = 800;
        final int height = 800;
        int rows = (width / 8);
        int cols = (height / 8);
        int gapX = (width / rows) * 10;
        int gapY = (height / cols) * 10;
        Board b = new Board();
        JPanel p = new JPanel(){
            @Override
            public void paint(Graphics g){
                Graphics2D g2 = (Graphics2D) g;
                boolean isWhite = true;
                Square[][] board = b.getBoard();
                for(int i = 0; i < 8; ++i){
                    for(int j = 0; j < 8; ++j){
                        Rectangle r = new Rectangle(i * gapX, j * gapY, gapX, gapY);
                        if(isWhite){
                            g2.setColor(Color.WHITE);
                        }
                        else{
                            g2.setColor(Color.BLACK);
                        }
                        g2.fill(r);
                        // g2.fillRect(i * gapX, j * gapY, gapX, gapY);
                        board[i][j].setSquare(r);
                        isWhite = !isWhite;
                    }
                    isWhite = !isWhite;
                }
                for(int i = 0; i < 8; i++){
                    for(int j = 0; j < 8; j++){
                        if(board[j][i].getPiece() != null){
                            g.drawImage(board[j][i].getPiece().getIcon(), i*gapX, j*gapY, this);
                        }
                    }
                }
            }
        };

        public Test(){
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
            if(e.getButton() == 1 && b.getBoard()[x][y].getRect() != null){
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
}

