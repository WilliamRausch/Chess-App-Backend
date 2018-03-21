package io.javabrains.springbootstarter.Game;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Space{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;
    int x;
    int y;

    @OneToOne
    Piece piece;


    public Space(int x, int y) {
        super();
        this.x = x;
        this.y = y;

        piece = null;

    }

    public Space() {

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