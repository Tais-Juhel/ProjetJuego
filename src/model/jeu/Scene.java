package model.jeu;

import controler.Main;
import model.personnage.Joueur;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Scene extends JPanel {
    //VARIABLES
    private ImageIcon icoBackG;
    private Image imgBackG;

    public Joueur joueur1;
    public Joueur joueur2;

    //CONSTRUCTEUR
    public Scene(){
        super();

        this.icoBackG = new ImageIcon(getClass().getResource("/img/background.png"));
        this.imgBackG = icoBackG.getImage();

        this.joueur1 = new Joueur(0, 0, "/img/joueur.png");
        this.joueur1.ajouterLaser(6);
        this.joueur2 = new Joueur(0, 0, "/img/joueur.png");
        this.joueur2.ajouterLaser(2);

        //Appui clavier
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Clavier());

        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }

    //METHODES
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;


        g.drawImage(this.imgBackG, 0, 0, null);
        g.drawImage(this.joueur1.getImgJoueur(), this.joueur1.deplacementJoueurX(), this.joueur1.deplacementJoueurY(), null);
        for(int i = 0; i< Main.scene.joueur1.getTir().size(); i++) {
            this.joueur1.getLaser(i).dessinTirVaisseau(g);
        }
    }
}
