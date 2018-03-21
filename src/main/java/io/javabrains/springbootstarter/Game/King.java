//package io.javabrains.springbootstarter.Game;
//
//public class King extends Piece {
//    public King(Space space, String color, String charSymbol, boolean isActive) {
//        super(space, color, charSymbol, isActive);
//    }
//    public void move(Space selected, Board board){
//        Space current = this.getSpace();
//        if((selected.y==current.y+1||selected.y==current.y-1)&&current.x==selected.x){
//            current.piece = null;
//            selected.occupySpot(this) ;
//            this.setSpace(board.getspace(selected.x, selected.y) ) ;
//        }else if((selected.x==current.x+1||selected.y==current.x-1)&&current.y==selected.y){
//            current.piece = null;
//            selected.occupySpot(this) ;
//            this.setSpace(board.getspace(selected.x, selected.y) ) ;
//        }else{
//            System.out.println("invalid move");
//        }
//    }
//}
