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

    private ImageIcon icoBackGInst;
    private Image imgBackGInst;

    private ImageIcon icoTitle;
    private Image imgTitle;

    public Joueur joueur1;
    public Joueur joueur2;

    public ArrayList<Joueur> joueurs = new ArrayList<Joueur>();

    public int screen;

    public Select select = new Select();
    public int etat = 0;

    //CONSTRUCTEUR
    public Scene(){
        super();

        this.icoBackG = new ImageIcon(getClass().getResource("/img/background.png"));
        this.imgBackG = icoBackG.getImage();

        this.icoBackGInst = new ImageIcon(getClass().getResource("/img/BGInst.png"));
        this.imgBackGInst = icoBackGInst.getImage();

        this.icoTitle = new ImageIcon(getClass().getResource("/img/title.png"));
        this.imgTitle = icoTitle.getImage();

        this.joueur1 = new Joueur(50, 330, "/img/joueur1.png", 1, 100);
        this.joueur1.ajouterLaser(6);
        this.joueur2 = new Joueur(988, 330, "/img/joueur2.png", 2, 100);
        this.joueur2.ajouterLaser(6);

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
            g.drawImage(this.imgTitle, 300, 100, null);
            g.drawImage(this.select.getImgSelect(), this.select.getxPos(), this.select.getyPos(), null);
            g.drawImage(this.accueil.getImgJouer(), 150, 300, null);
            g.drawImage(this.accueil.getImgInstru(), 150, 400, null);
            g.drawImage(this.accueil.getImgOptions(), 150, 500, null);
            System.out.println(Main.scene.select.getNumPos());
            etat = 0;
        }

        else if(screen == 1){
            //Decompte avant partie
            if(this.combat.getTime() != 100){
                this.combat.setTime(Main.scene.combat.getTime()+1);
            }
            else if(this.combat.getTime() == 100){
                this.combat.setTime(0);
                this.combat.setDecompte(this.combat.getDecompte()-1);
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
                    this.screen = 5;
                    this.combat.setDecompte(3);
                    break;
            }
        }


        //Insctructions
        else if(screen == 2){
            System.out.println(Main.scene.select.getNumPos());
            g.drawImage(this.imgBackGInst, 0, 0, null);
        }

        //Options
        else if(screen == 3){
        }

        //Game
        else if(screen == 5) {
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

                //Test si un joueur n'as plus de vie
                if (Main.scene.joueurs.get(j).getVie() == 0) {
                    this.screen = 6;
                    Main.scene.joueur1.setVie(100);
                    Main.scene.joueur2.setVie(100);
                    Main.scene.joueur1.setX(50);
                    Main.scene.joueur1.setY(330);
                    Main.scene.joueur2.setX(988);
                    Main.scene.joueur2.setY(330);
                    for(int l=0; l<Main.scene.joueur1.getTir().size(); l++){
                        Main.scene.joueur1.getLaser(l).vaisseauTir = false;
                        Main.scene.joueur1.getLaser(l).setyPos(-100);
                        Main.scene.joueur1.getLaser(l).setxPos(-100);
                    }
                    for(int l=0; l<Main.scene.joueur2.getTir().size(); l++){
                        Main.scene.joueur2.getLaser(l).vaisseauTir = false;
                        Main.scene.joueur2.getLaser(l).setyPos(-100);
                        Main.scene.joueur2.getLaser(l).setxPos(-100);
                    }
                    Main.scene.combat.win = j;
                }
            }
        }

        //Ecran Fin de partie
        else if(screen == 6){
            g.drawImage(this.combat.getImgTrophee(), 330, 50, null);
            if(Main.scene.combat.win == 1){
                g.drawImage(this.combat.getImgJ1(), 480, 50, null);
            }else{
                g.drawImage(this.combat.getImgJ2(), 480, 50, null);
            }
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

        //Retour
        if(screen == 2 || screen == 3){
            if(etat == 0){
                this.select.setyPos(0);
                this.select.setNumPos(1);
                etat = 1;
            }

            if(this.combat.getTime() == 300){
                this.combat.setTime(0);
            }else if (this.combat.getTime() >= 150){
                this.combat.setTime(this.combat.getTime()+1);
            }else if(this.combat.getTime() < 150) {
                g.drawImage(this.select.getImgSelect(), 0, this.select.getyPos(), null);
                this.combat.setTime(this.combat.getTime()+1);
            }

            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g.drawString("Retour", 55, 42);
        }
    }
}
