package model.jeu;

import controler.Main;

import javax.management.MBeanAttributeInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener{
    int tour = 0;

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            Main.scene.joueur1.setDx(1);
            Main.scene.joueur1.setDirTir(1);
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            Main.scene.joueur1.setDx(-1);
            Main.scene.joueur1.setDirTir(2);
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            Main.scene.joueur1.setDy(-1);
            Main.scene.joueur1.setDirTir(3);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            Main.scene.joueur1.setDy(1);
            Main.scene.joueur1.setDirTir(4);
        }
        else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            tour = Main.scene.joueur1.getTourTir();
            if(Main.scene.joueur1.getLaser(tour).isVaisseauTir() == false){
                Main.scene.joueur1.getLaser(tour).setY(Main.scene.joueur1.getY()+15);
                Main.scene.joueur1.getLaser(tour).setyPos(Main.scene.joueur1.getLaser(tour).getY());
                Main.scene.joueur1.getLaser(tour).setX(Main.scene.joueur1.getX()+15);
                Main.scene.joueur1.getLaser(tour).setxPos(Main.scene.joueur1.getLaser(tour).getX());
                Main.scene.joueur1.getLaser(tour).setVaisseauTir(true);
                System.out.println(tour);
                Main.scene.joueur1.setTourTir(tour+1);
                if(tour==Main.scene.joueur1.getTir().size()-1){Main.scene.joueur1.setTourTir(0);}
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT){Main.scene.joueur1.setDx(0);}
        if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN){Main.scene.joueur1.setDy(0);}
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
