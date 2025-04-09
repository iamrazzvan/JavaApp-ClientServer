package com.networking.response;

import com.model.model.Participant;

public class ParticipantResponse implements Response {
    private final Participant participant;

    public ParticipantResponse(Participant participant) {
        this.participant = participant;
    }

    public Participant getParticipant() {
        return participant;
    }
}
