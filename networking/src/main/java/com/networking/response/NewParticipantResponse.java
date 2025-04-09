package com.networking.response;

import com.model.model.Participant;

public class NewParticipantResponse implements UpdateResponse {
    private final Participant participant;

    public NewParticipantResponse(Participant participant) {
        this.participant = participant;
    }

    public Participant getParticipant() {
        return participant;
    }
}
