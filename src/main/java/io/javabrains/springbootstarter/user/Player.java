package io.javabrains.springbootstarter.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String name;

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    private int wins;

    private int losses;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public Player (){

    }

    public Player( int id, String name, String password, int wins, int losses) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.wins = wins;
        this.losses = losses;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
