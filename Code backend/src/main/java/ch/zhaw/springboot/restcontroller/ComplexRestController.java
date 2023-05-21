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
import ch.zhaw.springboot.entities.Complex;
import ch.zhaw.springboot.repositories.ComplexRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class ComplexRestController {

    @Autowired
    private ComplexRepository repository;

    //get all
    @RequestMapping(value = "complex/all", method = RequestMethod.GET)
    public ResponseEntity<List<Complex>> getComplexs() {
        List<Complex> result = this.repository.findAll();
        return new ResponseEntity<List<Complex>>(result, HttpStatus.OK);
    }

    // get value via ID
    @RequestMapping(value = "complex/{id}", method = RequestMethod.GET)
    public ResponseEntity<Complex> getById(@PathVariable("id") Long id) {
        // Suche nach Eintrag mit der angegebenen ID
        Optional<Complex> result = this.repository.findById(id);
        if (result.isPresent()) {
            // Wenn Eintrag gefunden wurde, gebe ihn zurück
            return new ResponseEntity<Complex>(result.get(), HttpStatus.OK);
        } else {
            // Wenn kein Eintrag gefunden wurde, gebe 404 zurück
            return new ResponseEntity<Complex>(HttpStatus.NOT_FOUND);
        }
    }

    // update an entry via ID
    @PutMapping("complex/update/{id}")
    public Complex updateComplex(@PathVariable("id") Long id, @RequestBody Complex updatedEntity) {
        Complex entity = repository.findById(id).get();
        entity.setType(updatedEntity.getType());
        return repository.save(entity);
    }

    // Create
    @PostMapping("/complex/create")
    public Complex createEntity(@RequestBody Complex newEntity) {
        return repository.save(newEntity);
    }

}
