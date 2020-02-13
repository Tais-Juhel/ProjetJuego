package controler;

import model.jeu.Scene;

import javax.swing.*;

public class Main {
    public static JFrame fenetre;
    //Contenu fenetre
    public static Scene scene;

    public static void main(String[] args) {
        fenetre = new JFrame("Juego");
        scene = new Scene();

        //Arrête le programme au clic sur la croix rouge
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(1080,750);
        //Place la fenetre au milieu de l'écran
        fenetre.setLocationRelativeTo(null);
        //Empeche le redimensionnement de la fenetre
        fenetre.setResizable(false);
        //Toujours en premier plan
        fenetre.setAlwaysOnTop(true);

        fenetre.setContentPane(scene);
        //Rend visible la fenetre
        fenetre.setVisible(true);
    }
}
