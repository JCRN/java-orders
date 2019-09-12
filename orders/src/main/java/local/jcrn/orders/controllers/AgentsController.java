package local.jcrn.orders.controllers;

import local.jcrn.orders.services.AgentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AgentsController
{

    @Autowired
    private AgentsService agentsService;

    @DeleteMapping(value = "/agent/{id}")
    public ResponseEntity<?> deleteUnassignedAgentById(@PathVariable long id) {
        agentsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
