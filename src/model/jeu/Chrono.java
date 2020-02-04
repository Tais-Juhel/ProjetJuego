package model.jeu;

import controler.Main;

public class Chrono implements Runnable{
    private final int PAUSE = 5;

    @Override
    public void run() {
        while(Main.scene.jeuEnCours == true){
            //Actualise les images a l'ecran
            for(int j=0; j < Main.scene.joueurs.size(); j++) {
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

            Main.scene.repaint();
            try {
                Thread.sleep(this.PAUSE);
            } catch (InterruptedException e){}
        }
    }
}
