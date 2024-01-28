package com.example.graphqlpractice.Controller;

import com.example.graphqlpractice.Entity.Player;
import com.example.graphqlpractice.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class RestControllers {


    @Autowired
    PlayerService playerService;
    @QueryMapping
    public List<Player> findAll(){
        return playerService.findAll();
    }
}
