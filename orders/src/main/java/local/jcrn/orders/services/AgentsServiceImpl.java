package local.jcrn.orders.services;

import local.jcrn.orders.model.Agents;
import local.jcrn.orders.repos.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "agentsService")
public class AgentsServiceImpl implements AgentsService
{

    @Autowired
    private AgentsRepository agentrepos;

    @Override
    public List<Agents> findAll() {
        List<Agents> list = new ArrayList<>();
        agentrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Agents findAgentById(long id) {
        return null;
    }

    @Override
    public Agents findAgentByName(String name) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Agents save(Agents agents) {
        Agents newAgents = new Agents();

        newAgents.setAgentname(agents.getAgentname());
        newAgents.setCommission(agents.getCommission());
        newAgents.setCountry(agents.getCountry());
        newAgents.setPhone(agents.getPhone());
        newAgents.setWorkingarea(agents.getWorkingarea());

        return agentrepos.save(newAgents);
    }

    @Override
    public Agents update(Agents agents, long id) {
        return null;
    }
}
