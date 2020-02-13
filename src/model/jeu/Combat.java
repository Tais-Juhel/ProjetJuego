package model.jeu;

import javax.swing.*;
import java.awt.*;

public class Combat {
    private ImageIcon ico1;
    private Image img1;

    private ImageIcon ico2;
    private Image img2;

    private ImageIcon ico3;
    private Image img3;

    private ImageIcon icoGo;
    private Image imgGo;

    private ImageIcon icoFinDePartie;
    private Image imgFinDePartie;

    //CONSTRUCTEUR
    public Combat() {
        this.ico1 = new ImageIcon(getClass().getResource("/img/1.png"));
        this.img1 = ico1.getImage();

        this.icoFinDePartie = new ImageIcon(getClass().getResource("/img/finpartie.png"));
        this.imgFinDePartie = icoFinDePartie.getImage();

        this.ico2 = new ImageIcon(getClass().getResource("/img/2.png"));
        this.img2 = ico2.getImage();

        this.ico3 = new ImageIcon(getClass().getResource("/img/3.png"));
        this.img3 = ico3.getImage();

        this.icoGo = new ImageIcon(getClass().getResource("/img/3.png"));
        this.imgGo = icoGo.getImage();

    }

    //GETTER
    public Image getImg1() {
        return img1;
    }

    public Image getImg2() {
        return img2;
    }

    public Image getImg3() {
        return img3;
    }

    public Image getImgGo() {
        return imgGo;
    }

    public Image getImgFinDePartie() {return imgFinDePartie;}

}

