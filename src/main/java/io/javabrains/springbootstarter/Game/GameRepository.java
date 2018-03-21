package io.javabrains.springbootstarter.Game;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository <Game, String>{
    public List<Game> findByplayer1Id(String player1Id);
    public List<Game> findByPlayer2Id(String player2Id);


}
