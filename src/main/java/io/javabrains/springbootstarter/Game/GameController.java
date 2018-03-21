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
    public List<Game> getAllGames(@PathVariable String playerId){
        return gameService.getAllGames(playerId);
    }
    @RequestMapping("/Players/{playerId}/Games/{gameId}")
    public Game getGame(@PathVariable String gameId){
        return gameService.getGame(gameId);
    }
    @RequestMapping(method= RequestMethod.POST, value="/Players/{player1Id}/Games/{player2Id}")
    public void addGame(@RequestBody Game game, @PathVariable String player1Id, @PathVariable String player2Id){
        game.setPlayer1(new Player(player1Id, "")) ;
        game.setPlayer2(new Player(player2Id, "")) ;
        List<Space2> spots = new ArrayList<>();
        //spots.add(new Space2(2,2));
        Board board = new Board(spots);
        game.setBoard(board);
         //ArrayList<testObj2>[][] testObj2Array = new ArrayList<testObj2>[1][1] ;
        List<testObj2> test2Array = new ArrayList<>();
        testObj2 test2 = new testObj2(3) ;
        test2Array.add(test2) ;
        System.out.println(test2);
        System.out.println("The array is" + test2Array );


        TestObj test = new TestObj("hello", 3, test2Array);
        test.setTest2(test2Array);
        //test.setTest2(new testObj2(3)) ;
        game.setTest(test) ;
        System.out.println(game.getTest().getTest2());
        //System.out.println(game.getBoard().getspace(1,1) );
        gameService.addGame(game);

    }
    @RequestMapping(method= RequestMethod.PUT, value="/Players/{playerId}/Games/{gameId}")
    public void updateGame(@RequestBody Game game, @PathVariable String gameId, String playerId){
        game.setPlayer1(new Player(playerId, "")) ;
        gameService.updateGame(game);

    }

    @RequestMapping(method= RequestMethod.DELETE, value="/Players/{playerId}/Games/{gameId}")
    public void deleteGame( @PathVariable String gameId){
        gameService.deleteGame(gameId);

    }
    @RequestMapping(method= RequestMethod.PUT, value="/Players/{playerId}/Games/{gameId}/{currentSpace}/{selectedSpace}")
    public void movePiece(@PathVariable String gameId, String playerId, @PathVariable String currentSpace, @PathVariable String selectedSpace){

        System.out.println("SPACES");
        System.out.println(currentSpace+" "+ selectedSpace );
        Game game = gameService.getGame(gameId);
        gameService.movePiece(game, currentSpace, selectedSpace);

    }
}
