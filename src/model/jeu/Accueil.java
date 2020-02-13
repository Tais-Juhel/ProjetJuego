package model.jeu;

import javax.swing.*;
import java.awt.*;

public class Accueil {
    private ImageIcon icoClasse;
    private Image imgClasse;

    private ImageIcon icoInstru;
    private Image imgInstru;

    private ImageIcon icoJouer;
    private Image imgJouer;

    private ImageIcon icoOptions;
    private Image imgOptions;

    //CONSTRUCTEUR
    public Accueil() {
        this.icoClasse = new ImageIcon(getClass().getResource("/img/classe.png"));
        this.imgClasse = icoClasse.getImage();

        this.icoInstru = new ImageIcon(getClass().getResource("/img/instruction.png"));
        this.imgInstru = icoInstru.getImage();

        this.icoJouer = new ImageIcon(getClass().getResource("/img/jouer.png"));
        this.imgJouer = icoJouer.getImage();

        this.icoOptions = new ImageIcon(getClass().getResource("/img/options.png"));
        this.imgOptions = icoOptions.getImage();

    }

    //GETTER
    public Image getImgClasse() {
        return imgClasse;
    }

    public Image getImgInstru() {
        return imgInstru;
    }

    public Image getImgJouer() {
        return imgJouer;
    }

    public Image getImgOptions() {
        return imgOptions;
    }

}