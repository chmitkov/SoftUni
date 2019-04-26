package callofduty.core;

import callofduty.agents.BaseAgent;
import callofduty.agents.MasterAgent;
import callofduty.agents.NoviceAgent;
import callofduty.interfaces.*;
import callofduty.missions.BaseMission;

import java.util.*;
import java.util.function.Function;

public class Engine implements Runnable {

    private InputReader reader;
    private OutputWriter writer;
    private MissionManager manager;
    private MissionControl control;

    private Map<String, BaseMission> allMissions;
    private Map<String, BaseAgent> agentsByIdMap;

    public Engine(InputReader reader, OutputWriter writer,
                  MissionManager manager, MissionControl control) {
        this.reader = reader;
        this.writer = writer;
        this.manager = manager;
        this.control = control;

        this.allMissions = new LinkedHashMap<>();
        this.agentsByIdMap = new HashMap<>();
    }

    @Override
    public void run() {

        String line;
        while (!"Over".endsWith(line = this.reader.readLine())) {
            String[] commands = line.split("\\s+");

            switch (commands[0]) {

                case "Agent":
                    NoviceAgent noviceAgent = new NoviceAgent(commands[1], commands[2], 0D);
                    this.agentsByIdMap.put(noviceAgent.getId(), noviceAgent);
                    this.writer.println(this.manager.agent(Arrays.asList(commands)));
                    break;

                case "Request":
                    BaseMission baseMission = (BaseMission) this.control.generateMission(
                            commands[2], Double.valueOf(commands[3]),
                            Double.valueOf(commands[4])
                    );

                    this.allMissions.put(baseMission.getId(), baseMission);

                    BaseAgent currAgent = this.agentsByIdMap.get(commands[1]);
                    currAgent.acceptMission(baseMission);
                    this.writer.println(this.manager.request(new ArrayList<String>() {{
                        add(getCorrectString(baseMission.getClass()));
                        add(commands[2]);
                        add(currAgent.getName());
                    }}));
                    break;

                case "Status":
                    if (this.allMissions.containsKey(commands[1])) {
                        this.writer.println(
                                getCorrectString(this.allMissions.get(commands[1]).getClass())
                                        + this.allMissions.get(commands[1]).printStatus());
                    } else {
                        this.writer.println(this.agentsByIdMap.get(commands[1]).printStatus());
                    }
                    break;
                case "Complete":
                    BaseAgent agent = this.agentsByIdMap.get(commands[1]);
                    agent.completeMissions();
                    if (agent.getClass().getSimpleName().endsWith("NoviceAgent")
                            && agent.getCompleteMissions().size() >= 3) {
                        this.promoteAgent(agent);
                    }
                    this.writer.println(this.manager.complete(new ArrayList<String>() {{
                        add(agent.getName());
                        add(agent.getId());
                    }}));
                    break;
            }
        }

        int countOfNovice = (int) this.agentsByIdMap.values().stream()
                .filter(x -> x.getClass().getSimpleName().equals("NoviceAgent"))
                .count();
        int countOfMaster = (int) this.agentsByIdMap.values().stream()
                .filter(x -> x.getClass().getSimpleName().equals("MasterAgent"))
                .count();
        int countOfAllMissions = this.allMissions.size();
        int countOfAllCompletedMissions = (int) this.allMissions.values().stream()
                .filter(BaseMission::getStatus)
                .count();
        double totalRatingGiven = this.agentsByIdMap.values().stream()
                .map(BaseAgent::getRating)
                .mapToDouble(Double::valueOf)
                .sum();
        double totalBountyGiven = this.agentsByIdMap.values().stream()
                .filter(x -> x.getClass().getSimpleName().equals("MasterAgent"))
                .map(x -> (MasterAgent) x)
                .map(MasterAgent::getBounty)
                .mapToDouble(Double::valueOf)
                .sum();

        this.writer.println(this.manager.over(new ArrayList<String>() {{
            add(countOfNovice + "");
            add(countOfMaster + "");
            add(countOfAllMissions + "");
            add(countOfAllCompletedMissions + "");
            add(String.format("%.2f", totalRatingGiven));
            add(String.format("%.2f", totalBountyGiven));
        }}));

    }

    private String getCorrectString(Class<? extends BaseMission> aClass) {
        if (aClass.getSimpleName().equals("EscortMission")) {
            return "Escort";
        } else if (aClass.getSimpleName().equals("HuntMission")) {
            return "Hunt";
        } else {
            return "Surveillance";
        }
    }


    private void promoteAgent(BaseAgent agent) {
        MasterAgent masterAgent = new MasterAgent(
                agent.getId(),
                agent.getName(),
                agent.getRating()
        );
        masterAgent.addOldMissions(agent.getCompleteMissions());

        this.agentsByIdMap.remove(agent.getId());
        this.agentsByIdMap.put(masterAgent.getId(), masterAgent);
    }
}
