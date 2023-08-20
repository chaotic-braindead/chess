import java.util.List;
import javax.imageio.ImageIO;
import javax.print.attribute.standard.MediaSize.ISO;

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
            if(!isWhite) path = path.substring(0, 37) + "b" + path.substring(37);  // i know this creates new string instances but it works so... 
            BufferedImage image = ImageIO.read(new File(path));
            this.icon = new ImageIcon(image).getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);

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

    // TODO: implement moves for all pieces god help me
    public abstract void setValidMoves();
}
