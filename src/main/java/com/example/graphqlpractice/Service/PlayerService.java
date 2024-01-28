package com.example.graphqlpractice.Service;

import com.example.graphqlpractice.Entity.Player;
import com.example.graphqlpractice.Entity.Teams;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PlayerService
{
    private List<Player> players = new ArrayList<>();
     AtomicInteger id = new AtomicInteger(0);

     public List<Player> findAll(){
         return  players;
     }

     public Optional<Player> findOne(Integer id){
         return players.stream().filter(player -> Objects.equals(player.Id(), id)).findFirst();
     }

     public Player create(String name , Teams teams){
         Player player =new Player(id.incrementAndGet(),name,teams);
         players.add(player);
         return player;
     }

     public Player delete(Integer id){
         Player player= players.stream().filter(c -> c.Id()== id).findFirst().orElseThrow(()-> new IllegalArgumentException("Not Found"));
         players.remove(player);
         return player;
     }

    public Player update(Integer id,String Name,Teams teams){
         Player Uplayer = new Player(id,Name,teams);

         if(findOne(id).isPresent()){
             Player player = findOne(id).get();
             int index= players.indexOf(player);
             players.set(index,Uplayer);

         }else{
             throw  new IllegalArgumentException("Invalid Update");
         }

        return Uplayer;

     }


     @PostConstruct
    private void init(){
         players.add(new Player(id.incrementAndGet(),"dhoni",Teams.csk));
         players.add(new Player(id.incrementAndGet(),"kohli",Teams.RCB));
         players.add(new Player(id.incrementAndGet(),"shardul",Teams.mi));
         players.add(new Player(id.incrementAndGet(),"jadeja",Teams.lkw));
         players.add(new Player(id.incrementAndGet(),"hardik",Teams.GSG));
         players.add(new Player(id.incrementAndGet(),"rohit",Teams.mi));

     }


}

