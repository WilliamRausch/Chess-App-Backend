package io.javabrains.springbootstarter.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    //    private List<Player> players = new ArrayList<>(Arrays.asList(
//            new Player("1", "bob"),
//                new Player("2", "joe"),
//                new Player("3", "dan")
//        ));
    public List<Game> getAllGames(String playerId){
        List<Game> games = new ArrayList<>();
        gameRepository.findByplayer1Id(playerId).forEach(games::add);
        gameRepository.findByPlayer2Id(playerId).forEach(games::add);
        return games;
    }
    public Game getGame(String id){
        Game game = gameRepository.findOne(id);
        //System.out.println("hello");
//        System.out.println("TESTING"+game.getTest().getTest2());
//        System.out.println(game.getBoard().getspace(2,2).getX());
//        System.out.println(game.getBoard().getspace(2,2).getY());
//        System.out.println(game.getBoard().getspace(3,5).getX());
//        System.out.println(game.getBoard().getspace(3,5).getY());


           game.getBoard().printboard();

        //return players.stream().filter(u -> u.getId().equals(id)).findFirst().get();
        return gameRepository.findOne(id);
    }
    public void addGame(Game game){
        System.out.println("TESTING!"+game.getTest().getTest2());
        for(int i=0;i<8;i++) {
            game.getBoard().getspace(i, 1).setPiece(new Piece(i, 1, "black", "[P]", true));
            game.getBoard().getspace(i, 6).setPiece(new Piece(i, 1, "white", "[p]", true));
        }
        //Rooks
        game.getBoard().getspace(0,0).setPiece(new Piece(0,0,"black","[R]",true));
        game.getBoard().getspace(7,0).setPiece(new Piece(7,0,"black","[R]",true));
        game.getBoard().getspace(0,7).setPiece(new Piece(0,7,"white","[r]",true));
        game.getBoard().getspace(7,7).setPiece(new Piece(7,7,"white","[r]",true));

        //Knights
        game.getBoard().getspace(1,0).setPiece(new Piece(1,0,"black","[N]",true));
        game.getBoard().getspace(6,0).setPiece(new Piece(6,0,"black","[N]",true));
        game.getBoard().getspace(1,7).setPiece(new Piece(1,7,"white","[n]",true));
        game.getBoard().getspace(6,7).setPiece(new Piece(6,7,"white","[n]",true));

        //Bishops
        game.getBoard().getspace(2,0).setPiece(new Piece(2,0,"black","[B]",true));
        game.getBoard().getspace(5,0).setPiece(new Piece(5,0,"black","[B]",true));
        game.getBoard().getspace(2,7).setPiece(new Piece(2,0,"white","[b]",true));
        game.getBoard().getspace(5,7).setPiece(new Piece(5,0,"white","[b]",true));

        //Queens
        game.getBoard().getspace(3,0).setPiece(new Piece(3,0,"black","[Q]",true));
        game.getBoard().getspace(3,7).setPiece(new Piece(3,7,"white","[q]",true));

        //Kings
        game.getBoard().getspace(4,0).setPiece(new Piece(4,0,"black","[K]",true));
        game.getBoard().getspace(4,7).setPiece(new Piece(4,7,"white","[k]",true));
        gameRepository.save(game);

    }
    public void updateGame(Game game){
        gameRepository.save(game) ;
    }
    public void deleteGame(String id){
        gameRepository.delete(id);
    }

    public void movePiece(Game game, String current, String selected) {
        //getting the current x and y positions
        char cxpos = current.charAt(0);
        int xpos = Character.getNumericValue(cxpos);
        char cypos = current.charAt(1);
        int ypos = Character.getNumericValue(cypos);
//       getting the selected space to move to
        char scxpos = selected.charAt(0);
        int sxpos = Character.getNumericValue(scxpos);
        char scypos = selected.charAt(1);
        int sypos = Character.getNumericValue(scypos);
        Space2 selectedSpace = game.getBoard().getspace(sxpos, sypos);


        //had to put every method in the parent class since making piece abstract or an interface wasn't working with jpa

        //System.out.println(game.getBoard().getspace(xpos, ypos).piece.charSymbol);
        if (game.getBoard().getspace(xpos, ypos).piece.charSymbol.equalsIgnoreCase("[P]") || game.getBoard().getspace(xpos, ypos).piece.charSymbol.equalsIgnoreCase("[p]")) {
            game.getBoard().getspace(xpos, ypos).piece.Pawnmove(xpos, ypos, game.getBoard(), selectedSpace);
            //saving updated game
            gameRepository.save(game);
        } else if(game.getBoard().getspace(xpos, ypos).piece.charSymbol.equalsIgnoreCase("[R]") || game.getBoard().getspace(xpos, ypos).piece.charSymbol.equalsIgnoreCase("[r]")) {
            game.getBoard().getspace(xpos, ypos).piece.Rookmove(xpos, ypos, game.getBoard(), selectedSpace);
        gameRepository.save(game);
    }  else if(game.getBoard().getspace(xpos, ypos).piece.charSymbol.equalsIgnoreCase("[B]") || game.getBoard().getspace(xpos, ypos).piece.charSymbol.equalsIgnoreCase("[b]")) {
        game.getBoard().getspace(xpos, ypos).piece.Bishopmove(xpos, ypos, game.getBoard(), selectedSpace);
        gameRepository.save(game);
    }else if(game.getBoard().getspace(xpos, ypos).piece.charSymbol.equalsIgnoreCase("[Q]") || game.getBoard().getspace(xpos, ypos).piece.charSymbol.equalsIgnoreCase("[q]")) {
            game.getBoard().getspace(xpos, ypos).piece.Queenmove(xpos, ypos, game.getBoard(), selectedSpace);
            gameRepository.save(game);
        }else if(game.getBoard().getspace(xpos, ypos).piece.charSymbol.equalsIgnoreCase("[K]") || game.getBoard().getspace(xpos, ypos).piece.charSymbol.equalsIgnoreCase("[k]")) {
            game.getBoard().getspace(xpos, ypos).piece.Kingmove(xpos, ypos, game.getBoard(), selectedSpace);
            gameRepository.save(game);
        }else if(game.getBoard().getspace(xpos, ypos).piece.charSymbol.equalsIgnoreCase("[N]") || game.getBoard().getspace(xpos, ypos).piece.charSymbol.equalsIgnoreCase("[n]")) {
            game.getBoard().getspace(xpos, ypos).piece.Knightmove(xpos, ypos, game.getBoard(), selectedSpace);
            gameRepository.save(game);
        }else{
                    System.out.println("Error");
                }
    }
}
