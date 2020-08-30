package com.moviecatalog.moviecatalogservice.controller;



import com.moviecatalog.moviecatalogservice.model.Rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
@EnableResourceServer
public class HomeController {
    
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/showmovies")
    public Object[] showAllMovies(){
        
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/movieservice/allmovies", Object[].class);
        Object[] objects = responseEntity.getBody();
        return objects;
    }
 
    @GetMapping("/showratedmovie/{userId}")
    public Object[] showAllRatedMovies(@PathVariable String userId){
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:9091/ratingservice/allratings/" + userId, Object[].class);
        Object[] objects = responseEntity.getBody();
        return objects;
    }

    @PostMapping("/ratemovie")
    public String rateMovies(@RequestBody String rating){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(rating,headers);
        ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:9091/ratingservice/addrating",entity,String.class);
        String objects = result.getBody();
        return objects;
    }
}