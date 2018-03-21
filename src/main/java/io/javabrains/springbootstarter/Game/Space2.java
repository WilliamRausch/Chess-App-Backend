package io.javabrains.springbootstarter.Game;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Space2{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;
    int x;
    int y;

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    Piece piece;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Space2(int x, int y, Piece piece) {

        this.piece = piece;
        this.x = x;
        this.y = y;



    }

    public Space2() {

    }

    public void occupySpot(Piece piece){
        //if piece already here, delete it, i. e. set it dead
        if(this.piece != null)
            this.piece.setActive(false);
        //place piece here
        this.piece = piece;
    }

    public boolean isOccupied() {
        if(piece != null)
            return true;
        return false;
    }



}