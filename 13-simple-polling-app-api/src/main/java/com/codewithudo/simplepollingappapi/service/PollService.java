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

    // Add a new poll
    public Poll addPoll(Poll poll) {
        poll.setId(nextPollId++);
        for (Option option : poll.getOptions()) {
            option.setId(nextOptionId++);
            option.setVotes(0);
        }
        polls.add(poll);
        return poll;
    }

    // Get all polls
    public List<Poll> getAllPolls() {
        return polls;
    }

    // Get a poll by ID
    public Poll getPollById(int id) {
        for (Poll poll : polls) {
            if (poll.getId() == id) {
                return poll;
            }
        }
        return null;
    }


    // Vote for an option by poll ID and option ID
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

    // Delete a poll
    public boolean deletePollById(int id) {
        return polls.removeIf(poll -> poll.getId() == id);
    }
}
