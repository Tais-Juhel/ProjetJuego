package model.objets;

import controler.Main;
import model.personnage.Joueur;

import javax.swing.*;
import java.awt.*;

public class Laser {
    //VARIABLE
    public boolean vaisseauTir = false;

    private int largeur;
    private int hauteur;
    private int x;
    private int y;
    private int xPos;
    private int yPos;
    private int dx;
    private int dy;
    private int rt;
    private String strImage;
    private ImageIcon icoLaser;
    private Image imgLaser;

    //CONSTRUCTEUR
    public Laser(){
        this.largeur = 20;
        this.hauteur = 10;
        this.x = 0;
        this.y = 0;
        this.xPos = 0;
        this.yPos = 0;
        this.dx = 2;
        this.dy = 0;
        this.rt = 0;
        this.strImage = "/img/laser.png";
        this.icoLaser = new ImageIcon(getClass().getResource(this.strImage));
        this.imgLaser = this.icoLaser.getImage();
    }

    //GETTER
    public int getLargeur() {return largeur;}

    public int getHauteur() {return hauteur;}

    public int getX(){return this.x;}

    public int getY(){return this.y;}

    public int getRt(){return this.rt;}

    public int getxPos(){return this.xPos;}

    public int getyPos(){return this.yPos;}

    public int getDx() {
        return dx;
    }

    public int getDy() {return dy;}

    public String getStrImage() {return strImage;}

    //SETTER
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setxPos(int x){this.xPos = x;}

    public void setyPos(int y){this.yPos = y;}

    public void setDx(int dx) {this.dx = dx;}

    public void setStrImage(String strImage) {
        this.strImage = strImage;
    }

    public void setDy(int dy) {this.dy = dy;}

    public void setImage(String strImage) {
        this.strImage = strImage;
        this.icoLaser = new ImageIcon(getClass().getResource(this.strImage));
        this.imgLaser = this.icoLaser.getImage();
    }

    //METHODES
    public boolean isVaisseauTir(){return vaisseauTir;}

    public void setVaisseauTir(boolean vaisseauTir){this.vaisseauTir = vaisseauTir;}

    public int deplacementTirVaisseauY(){
        if(this.vaisseauTir == true) {
            if (this.y > 20 && this.y < 680) {
                this.y = this.y - this.dy;
            } else {
                this.vaisseauTir = false;
            }
        }
        return y;
    }

    public int deplacementTirVaisseauX(){
        if(this.vaisseauTir == true) {
            if (this.x < 1000 && this.x > 50) {
                this.x = this.x + this.dx;
            } else {
                this.vaisseauTir = false;
            }
        }
        return x;
    }

    public void dessinTirVaisseau(Graphics g){
        if(this.vaisseauTir == true){
            g.drawImage(this.imgLaser, this.deplacementTirVaisseauX(), deplacementTirVaisseauY(), null);
        }
    }

    public void collision(Joueur j){
        if(this.x + this.largeur > j.getX() && this.x < j.getX() + j.getLargeur()
                && this.y + this.hauteur > j.getY() && this.y < j.getY() + j.getHauteur()
        ){
            this.vaisseauTir = false;
            this.x = -100;
            this.y = -100;
            System.out.println("Collision !!!");
            j.degat();
        }
        if(this.x + this.largeur > 521 && this.x < 588
                && this.y + this.hauteur > 160 && this.y < 490){
            this.vaisseauTir = false;
        }
    }
}
