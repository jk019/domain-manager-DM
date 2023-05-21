package ch.zhaw.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.repositories.DomainRepository;
import ch.zhaw.springboot.entities.Domain;

@RestController
@CrossOrigin(origins = "http://localhost:8081") 
public class DomainRestController {
    @Autowired
    private DomainRepository repository;

    // get all
    @CrossOrigin(origins = "http://localhost:8081") 
    @RequestMapping(value = "domains/all", method = RequestMethod.GET)
    public ResponseEntity<List<Domain>> getDomains() {
        List<Domain> result = this.repository.findAll();

        return new ResponseEntity<List<Domain>>(result, HttpStatus.OK);
    }

    // get value via ID
    @RequestMapping(value = "domains/{id}", method = RequestMethod.GET)
    public ResponseEntity<Domain> getById(@PathVariable("id") Long id) {
        // Suche nach Eintrag mit der angegebenen ID
        Optional<Domain> result = this.repository.findById(id);
        if (result.isPresent()) {
            // Wenn Eintrag gefunden wurde, gebe ihn zurück
            return new ResponseEntity<Domain>(result.get(), HttpStatus.OK);
        } else {
            // Wenn kein Eintrag gefunden wurde, gebe 404 zurück
            return new ResponseEntity<Domain>(HttpStatus.NOT_FOUND);
        }
    }

    // get all from a specific id upwards
    @RequestMapping(value = "domains/min_id/{min}", method = RequestMethod.GET)
    public ResponseEntity<List<Domain>> getIdGreaterThan(@PathVariable("min") double min) {
        List<Domain> result = this.repository.findByIdGreaterThan(min);
        return new ResponseEntity<List<Domain>>(result, HttpStatus.OK); // http-status mitgeben
    }

    // delete an entry via ID
    @RequestMapping(value = "domains/del/{id}", method = RequestMethod.DELETE)
    void deleteDomainById(@PathVariable("id") long id) {
        repository.deleteById(id);
    }

    // delete an entry via ID (gives an exception, if ID does not)
    @RequestMapping(value = "domains/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteDomain(@PathVariable("id") Long id) {
        Domain domain = this.repository.findById(id).orElse(null);
        if (domain == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        this.repository.delete(domain);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // update an entry via ID
    @PutMapping("domains/update/{id}")
    public Domain updateDomain(@PathVariable("id") Long id, @RequestBody Domain updatedEntity) {
        Domain entity = repository.findById(id).get();
        entity.setName(updatedEntity.getName());
        entity.setIp(updatedEntity.getIP());
        return repository.save(entity);
    }

    // Create
    @PostMapping("/domains/create")
    public Domain createEntity(@RequestBody Domain newEntity) {
        // Find the highest existing ID
        List<Domain> allEntities = repository.findAll();
        Long highestId = allEntities.stream()
                .mapToLong(Domain::getId)
                .max()
                .orElse(0);
        // Set the ID of the new entity to be one higher than the highest existing ID
        newEntity.setId(highestId + 1);
        return repository.save(newEntity);
    }
}
