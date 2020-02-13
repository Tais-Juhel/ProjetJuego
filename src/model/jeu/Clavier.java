package model.jeu;

import controler.Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener{
    int tourj1 = 0;
    int tourj2 = 0;

    @Override
    public void keyPressed(KeyEvent e) {
        if(Main.scene.screen == 0){
            System.out.println("Scene : 0 !!!");
            //Bouton pour Accueil
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                Main.scene.select.setNumPos(Main.scene.select.getNumPos()-1);
                Main.scene.select.setyPos(Main.scene.select.getyPos()-100);
                if(Main.scene.select.getNumPos() < 1){
                    Main.scene.select.setNumPos(1);
                    Main.scene.select.setyPos(200);
                }
            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                Main.scene.select.setNumPos(Main.scene.select.getNumPos()+1);
                Main.scene.select.setyPos(Main.scene.select.getyPos()+100);
                if(Main.scene.select.getNumPos() > 4){
                    Main.scene.select.setNumPos(4);
                    Main.scene.select.setyPos(500);
                }
            }
            else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                Main.scene.screen = Main.scene.select.getNumPos();
            }
        }
        else if(Main.scene.screen == 2) {
            //Joueur1
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                Main.scene.joueurs.get(0).setDx(1);
                Main.scene.joueurs.get(0).setDirTir(1);
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                Main.scene.joueurs.get(0).setDx(-1);
                Main.scene.joueurs.get(0).setDirTir(2);
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                Main.scene.joueurs.get(0).setDy(-1);
                Main.scene.joueurs.get(0).setDirTir(3);
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                Main.scene.joueurs.get(0).setDy(1);
                Main.scene.joueurs.get(0).setDirTir(4);
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                tourj1 = Main.scene.joueurs.get(0).getTourTir();
                if (Main.scene.joueurs.get(0).getLaser(tourj1).isVaisseauTir() == false) {
                    Main.scene.joueurs.get(0).getLaser(tourj1).setY(Main.scene.joueurs.get(0).getY() + 15);
                    Main.scene.joueurs.get(0).getLaser(tourj1).setyPos(Main.scene.joueurs.get(0).getLaser(tourj1).getY());
                    Main.scene.joueurs.get(0).getLaser(tourj1).setX(Main.scene.joueurs.get(0).getX() + 15);
                    Main.scene.joueurs.get(0).getLaser(tourj1).setxPos(Main.scene.joueurs.get(0).getLaser(tourj1).getX());
                    Main.scene.joueurs.get(0).getLaser(tourj1).setVaisseauTir(true);
                    System.out.println(tourj1);
                    Main.scene.joueurs.get(0).setTourTir(tourj1 + 1);
                    if (tourj1 == Main.scene.joueurs.get(0).getTir().size() - 1) {
                        Main.scene.joueurs.get(0).setTourTir(0);
                    }
                }
            }
            //Joueur2
            if (e.getKeyCode() == KeyEvent.VK_D) {
                Main.scene.joueurs.get(1).setDx(1);
                Main.scene.joueurs.get(1).setDirTir(1);
            } else if (e.getKeyCode() == KeyEvent.VK_Q) {
                Main.scene.joueurs.get(1).setDx(-1);
                Main.scene.joueurs.get(1).setDirTir(2);
            }
            if (e.getKeyCode() == KeyEvent.VK_Z) {
                Main.scene.joueurs.get(1).setDy(-1);
                Main.scene.joueurs.get(1).setDirTir(3);
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                Main.scene.joueurs.get(1).setDy(1);
                Main.scene.joueurs.get(1).setDirTir(4);
            } else if (e.getKeyCode() == KeyEvent.VK_W) {
                tourj2 = Main.scene.joueurs.get(1).getTourTir();
                if (Main.scene.joueurs.get(1).getLaser(tourj2).isVaisseauTir() == false) {
                    Main.scene.joueurs.get(1).getLaser(tourj2).setY(Main.scene.joueurs.get(1).getY() + 15);
                    Main.scene.joueurs.get(1).getLaser(tourj2).setyPos(Main.scene.joueurs.get(1).getLaser(tourj2).getY());
                    Main.scene.joueurs.get(1).getLaser(tourj2).setX(Main.scene.joueurs.get(1).getX() + 15);
                    Main.scene.joueurs.get(1).getLaser(tourj2).setxPos(Main.scene.joueurs.get(1).getLaser(tourj2).getX());
                    Main.scene.joueurs.get(1).getLaser(tourj2).setVaisseauTir(true);
                    System.out.println(tourj2);
                    Main.scene.joueurs.get(1).setTourTir(tourj2 + 1);
                    if (tourj2 == Main.scene.joueurs.get(1).getTir().size() - 1) {
                        Main.scene.joueurs.get(1).setTourTir(0);
                    }
                }
            }
        }

        else if(Main.scene.screen == 3) {
            if(e.getKeyCode() == KeyEvent.VK_SPACE){
                Main.scene.screen = 0;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT){Main.scene.joueurs.get(0).setDx(0);}
        if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN){Main.scene.joueurs.get(0).setDy(0);}
        if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_Q){Main.scene.joueurs.get(1).setDx(0);}
        if(e.getKeyCode() == KeyEvent.VK_Z || e.getKeyCode() == KeyEvent.VK_S){Main.scene.joueurs.get(1).setDy(0);}
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
