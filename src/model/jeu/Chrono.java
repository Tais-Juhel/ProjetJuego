package model.jeu;

import controler.Main;

public class Chrono implements Runnable{
    private final int PAUSE = 5;

    @Override
    public void run() {
        while(true){
            //Actualise les images a l'ecran
            for(int i=Main.scene.joueur1.getTourTir(); i<5; i++) {
                if (Main.scene.joueur1.getDirTir() <= 2 && Main.scene.joueur1.getLaser(i).isVaisseauTir() == false){
                    Main.scene.joueur1.getLaser(i).setImage("/img/laser.png");
                    if(Main.scene.joueur1.getDirTir() == 1){
                        Main.scene.joueur1.getLaser(i).setDx(2);
                        Main.scene.joueur1.getLaser(i).setDy(0);
                    } else {
                        Main.scene.joueur1.getLaser(i).setDx(-2);
                        Main.scene.joueur1.getLaser(i).setDy(0);
                    }
                }
                if (Main.scene.joueur1.getDirTir() >= 3 && Main.scene.joueur1.getLaser(i).isVaisseauTir() == false){
                    Main.scene.joueur1.getLaser(i).setImage("/img/laserB.png");
                    if(Main.scene.joueur1.getDirTir() == 3){
                        Main.scene.joueur1.getLaser(i).setDx(0);
                        Main.scene.joueur1.getLaser(i).setDy(2);
                    } else {
                        Main.scene.joueur1.getLaser(i).setDx(0);
                        Main.scene.joueur1.getLaser(i).setDy(-2);
                    }
                }

            }

            Main.scene.repaint();
            try {
                Thread.sleep(this.PAUSE);
            } catch (InterruptedException e){}
        }
    }
}
