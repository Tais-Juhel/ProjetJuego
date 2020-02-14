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

    private ImageIcon icoContinuer;
    private Image imgContinuer;

    private ImageIcon icoTrophee;
    private Image imgTrophee;

    private ImageIcon icoJ1;
    private Image imgJ1;

    private ImageIcon icoJ2;
    private Image imgJ2;

    private int decompte;
    private int time;

    public int win;

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

        this.icoGo = new ImageIcon(getClass().getResource("/img/go.png"));
        this.imgGo = icoGo.getImage();

        this.icoContinuer = new ImageIcon(getClass().getResource("/img/continuer.png"));
        this.imgContinuer = icoContinuer.getImage();

        this.icoTrophee = new ImageIcon(getClass().getResource("/img/trophee.png"));
        this.imgTrophee = icoTrophee.getImage();

        this.icoJ1 = new ImageIcon(getClass().getResource("/img/j1.png"));
        this.imgJ1 = icoJ1.getImage();

        this.icoJ2 = new ImageIcon(getClass().getResource("/img/j2.png"));
        this.imgJ2 = icoJ2.getImage();

        this.decompte = 3;
        this.time = 0;
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

    public Image getImgContinuer() {
        return imgContinuer;
    }

    public Image getImgTrophee() {
        return imgTrophee;
    }

    public Image getImgJ1() {
        return imgJ1;
    }

    public Image getImgJ2() {
        return imgJ2;
    }

    public int getDecompte() {
        return decompte;
    }

    public int getTime() {
        return time;
    }

    //SETTER

    public void setDecompte(int decompte) {
        this.decompte = decompte;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

