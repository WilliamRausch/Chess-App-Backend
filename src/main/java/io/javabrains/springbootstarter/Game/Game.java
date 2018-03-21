package io.javabrains.springbootstarter.Game;

import io.javabrains.springbootstarter.user.Player;

import javax.persistence.*;


@Entity
public class Game {
    @Id
    private String id;

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

    public TestObj getTest() {
        return test;
    }

    public void setTest(TestObj test) {
        this.test = test;
    }
    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private TestObj test;

    public Game() {

    }

    public Game(String id, String player1Id, String player2Id, TestObj test, Board board) {
        this.test=test;
        this.id = id;
        this.board = board;

        this.player1 = new Player(player1Id, "");
        this.player2 = new Player(player2Id, "");

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
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
