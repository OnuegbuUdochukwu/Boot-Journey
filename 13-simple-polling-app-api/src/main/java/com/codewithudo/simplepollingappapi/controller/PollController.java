package com.codewithudo.simplepollingappapi.controller;

import com.codewithudo.simplepollingappapi.model.Poll;
import com.codewithudo.simplepollingappapi.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/poll")
public class PollController {

    @Autowired
    private PollService pollService;

    @PostMapping
    public ResponseEntity<Poll> createPoll(@RequestBody Poll poll) {
        Poll createdPoll = pollService.addPoll(poll);
        return new ResponseEntity<>(createdPoll, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Poll>> getAllPolls() {
        return new ResponseEntity<>(pollService.getAllPolls(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPollById(@PathVariable int id) {
        Poll poll = pollService.getPollById(id);
        if (poll != null) {
            return new ResponseEntity<>(poll, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/{id}/votes")
    public void vote(@PathVariable int id) {

    }
}
