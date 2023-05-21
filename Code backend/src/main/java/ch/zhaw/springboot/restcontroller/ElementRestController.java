package ch.zhaw.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ch.zhaw.springboot.entities.Element;
import ch.zhaw.springboot.repositories.ElementRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class ElementRestController {

    @Autowired
    private ElementRepository repository;

    // get all
    @RequestMapping(value = "elements/all", method = RequestMethod.GET)
    public ResponseEntity<List<Element>> getElements() {
        List<Element> result = this.repository.findAll();
        return new ResponseEntity<List<Element>>(result, HttpStatus.OK);
    }

    // get value via ID
    @RequestMapping(value = "elements/{id}", method = RequestMethod.GET)
    public ResponseEntity<Element> getById(@PathVariable("id") Long id) {
        // Suche nach Eintrag mit der angegebenen ID
        Optional<Element> result = this.repository.findById(id);
        if (result.isPresent()) {
            // Wenn Eintrag gefunden wurde, gebe ihn zurück
            return new ResponseEntity<Element>(result.get(), HttpStatus.OK);
        } else {
            // Wenn kein Eintrag gefunden wurde, gebe 404 zurück
            return new ResponseEntity<Element>(HttpStatus.NOT_FOUND);
        }
    }

    // update an entry via ID
    @PutMapping("element/update/{id}")
    public Element updateElement(@PathVariable("id") Long id, @RequestBody Element updatedEntity) {
        Element entity = repository.findById(id).get();
        entity.setName(updatedEntity.getName());
        entity.setParent(updatedEntity.getParent());
        return repository.save(entity);
    }

    // delete an entry via ID (gives an exception, if ID does not)
    @RequestMapping(value = "element/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteElement(@PathVariable("id") Long id) {
        Element Element = this.repository.findById(id).orElse(null);
        if (Element == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        this.repository.delete(Element);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // find Element by Name
    @GetMapping("/elements/name/{name}")
    public List<Element> getElementsByName(@PathVariable String name) {
        return repository.findAllByName(name);
    }
}
