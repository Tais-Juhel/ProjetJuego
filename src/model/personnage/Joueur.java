package model.personnage;

import controler.Main;
import model.objets.Laser;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Joueur{
    //VARIABLE
    private int largeur;
    private int hauteur;
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int tourTir;
    private int dirTir;
    private String strImage;
    private ImageIcon icoJoueur;
    private Image imgJoueur;
    private ArrayList<Laser> tir = new ArrayList<Laser>();

    private int vie;

    //CONSTRUCTEUR

    public Joueur(int x, int y, String strImage, int dirTir, int vie){
        this.largeur = 40;
        this.hauteur = 40;
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.tourTir = 0;
        this.dirTir = dirTir;
        this.strImage = strImage;
        this.icoJoueur = new ImageIcon(getClass().getResource(this.strImage));
        this.imgJoueur = this.icoJoueur.getImage();

        this.vie = vie;
    }

    //GETTER

    public Laser getLaser(int n){
        return this.tir.get(n);
    }

    public int getLargeur() {return largeur;}

    public int getHauteur() {return hauteur;}

    public int getX() {return x;}

    public int getY() {return y;}

    public Image getImgJoueur() {return imgJoueur;}

    public int getTourTir() {
        return tourTir;
    }

    public int getDirTir() {return dirTir;}

    public ArrayList<Laser> getTir() {return tir;}

    public int getVie() {return vie;}

    //SETTER

    public void setDy(int dy) {this.dy = dy;}

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setTourTir(int tourTir) {this.tourTir = tourTir;}

    public void setDirTir(int dirTir) {this.dirTir = dirTir; }

    //METHODES
    public void ajouterLaser(int nbr){
        for(int i=0; i<nbr; i++){
            this.tir.add(new Laser());
        }
        System.out.println(tir.get(1));
    }

    public int deplacementJoueurX(){
        if(this.dx < 0){if(this.x > 0){this.x = this.x + this.dx;}
        }else if(dx > 0){if(this.x + this.dx < 1027){this.x = this.x + this.dx;}}
        return this.x;
    }

    public int deplacementJoueurY(){
        if(this.dy < 0){if(this.y > 0){this.y = this.y + this.dy;}
        }else if(dy > 0){if(this.y + this.dy < 645){this.y = this.y + this.dy;}}
        return this.y;
    }

    public void degat(){
        this.vie = this.vie - 10;
        if(this.vie < 0){this.vie = 0;}
        System.out.println(this.vie);
    }
}
