package model.objets;

import javax.swing.*;
import java.awt.*;

public class Select {
    private int yPos;
    private int xPos;
    private int numPos;
    private ImageIcon icoSelect;
    private Image imgSelect;

    public Select() {
        this.yPos = 200;
        this.xPos = 50;
        this.numPos = 1;
        this.icoSelect = new ImageIcon(getClass().getResource("/img/arrow2_e.png"));
        this.imgSelect = icoSelect.getImage();
    }

    //GETTER

    public int getyPos() {
        return yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public int getNumPos() {
        return numPos;
    }

    public Image getImgSelect() {
        return imgSelect;
    }

    //SETTER

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void setNumPos(int numPos) {
        this.numPos = numPos;
    }
}
