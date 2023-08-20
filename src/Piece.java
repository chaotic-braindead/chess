import java.util.List;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.awt.Image;


public abstract class Piece {
    private boolean isWhite;
    private boolean isEaten;
    private List<Square> validMoves;
    private Image icon;

    public Piece(boolean isWhite, String path){
        this.isWhite = isWhite;
        isEaten = false;
        validMoves = new ArrayList<>();
        try{
            BufferedImage image = ImageIO.read(new File(path));
            this.icon = new ImageIcon(image).getImage();

        } catch(IOException e){
            e.printStackTrace();
        }

    }

    public boolean getIsWhite(){
        return this.isWhite;
    }

    public boolean getIsEaten(){
        return this.isEaten;
    } 

    public List<Square> getValidMoves(){
        return validMoves;
    }

    public Image getIcon(){
        return this.icon;
    }

    public void setIsWhite(boolean isWhite){
        this.isWhite = isWhite;
    }

    public void setIsEaten(boolean isEaten){
        this.isEaten = isEaten;
    }


    public abstract void setValidMoves();
}
