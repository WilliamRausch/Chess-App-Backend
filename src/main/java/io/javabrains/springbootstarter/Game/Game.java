package io.javabrains.springbootstarter.Game;

import io.javabrains.springbootstarter.user.Player;

import javax.persistence.*;


@Entity
public class Game {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Player player1;

    @ManyToOne
    private Player player2;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )


    private Board board;





    public Game() {

    }

    public Game(int id, int player1Id, int player2Id,  Board board) {

        this.id = id;
        this.board = board;

        this.player1 = new Player(player1Id, "", "",0,0);
        this.player2 = new Player(player2Id, "", "",0,0);

    }
    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }
    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
