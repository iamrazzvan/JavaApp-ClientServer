import com.persistence.repository.*;
import com.services.IContestServices;
import com.services.ContestServices;
import com.server.exceptions.ServerException;
import com.server.server.ContestConcurrentServer;
import com.server.server.Server;
import com.services.service.*;

import java.io.IOException;
import java.util.Properties;

public class StartServer {
    private static final int DEFAULT_PORT = 25564;

    public static void main(String[] args) {
        Properties serverProperties = new Properties();
        try {
            serverProperties.load(StartServer.class.getResourceAsStream("/server.properties"));
            System.out.println("Server properties set.");
            serverProperties.list(System.out);
        } catch (IOException ioException) {
            System.out.println("Cannot find server.properties.");
            return;
        }

        IContestServices raceServices = initializeServices(serverProperties);
        int serverPort = DEFAULT_PORT;
        try {
            serverPort = Integer.parseInt(serverProperties.getProperty("server.port"));
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Wrong port number: " + numberFormatException.getMessage());
            System.out.println("Using default port " + DEFAULT_PORT);
        }
        System.out.println("Starting server on port:" + serverPort);

        Server server = new ContestConcurrentServer(serverPort, raceServices);
        try {
            server.start();
        } catch (ServerException serverException) {
            System.out.println("Error starting the server: " + serverException.getMessage());
        }
    }

    private static IContestServices initializeServices(Properties serverProperties) {
        IParticipantRepository participantRepository = new ParticipantDBRepository(serverProperties);
        IRaceRepository raceRepository = new RaceDBRepository(serverProperties);
        IRaceEntryRepository raceEntryRepository = new RaceEntryDBRepository(serverProperties, raceRepository, participantRepository);
        IUserRepository userRepository = new UserDBRepository(serverProperties);
        ITeamRepository teamRepository = new TeamDBRepository(serverProperties);

        IUserService userService = new UserService(userRepository);
        IParticipantService participantService = new ParticipantService(participantRepository);
        IRaceService raceService = new RaceService(raceRepository, raceEntryRepository);
        ITeamService teamService = new TeamService(teamRepository);

        return new ContestServices(userService, participantService, raceService, teamService);
    }
}
