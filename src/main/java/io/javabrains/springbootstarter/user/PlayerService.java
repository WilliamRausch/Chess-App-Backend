package io.javabrains.springbootstarter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

//    private List<Player> players = new ArrayList<>(Arrays.asList(
//            new Player("1", "bob"),
//                new Player("2", "joe"),
//                new Player("3", "dan")
//        ));
    public List<Player> getAllPlayers(){
        List<Player> players = new ArrayList<>();
        playerRepository.findAll().forEach(players::add);
        return players;
    }
    public Player getPlayer(int id){
       //return players.stream().filter(u -> u.getId().equals(id)).findFirst().get();
         return playerRepository.findOne(id);
    }
    public void addPlayer(Player player){
        playerRepository.save(player);

    }
    public void updatePlayer(Player player, int id){
      playerRepository.save(player) ;
    }
    public void gameOver(int winnerId, int loserId){
        Player winner = playerRepository.findOne(winnerId);
        Player loser = playerRepository.findOne(loserId);
        winner.setWins(winner.getWins()+1) ;
        loser.setLosses(loser.getLosses()+1) ;
        playerRepository.save(winner);
        playerRepository.save(loser);

    }
    public void deletePlayer(int id){
        playerRepository.delete(id);
    }
    public Integer verifyLogin(Player player){
        List<Player> players = new ArrayList<>();
        playerRepository.findAll().forEach(players::add);
        Player playerCheck = new Player(-1,"SHDHHSA","HSDNAJKNJDNJKANS", -5, -5);

        for(int i=0; i<players.size(); i++){
            if(player.getName().equalsIgnoreCase(players.get(i).getName())){
                playerCheck = players.get(i);
            }
        }
        //Player playerCheck = playerRepository.findOne(player.getId());
        System.out.println(playerCheck.getName());
        System.out.println(player.getName());
        if (playerCheck.getName().equalsIgnoreCase( player.getName()) && playerCheck.getPassword().equalsIgnoreCase(player.getPassword())){
            return playerCheck.getId();
        }
        else{
            return -1;
        }
    }
}
