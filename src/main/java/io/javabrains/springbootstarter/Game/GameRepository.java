package io.javabrains.springbootstarter.Game;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository <Game, Integer>{
    public List<Game> findByplayer1Id(int player1Id);
    public List<Game> findByPlayer2Id(int player2Id);


}
