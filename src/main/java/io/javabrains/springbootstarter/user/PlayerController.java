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
    public Player getPlayer(@PathVariable String id){
        return playerService.getPlayer(id);
    }
    @RequestMapping(method= RequestMethod.POST, value="/Players")
    public void addPlayer(@RequestBody Player player){
        playerService.addPlayer(player);

    }
    @RequestMapping(method= RequestMethod.PUT, value="/Players/{id}")
    public void updatePlayer(@RequestBody Player player, @PathVariable String id){
        playerService.updatePlayer(player, id);

    }
    @RequestMapping(method= RequestMethod.DELETE, value="/Players/{id}")
    public void deletePlayer( @PathVariable String id){
        playerService.deletePlayer(id);

    }
}
