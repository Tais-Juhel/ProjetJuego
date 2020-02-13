package model.jeu;

import controler.Main;
import model.objets.Select;
import model.personnage.Joueur;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Scene extends JPanel {
    //VARIABLES
    public Accueil accueil = new Accueil();
    public Combat combat = new Combat();

    private ImageIcon icoBackG;
    private Image imgBackG;

    public Joueur joueur1;
    public Joueur joueur2;

    public ArrayList<Joueur> joueurs = new ArrayList<Joueur>();

    public int screen;

    public Select select = new Select();

    //CONSTRUCTEUR
    public Scene(){
        super();

        this.icoBackG = new ImageIcon(getClass().getResource("/img/background.png"));
        this.imgBackG = icoBackG.getImage();

        this.joueur1 = new Joueur(50, 330, "/img/joueur.png", 1, 100);
        this.joueur1.ajouterLaser(6);
        this.joueur2 = new Joueur(988, 330, "/img/joueur.png", 2, 100);
        this.joueur2.ajouterLaser(2);

        this.joueurs.add(this.joueur1);
        this.joueurs.add(this.joueur2);

        //Appui clavier
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Clavier());

        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();


        this.screen = 0;
    }

    //METHODES
    public void paintComponent(Graphics g){
        g.drawImage(this.imgBackG, 0, 0, null);
        if(screen == 0) {
            g.drawImage(this.select.getImgSelect(), this.select.getxPos(), this.select.getyPos(), null);
            g.drawImage(this.accueil.getImgJouer(), 150, 200, null);
            g.drawImage(this.accueil.getImgClasse(), 150, 300, null);
            g.drawImage(this.accueil.getImgInstru(), 150, 400, null);
            g.drawImage(this.accueil.getImgOptions(), 150, 500, null);
        }

        else if(screen == 1){
            //Decompte avant partie
            if(this.combat.getTime() != 150){
                this.combat.setTime(Main.scene.combat.getTime()+1);
                System.out.println("Yo");
            }
            else if(this.combat.getTime() == 150){
                this.combat.setTime(0);
                this.combat.setDecompte(this.combat.getDecompte()-1);
                System.out.println("Yo");
            }


            switch(this.combat.getDecompte()) {
                case 3:
                    g.drawImage(this.combat.getImg3(), 500, 300, null);
                    break;
                case 2:
                    g.drawImage(this.combat.getImg2(), 500, 300, null);
                    break;
                case 1:
                    g.drawImage(this.combat.getImg1(), 500, 300, null);
                    break;
                case 0:
                    g.drawImage(this.combat.getImgGo(), 450, 300, null);
                    break;
                default:
                    this.screen = 2;
                    this.combat.setDecompte(3);
                    break;
            }
        }

        else if(screen == 2) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g.drawString("PV J1 :", 65, 35);
            g.drawString(Main.scene.joueur1.getVie()+"", 170, 35);
            g.drawString(": PV J2", 920, 35);
            g.drawString(Main.scene.joueur2.getVie()+"", 860, 35);

            for (int j = 0; j < joueurs.size(); j++) {
                g.drawImage(this.joueurs.get(j).getImgJoueur(), this.joueurs.get(j).deplacementJoueurX(), this.joueurs.get(j).deplacementJoueurY(), null);
                for (int i = 0; i < Main.scene.joueurs.get(j).getTir().size(); i++) {
                    this.joueurs.get(j).getLaser(i).dessinTirVaisseau(g);
                }
                System.out.println(Main.scene.joueur1.getX());
                System.out.println(Main.scene.joueur1.getY());

                //Test si un joueur n'as plus de vie
                if (Main.scene.joueurs.get(j).getVie() == 0) {
                    this.screen = 3;
                    Main.scene.joueurs.get(1).setVie(100);
                    Main.scene.joueurs.get(0).setVie(100);
                    System.out.println("Fin du jeu !!!");
                }
            }
        }

        else if(screen == 3){
            g.drawImage(this.combat.getImgFinDePartie(), 260, 300, null);
            g.drawImage(this.combat.getImgContinuer(), 260, 350, null);
            if(this.combat.getTime() == 300){
                this.combat.setTime(0);
            }else if (this.combat.getTime() >= 150){
                this.combat.setTime(this.combat.getTime()+1);
            }else if(this.combat.getTime() < 150) {
                g.drawImage(this.select.getImgSelect(), 330, 385, null);
                this.combat.setTime(this.combat.getTime()+1);
            }
        }
    }
}
