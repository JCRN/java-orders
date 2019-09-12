package local.jcrn.orders.services;

import local.jcrn.orders.model.Agents;

import java.util.List;

public interface AgentsService
{

    List<Agents> findAll();

    Agents findAgentById(long id);

    Agents findAgentByName(String name);

    void delete(long id);

    Agents save(Agents agents);

    Agents update(Agents agents, long id);
}
