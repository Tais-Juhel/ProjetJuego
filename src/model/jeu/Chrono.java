package model.jeu;

import controler.Main;

public class Chrono implements Runnable{
    private final int PAUSE = 5;

    @Override
    public void run() {
        while(true){
            //Test collision Lasers J1
            for(int l=0; l<Main.scene.joueurs.get(0).getTir().size(); l++){
                Main.scene.joueurs.get(0).getLaser(l).collision(Main.scene.joueurs.get(1));
            }
            //Test collision Lasers J2
            for(int l=0; l<Main.scene.joueurs.get(1).getTir().size(); l++){
                Main.scene.joueurs.get(1).getLaser(l).collision(Main.scene.joueurs.get(0));
            }


            //Actualise les images a l'ecran
            if(Main.scene.screen == 5) {
                for (int j = 0; j < Main.scene.joueurs.size(); j++) {
                    for (int i = 0; i < Main.scene.joueurs.get(j).getTir().size(); i++) {
                        if (Main.scene.joueurs.get(j).getDirTir() <= 2 && Main.scene.joueurs.get(j).getLaser(i).isVaisseauTir() == false) {
                            Main.scene.joueurs.get(j).getLaser(i).setImage("/img/laser.png");
                            if (Main.scene.joueurs.get(j).getDirTir() == 1) {
                                Main.scene.joueurs.get(j).getLaser(i).setDx(2);
                                Main.scene.joueurs.get(j).getLaser(i).setDy(0);
                            } else {
                                Main.scene.joueurs.get(j).getLaser(i).setDx(-2);
                                Main.scene.joueurs.get(j).getLaser(i).setDy(0);
                            }
                        }
                        if (Main.scene.joueurs.get(j).getDirTir() >= 3 && Main.scene.joueurs.get(j).getLaser(i).isVaisseauTir() == false) {
                            Main.scene.joueurs.get(j).getLaser(i).setImage("/img/laserB.png");
                            if (Main.scene.joueurs.get(j).getDirTir() == 3) {
                                Main.scene.joueurs.get(j).getLaser(i).setDx(0);
                                Main.scene.joueurs.get(j).getLaser(i).setDy(2);
                            } else {
                                Main.scene.joueurs.get(j).getLaser(i).setDx(0);
                                Main.scene.joueurs.get(j).getLaser(i).setDy(-2);
                            }
                        }

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
