package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//Caminho de acesso a API no Navegador
@RequestMapping("/api/v1/people")
public class PersonController {

    private  PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //Function Created new Person
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    //Function List All Persons
    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    //Function Search Person by ID
    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

   /* private PersonService personService;



    @GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }*/
}
