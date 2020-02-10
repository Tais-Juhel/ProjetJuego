package model.jeu;

import controler.Main;
import model.personnage.Joueur;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Scene extends JPanel {
    //VARIABLES
    private Accueil accueil = new Accueil();

    private ImageIcon icoBackG;
    private Image imgBackG;

    public Joueur joueur1;
    public Joueur joueur2;

    public ArrayList<Joueur> joueurs = new ArrayList<Joueur>();

    public boolean jeuEnCours = false;

    //CONSTRUCTEUR
    public Scene(){
        super();

        this.icoBackG = new ImageIcon(getClass().getResource("/img/background.png"));
        this.imgBackG = icoBackG.getImage();

        this.joueur1 = new Joueur(0, 330, "/img/joueur.png", 1, 100);
        this.joueur1.ajouterLaser(6);
        this.joueur2 = new Joueur(1027, 330, "/img/joueur.png", 2, 100);
        this.joueur2.ajouterLaser(2);

        this.joueurs.add(this.joueur1);
        this.joueurs.add(this.joueur2);

        //Appui clavier
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Clavier());

        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }

    //METHODES
    public void paintComponent(Graphics g){
        if(jeuEnCours == false) {
            g.drawImage(this.accueil.getImgSelect(), 100, 100, null);
            g.drawImage(this.accueil.getImgClasse(), 100, 200, null);
            g.drawImage(this.accueil.getImgInstru(), 100, 300, null);
            g.drawImage(this.accueil.getImgJouer(), 100, 400, null);
            g.drawImage(this.accueil.getImgOptions(), 100, 500, null);
        }

        if(jeuEnCours == true) {
            g.drawImage(this.imgBackG, 0, 0, null);
            for (int j = 0; j < joueurs.size(); j++) {
                g.drawImage(this.joueurs.get(j).getImgJoueur(), this.joueurs.get(j).deplacementJoueurX(), this.joueurs.get(j).deplacementJoueurY(), null);
                for (int i = 0; i < Main.scene.joueurs.get(j).getTir().size(); i++) {
                    this.joueurs.get(j).getLaser(i).dessinTirVaisseau(g);
                }

                //Test si un joueur n'as plus de vie
                if (Main.scene.joueurs.get(j).getVie() == 0) {
                    this.jeuEnCours = false;
                    System.out.println("Fin du jeu !!!");
                }
            }
        }
    }
}
