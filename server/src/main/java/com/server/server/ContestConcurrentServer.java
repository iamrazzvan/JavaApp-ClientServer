package com.server.server;

import com.services.IContestServices;
import com.networking.ClientWorker;

import java.net.Socket;

public class ContestConcurrentServer extends ConcurrentServer {
    private final IContestServices contestServer;

    public ContestConcurrentServer(int port, IContestServices contestServer) {
        super(port);
        this.contestServer = contestServer;
    }

    @Override
    protected Thread createWorker(Socket client) {
        ClientWorker worker = new ClientWorker(contestServer, client);
        return new Thread(worker);
    }
}
