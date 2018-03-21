//package io.javabrains.springbootstarter.Game;
//
//public class Knight extends Piece {
//    public Knight(Space space, String color, String charSymbol, boolean isActive) {
//        super(space, color, charSymbol, isActive);
//    }
//
//    public void move (Space selected, Board board){
//        Space current = this.space;
//        if((selected.x==this.space.x+1&&selected.y==this.space.y+2)|| (selected.x==this.space.x-1&&selected.y==this.space.y+2)){
//            current.piece = null;
//            selected.occupySpot(this) ;
//            this.setSpace(board.getspace(selected.x, selected.y) ) ;
//        }else if((selected.x==this.space.x+1&&selected.y==this.space.y-2)|| (selected.x==this.space.x-1&&selected.y==this.space.y-2)){
//            current.piece = null;
//            selected.occupySpot(this) ;
//            this.setSpace(board.getspace(selected.x, selected.y) ) ;
//        }
//        else{
//            System.out.println("Invalid Move");
//        }
//    }
//}
