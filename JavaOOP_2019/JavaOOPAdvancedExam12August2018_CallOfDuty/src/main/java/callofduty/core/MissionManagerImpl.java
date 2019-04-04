package callofduty.core;

import callofduty.interfaces.MissionManager;

import java.util.List;

public class MissionManagerImpl implements MissionManager {
    @Override
    public String agent(List<String> arguments) {
        return String.format("Registered Agent - %s:%s",
                arguments.get(2), arguments.get(1));
    }

    @Override
    public String request(List<String> arguments) {
        return String.format("Assigned %s " +
                        "Mission - %s to Agent - %s", arguments.get(0),
                arguments.get(1), arguments.get(2));
    }

    @Override
    public String complete(List<String> arguments) {
        return String.format("Agent - %s:%s has completed all assigned missions.",
                arguments.get(0), arguments.get(1));
    }

    @Override
    public String status(List<String> arguments) {
        return "";
    }

    @Override
    public String over(List<String> arguments) {
        return String.format("Novice Agents: %s\n" +
                        "Master Agents: %s\n" +
                        "Assigned Missions: %s\n" +
                        "Completed Missions: %s\n" +
                        "Total Rating Given: %s\n" +
                        "Total Bounty Given: $%s\n",
                arguments.get(0),
                arguments.get(1),
                arguments.get(2),
                arguments.get(3),
                arguments.get(4),
                arguments.get(5));
    }
}
