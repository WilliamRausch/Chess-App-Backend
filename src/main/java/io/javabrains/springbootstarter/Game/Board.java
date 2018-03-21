package io.javabrains.springbootstarter.Game;


import org.hibernate.type.descriptor.sql.NVarcharTypeDescriptor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

@Entity
@Access(AccessType.FIELD)

public class Board {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Space2> getSpots() {
        return spots;
    }

    public void setSpots(List<Space2> spots) {
        this.spots = spots;
    }

    @Column(length = 4000)

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)

    private List<Space2> spots;
    //private Space[][] spots = new Space[8][8];


    public Board() {
    }

    public Board(List<Space2> spots) {
        super();
        this.spots = spots;

        for(int i=0; i<=8; i++) {
            for(int j=0; j<=8; j++) {
                this.spots.add(new Space2(i,j,null));
            }
        }



//        for(int i=0; i<spots.length; i++){
//            for(int j=0; j<spots.length; j++){
//                this.spots[i][j] = new Space(i, j);
//            }
//        }
    }

    public Space2 getspace(int x, int y) {
        int numconvert = ((x*8)+x+y);
        return spots.get(numconvert);


        //return new Space(1,1);
        //return spots.get(x) ;
    }
    public void printboard(){
        for(int i=0; i<8;i++){
            System.out.println(" ");
            for(int j=0; j<8; j++){
                if(this.getspace(i,j) .isOccupied()){
                    System.out.print(this.getspace(i,j).piece.charSymbol);
                }else
                System.out.print("[ ]");
            }
        }
        System.out.println("CHESSBOARD");
    }



}