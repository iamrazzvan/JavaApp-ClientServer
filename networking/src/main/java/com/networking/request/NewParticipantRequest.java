package com.networking.request;

import com.model.model.Participant;

public class NewParticipantRequest {
    private final Participant participant;

    public NewParticipantRequest(Participant participant) {
        this.participant = participant;
    }

    public Participant getParticipant() {
        return participant;
    }
}
