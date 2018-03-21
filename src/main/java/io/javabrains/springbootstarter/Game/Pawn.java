package io.javabrains.springbootstarter.Game;

public class Pawn extends Piece {
    public Pawn(int xpos, int ypos, String color, String charSymbol, boolean isActive) {
        super(xpos, ypos, color, charSymbol, isActive);
    }



    public void move(int xpos, int ypos,  Board board, Space2 selected) {
        Space2 current = board.getspace(xpos,ypos) ;
        if (selected.y == current.y + 1 && selected.x == current.x) {
            this.setXpos(xpos);
            this.setYpos(ypos);
            selected.occupySpot(this);
            current.piece = null;
        } else if ((selected.y == current.y + 1 && selected.x == current.x + 1 || selected.x == current.x - 1) && selected.isOccupied()) {

                this.setXpos(xpos);
                this.setXpos(ypos);
                selected.occupySpot(this);
                current.piece = null;

    }else{



        System.out.println("invalid Move");
    }
}
}




