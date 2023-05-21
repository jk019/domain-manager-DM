package ch.zhaw.springboot.restcontroller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Document;
import ch.zhaw.springboot.repositories.DocumentRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class DocumentRestController {
    @Autowired
    private DocumentRepository repository;

    // get all
    @RequestMapping(value = "document/all", method = RequestMethod.GET)
    public ResponseEntity<List<Document>> getDocuments() {
        List<Document> result = this.repository.findAll();
        return new ResponseEntity<List<Document>>(result, HttpStatus.OK);
    }

    // get value via ID
    @RequestMapping(value = "document/{id}", method = RequestMethod.GET)
    public ResponseEntity<Document> getById(@PathVariable("id") Long id) {
        // Suche nach Eintrag mit der angegebenen ID
        Optional<Document> result = this.repository.findById(id);
        if (result.isPresent()) {
            // Wenn Eintrag gefunden wurde, gebe ihn zurück
            return new ResponseEntity<Document>(result.get(), HttpStatus.OK);
        } else {
            // Wenn kein Eintrag gefunden wurde, gebe 404 zurück
            return new ResponseEntity<Document>(HttpStatus.NOT_FOUND);
        }
    }

    // Create
    @PostMapping("/document/create")
    public Document createEntity(@RequestBody Document newEntity) {
        return repository.save(newEntity);
    }

    // delete an entry via ID (gives an exception, if ID does not)
    @RequestMapping(value = "Documents/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteDocument(@PathVariable("id") Long id) {
        Document Document = this.repository.findById(id).orElse(null);
        if (Document == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        this.repository.delete(Document);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // update an entry via ID
    @PutMapping("documents/update/{id}")
    public Document updateDocument(@PathVariable("id") Long id, @RequestBody Document updatedEntity) {
        Document entity = repository.findById(id).get();
        entity.setId(updatedEntity.getId());
        entity.setCreation_date(updatedEntity.getCreation_date());
        entity.setDomain(updatedEntity.getDomain());
        entity.setElement(updatedEntity.getElement());
        return repository.save(entity);
    }
}
