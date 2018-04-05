package io.javabrains.springbootstarter.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping("/Players")
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }
    @RequestMapping("/Players/{id}")
    public Player getPlayer(@PathVariable int id){
        return playerService.getPlayer(id);
    }
    @RequestMapping(method= RequestMethod.POST, value="/Players")
    public void addPlayer(@RequestBody Player player){
        playerService.addPlayer(player);

    }
    @RequestMapping(method= RequestMethod.PUT, value="/Players/{id}")
    public void updatePlayer(@RequestBody Player player, @PathVariable int id){
        playerService.updatePlayer(player, id);

    }
    @RequestMapping(method= RequestMethod.DELETE, value="/Players/{id}")
    public void deletePlayer( @PathVariable int id){
        playerService.deletePlayer(id);

    }
    @RequestMapping(method = RequestMethod.POST, value= "/login")
    public Integer verifyLogin(@RequestBody Player player){
       return playerService.verifyLogin(player);
    }
}
