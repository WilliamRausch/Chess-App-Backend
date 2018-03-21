//package io.javabrains.springbootstarter.Game;
//
//public class Queen extends Piece {
//    public Queen(Space space, String color, String charSymbol, boolean isActive) {
//        super(space, color, charSymbol, isActive);
//    }
//    public void move(Space selected, Board board){
//        Space current = this.getSpace();
//        if (selected.x == current.x) {
//            if (selected.y > current.y) {
//                for (int y = current.y; y < selected.y; y++) {
//                    if (board.getspace(selected.x, y).isOccupied()&&y!=current.y) {
//                        System.out.println("Invalid Move");
//                        break;
//                    } else if (y == selected.y - 1) {
//                        current.piece = null;
//                        selected.occupySpot(this);
//                        this.setSpace(board.getspace(selected.x, selected.y));
//                    }
//
//                }
//            } else if (selected.y < current.y) {
//                for (int y = current.y; y > selected.y; y--) {
//                    if (board.getspace(selected.x, y).isOccupied()&&y!=current.y) {
//                        System.out.println("Invalid Move");
//                        break;
//                    } else if (y == selected.y + 1) {
//                        current.piece = null;
//                        selected.occupySpot(this);
//                        this.setSpace(board.getspace(selected.x, selected.y));
//                    }
//                }
//
//            }
//        } else if(selected.y==current.y){
//            if (selected.x > current.x) {
//                for (int x = current.x; x < selected.x; x++) {
//                    if (board.getspace(selected.x, x).isOccupied()&&x!=current.x) {
//                        System.out.println("Invalid Move");
//                        break;
//                    } else if (x == selected.x - 1) {
//                        current.piece = null;
//                        selected.occupySpot(this);
//                        this.setSpace(board.getspace(selected.x, selected.y));
//                    }
//
//                }
//            } else if (selected.x < current.x) {
//                for (int x = current.x; x > selected.x; x--) {
//                    if (board.getspace(selected.x, x).isOccupied()&&x!=current.x) {
//                        System.out.println("Invalid Move");
//                        break;
//                    } else if (x == selected.x + 1) {
//                        current.piece = null;
//                        selected.occupySpot(this);
//                        this.setSpace(board.getspace(selected.x, selected.y));
//                    }
//                }
//
//            }
//
//        } else if(Math.abs(current.x-selected.x)==Math.abs(current.y-selected.y)){
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
