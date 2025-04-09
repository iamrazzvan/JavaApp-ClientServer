package com.networking.request;

import com.model.model.Participant;

public class GetParticipantByDataRequest implements Request {
    private final Participant participant;

    public GetParticipantByDataRequest(Participant participant) {
        this.participant = participant;
    }

    public Participant getParticipant() {
        return participant;
    }
}
