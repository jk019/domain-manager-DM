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
import ch.zhaw.springboot.entities.Simple;
import ch.zhaw.springboot.repositories.SimpleRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class SimpleRestController {

    @Autowired
    private SimpleRepository repository;

    //get all
    @RequestMapping(value = "simple/all", method = RequestMethod.GET)
    public ResponseEntity<List<Simple>> getSimples() {
        List<Simple> result = this.repository.findAll();
        return new ResponseEntity<List<Simple>>(result, HttpStatus.OK);
    }

    // get value via ID
    @RequestMapping(value = "simple/{id}", method = RequestMethod.GET)
    public ResponseEntity<Simple> getById(@PathVariable("id") Long id) {
        // Suche nach Eintrag mit der angegebenen ID
        Optional<Simple> result = this.repository.findById(id);
        if (result.isPresent()) {
            // Wenn Eintrag gefunden wurde, gebe ihn zurück
            return new ResponseEntity<Simple>(result.get(), HttpStatus.OK);
        } else {
            // Wenn kein Eintrag gefunden wurde, gebe 404 zurück
            return new ResponseEntity<Simple>(HttpStatus.NOT_FOUND);
        }
    }

    // update an entry via ID
    @PutMapping("simple/update/{id}")
    public Simple updateSimple(@PathVariable("id") Long id, @RequestBody Simple updatedEntity) {
        Simple entity = repository.findById(id).get();
        entity.setValue(updatedEntity.getValue());
        return repository.save(entity);
    }

    // Create
    @PostMapping("/simple/create")
    public Simple createEntity(@RequestBody Simple newEntity) {
        return repository.save(newEntity);
    }
}
