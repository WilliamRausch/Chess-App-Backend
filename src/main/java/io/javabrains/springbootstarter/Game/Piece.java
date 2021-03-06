package io.javabrains.springbootstarter.Game;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class Piece {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int xpos;
    int ypos;
    String color;

    public String getCharSymbol() {
        return charSymbol;
    }

    public void setCharSymbol(String charSymbol) {
        this.charSymbol = charSymbol;
    }

    String charSymbol;
    boolean isActive;

    public Piece(int xpos, int ypos, String color, String charSymbol, boolean isActive) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.color = color;
        this.charSymbol = charSymbol;
        this.isActive = isActive;
    }

    public Piece() {
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean Pawnmove(int xpos, int ypos, Board board, Space2 selected) {
        Space2 current = board.getspace(xpos, ypos);
        if (selected.y == current.y + 1 && selected.x == current.x || (selected.y==current.y-1 && selected.x == current.x)) {
//            this.setXpos(selected.x);
//            this.setYpos(selected.y);
//            selected.occupySpot(this);
//            current.piece = null;
            return true;
        } else if ((selected.y == current.y + 1 && selected.x == current.x + 1 || selected.x == current.x - 1) && selected.isOccupied()) {

//            this.setXpos(selected.x);
//            this.setXpos(selected.y);
//            selected.occupySpot(this);
//            current.piece = null;
            return true;

        } else {

            return false;
            //System.out.println("invalid Move");
        }
        //System.out.println("override error");
    }

    public boolean Rookmove(int xpos, int ypos, Board board, Space2 selected) {
        Space2 current = board.getspace(xpos, ypos);
        if (selected.x == current.x) {
            if (selected.y > current.y) {
                for (int y = current.y; y < selected.y; y++) {
                    if (board.getspace(selected.x, y).isOccupied() && y != current.y) {
                        return false;
                    } else if (y == selected.y - 1) {

                        //current.piece = null;
//                        selected.occupySpot(this);
//
//                        this.setXpos(selected.x) ;
//                        this.setYpos(selected.y) ;
                        return true;
                    }

                }
            } else if (selected.y < current.y) {
                for (int y = current.y; y > selected.y; y--) {
                    if (board.getspace(selected.x, y).isOccupied() && y != current.y) {
                        System.out.println("Invalid Move");
                        return false;

                    } else if (y == selected.y + 1) {
                       // current.piece = null;
                        return true;
                    }
                }

            }
        } else if (selected.y == current.y) {
            if (selected.x > current.x) {
                for (int x = current.x; x < selected.x; x++) {
                    if (board.getspace(selected.x, x).isOccupied() && x != current.x) {
                        return false;
                        //System.out.println("Invalid Move");
                        //break;
                    } else if (x == selected.x - 1) {
                        return true;
                        //current.piece = null;
//                        selected.occupySpot(this);
//
//                        this.setXpos(selected.x) ;
//                        this.setYpos(selected.y) ;
                    }

                }
            } else if (selected.x < current.x) {
                for (int x = current.x; x > selected.x; x--) {
                    if (board.getspace(selected.x, x).isOccupied() && x != current.x) {
                        return false;

                    } else if (x == selected.x + 1) {
                       return true;
                    }
                }

            }

        } else {
            return false;
            //System.out.println("invalid move");
        }
        return false;
    }

    public boolean Queenmove(int xpos, int ypos, Board board, Space2 selected) {
        Space2 current = board.getspace(xpos, ypos);
        if (selected.x == current.x) {
            if (selected.y > current.y) {
                for (int y = current.y; y < selected.y; y++) {
                    if (board.getspace(selected.x, y).isOccupied() && y != current.y) {
                        return false;
                        //System.out.println("Invalid Move");
                        //break;
                    } else if (y == selected.y - 1) {
                        return true;
//                        current.piece = null;
//                        selected.occupySpot(this);
//                        this.setXpos(selected.x) ;
//                        this.setYpos(selected.y) ;
                    }

                }
            } else if (selected.y < current.y) {
                for (int y = current.y; y > selected.y; y--) {
                    if (board.getspace(selected.x, y).isOccupied() && y != current.y) {
                        return false;
                    } else if (y == selected.y + 1) {
                        return true;

                    }
                }

            }
        } else if (selected.y == current.y) {
            if (selected.x > current.x) {
                for (int x = current.x; x < selected.x; x++) {
                    if (board.getspace(selected.x, x).isOccupied() && x != current.x) {
                        return false;

                    } else if (x == selected.x - 1) {
                       return true;
                    }

                }
            } else if (selected.x < current.x) {
                for (int x = current.x; x > selected.x; x--) {
                    if (board.getspace(selected.x, x).isOccupied() && x != current.x) {
                        return false;
                    } else if (x == selected.x + 1) {
                        return true;
                    }
                }

            }

        } else if (Math.abs(current.x - selected.x) == Math.abs(current.y - selected.y)) {
            if (current.x < selected.x && current.y < selected.y) {
                for (int s = 0; s < Math.abs(current.x - selected.x); s++) {
                    if (board.getspace((current.x + s), (current.y + s)).isOccupied() && s != 0) {
                        return false;

                    } else if (s == (Math.abs(current.x - selected.x) - 1)) {
                       return true;
                    }
                }
            } else if (current.x > selected.x && current.y < selected.y) {
                for (int s = 0; s < Math.abs(current.x - selected.x); s++) {
                    if (board.getspace((current.x - s), (current.y + s)).isOccupied() && s != 0) {
                        return false;
                    } else if (s == (Math.abs(current.x - selected.x) - 1)) {
                       return true;
                    }
                }
            } else if (current.x > selected.x && current.y > selected.y) {
                for (int s = 0; s < Math.abs(current.x - selected.x); s++) {
                    if (board.getspace((current.x - s), (current.y - s)).isOccupied() && s != 0) {
                       return false;
                    } else if (s == (Math.abs(current.x - selected.x) - 1)) {
                        return true;
                    }
                }
            } else if (current.x < selected.x && current.y > selected.y) {
                for (int s = 0; s < Math.abs(current.x - selected.x); s++) {
                    if (board.getspace((current.x + s), (current.y - s)).isOccupied() && s != 0) {
                        return false;
                    } else if (s == (Math.abs(current.x - selected.x) - 1)) {
                      return true;
                    }
                }
            }


        } else {
            return false;

        }
        return false;
    }

    public boolean Bishopmove(int xpos, int ypos, Board board, Space2 selected) {
        Space2 current = board.getspace(xpos, ypos);
        if (Math.abs(current.x - selected.x) == Math.abs(current.y - selected.y)) {
            if (current.x < selected.x && current.y < selected.y) {
                for (int s = 0; s < Math.abs(current.x - selected.x); s++) {
                    if (board.getspace((current.x + s), (current.y + s)).isOccupied() && s != 0) {
                       return false;
                    } else if (s == (Math.abs(current.x - selected.x) - 1)) {
                      return true;
                    }
                }
            } else if (current.x > selected.x && current.y < selected.y) {
                for (int s = 0; s < Math.abs(current.x - selected.x); s++) {
                    if (board.getspace((current.x - s), (current.y + s)).isOccupied() && s != 0) {
                       return false;
                    } else if (s == (Math.abs(current.x - selected.x) - 1)) {
                       return true;
                    }
                }
            } else if (current.x > selected.x && current.y > selected.y) {
                for (int s = 0; s < Math.abs(current.x - selected.x); s++) {
                    if (board.getspace((current.x - s), (current.y - s)).isOccupied() && s != 0) {
                       return false;
                    } else if (s == (Math.abs(current.x - selected.x) - 1)) {
                        return true;

                    }
                }
            } else if (current.x < selected.x && current.y > selected.y) {
                for (int s = 0; s < Math.abs(current.x - selected.x); s++) {
                    if (board.getspace((current.x + s), (current.y - s)).isOccupied() && s != 0) {
                        return false;
                    } else if (s == (Math.abs(current.x - selected.x) - 1)) {
                        return true;
                    }
                }
            }


        } else {
            return false;

        }
        return false;
       // System.out.println("invalid Move");
    }

    public boolean Knightmove(int xpos, int ypos, Board board, Space2 selected) {
        Space2 current = board.getspace(xpos,ypos) ;
        if((selected.x==current.x+1&&selected.y==current.y+2)|| (selected.x==current.x-1&&selected.y==current.y+2)){
          return true;
        }else if((selected.x==current.x+1&&selected.y==current.y-2)|| (selected.x==current.x-1&&selected.y==current.y-2)){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean Kingmove(int xpos, int ypos, Board board, Space2 selected){
        Space2 current = board.getspace(xpos, ypos) ;
        if((selected.y==current.y+1||selected.y==current.y-1)&&current.x==selected.x){
            return true;

        }else if((selected.x==current.x+1||selected.y==current.x-1)&&current.y==selected.y){
         return true;
        }else{
            return false;
        }
    }
    }



