package io.javabrains.springbootstarter.Game;

import io.javabrains.springbootstarter.user.Player;
import io.javabrains.springbootstarter.Game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping("/Players/{playerId}/Games")
    public List<Game> getAllGames(@PathVariable int playerId){
        return gameService.getAllGames(playerId);
    }
    @RequestMapping("/Players/{playerId}/Games/{gameId}")
    public Game getGame(@PathVariable int gameId){
        return gameService.getGame(gameId);
    }
    @RequestMapping(method= RequestMethod.POST, value="/Players/{player1Id}/Games/{player2Id}")
    public void addGame(@RequestBody Game game, @PathVariable int player1Id, @PathVariable int player2Id){
        game.setPlayer1(new Player(player1Id, "", "",0,0));
        game.setPlayer2(new Player(player2Id, "", "",0,0)) ;
        List<Space2> spots = new ArrayList<>();
        //spots.add(new Space2(2,2));
        Board board = new Board(spots);
        game.setBoard(board);
        game.setMoves(0);
         //ArrayList<testObj2>[][] testObj2Array = new ArrayList<testObj2>[1][1] ;






        //System.out.println(game.getBoard().getspace(1,1) );
        gameService.addGame(game);

    }
    @RequestMapping(method= RequestMethod.PUT, value="/Players/{playerId}/Games/{gameId}")
    public void updateGame(@RequestBody Game game, @PathVariable String gameId, Integer playerId){
        game.setPlayer1(new Player(playerId, "", "",0,0)) ;
        gameService.updateGame(game);

    }

    @RequestMapping(method= RequestMethod.DELETE, value="/Players/{playerId}/Games/{gameId}")
    public void deleteGame( @PathVariable int gameId){
        gameService.deleteGame(gameId);

    }
    @RequestMapping(method= RequestMethod.PUT, value="/Players/{playerId}/Games/{gameId}/{currentSpace}/{selectedSpace}")
    public void movePiece(@PathVariable Integer gameId, @PathVariable Integer playerId, @PathVariable String currentSpace, @PathVariable String selectedSpace){

        System.out.println("SPACES");
        System.out.println(currentSpace+" "+ selectedSpace );
        Game game = gameService.getGame(gameId);
        gameService.movePiece(game, currentSpace, selectedSpace);

    }

}
