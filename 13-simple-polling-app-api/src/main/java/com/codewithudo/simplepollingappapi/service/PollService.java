package com.codewithudo.simplepollingappapi.service;

import com.codewithudo.simplepollingappapi.model.Option;
import com.codewithudo.simplepollingappapi.model.Poll;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PollService {
    private final List<Poll> polls = new ArrayList<>();
    private int nextPollId = 1;
    private int nextOptionId = 1;

    public List<Poll> getAllPolls() {
        return polls;
    }

    public Poll getPollById(int id) {
        for (Poll poll : polls) {
            if (poll.getId() == id) {
                return poll;
            }
        }
        return null;
    }

    public Poll createPoll(Poll poll) {
        poll.setId(nextPollId++);
        for (Option option : poll.getOptions()) {
            option.setId(nextOptionId++);
            option.setVotes(0);
        }
        polls.add(poll);
        return poll;
    }

    public boolean vote(int pollId, int optionId) {
        Poll poll = getPollById(pollId);
        if (poll != null) {
            for (Option option : poll.getOptions()) {
                if (option.getId() == optionId) {
                    option.setVotes(option.getVotes() + 1);
                    return true;
                }
            }
        }
        return false;
    }
}
