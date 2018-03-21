//package io.javabrains.springbootstarter.Game;
//
//public class Bishop extends Piece  {
//    public Bishop(Space space, String color, String charSymbol, boolean isActive) {
//        super(space, color, charSymbol, isActive);
//    }
//    public void move(Space selected, Board board){
//        Space current = this.space;
//        if(Math.abs(current.x-selected.x)==Math.abs(current.y-selected.y)){
//            if(current.x<selected.x&&current.y<selected.y){
//                for(int s = 0; s<Math.abs(current.x-selected.x); s++ ){
//                    if(board.getspace((current.x+s), (current.y+s)).isOccupied()&&s!=0){
//                        System.out.println("invalid move");
//                        break;
//                    }else if(s==(Math.abs(current.x-selected.x)-1)){
//                        current.piece = null;
//                        selected.occupySpot(this) ;
//                        this.setSpace(board.getspace(selected.x, selected.y) ) ;
//                    }
//                }
//            }else if(current.x>selected.x&&current.y<selected.y){
//                for(int s = 0; s<Math.abs(current.x-selected.x); s++ ){
//                    if(board.getspace((current.x-s), (current.y+s)).isOccupied()&&s!=0){
//                        System.out.println("invalid move");
//                        break;
//                    }else if(s==(Math.abs(current.x-selected.x)-1)){
//                        current.piece = null;
//                        selected.occupySpot(this) ;
//                        this.setSpace(board.getspace(selected.x, selected.y) ) ;
//                    }
//                }
//            }else if(current.x>selected.x&&current.y>selected.y){
//                for(int s = 0; s<Math.abs(current.x-selected.x); s++ ){
//                    if(board.getspace((current.x-s), (current.y-s)).isOccupied()&&s!=0){
//                        System.out.println("invalid move");
//                        break;
//                    }else if(s==(Math.abs(current.x-selected.x)-1)){
//                        current.piece = null;
//                        selected.occupySpot(this) ;
//                        this.setSpace(board.getspace(selected.x, selected.y) ) ;
//                    }
//                }
//            }else if(current.x<selected.x&&current.y>selected.y){
//                for(int s = 0; s<Math.abs(current.x-selected.x); s++ ){
//                    if(board.getspace((current.x+s), (current.y-s)).isOccupied()&&s!=0){
//                        System.out.println("invalid move");
//                        break;
//                    }else if(s==(Math.abs(current.x-selected.x)-1)){
//                        current.piece = null;
//                        selected.occupySpot(this) ;
//                        this.setSpace(board.getspace(selected.x, selected.y) ) ;
//                    }
//                }
//            }
//
//
//        }else{
//            System.out.println("invalid move");
//        }
//    }
//}
