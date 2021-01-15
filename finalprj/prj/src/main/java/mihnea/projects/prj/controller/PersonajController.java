package mihnea.projects.prj.controller;

import mihnea.projects.prj.dto.PersonajDTO;
import mihnea.projects.prj.dto.PersonajOutDTO;
import mihnea.projects.prj.model.Personaj;
import mihnea.projects.prj.service.PersonajService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/personaj")
public class PersonajController {

    private final PersonajService personajService;

    public PersonajController(PersonajService personajService) {
        this.personajService = personajService;
    }

    @GetMapping(value = "/count")
    public Long GetCount() {
        return personajService.GetCount();
    }

    @GetMapping(value = "/routing")
    public String CheckRoute() {
        return "Working";
    }

    @GetMapping(value = "/delete/{id}")
    public void DeletePersonaj(@PathVariable(value = "id") Long id) {
        personajService.DeletePersonaj(id);
    }

    @GetMapping(value = "/getAll")
    public Set<Personaj> GetAllPersonaje() {
        return personajService.GetAllPersonaje();
    }

    @GetMapping(value = "/{id}")
    public PersonajDTO GetPersonajById(@PathVariable(value = "id") Long id) {
        return personajService.GetPersonajById(id);
    }

    @PostMapping(value = "/create")
    public void AddPersonaj(@RequestBody PersonajOutDTO dto) {
        personajService.AddPersonaj(dto);
    }

    @PutMapping(value = "/edit/{id}")
    public void EditAuthor(@PathVariable(value="id") Long id, @RequestBody Personaj dto) {
        personajService.EditPersonaj(id,dto);
    }

    /*@GetMapping(value ="/book/{id}")
    public List<PersonajDTO>  GetAllByBookId(@PathVariable(value= "id") Long id) {
        return personajService.GetPersonajByBookId(id);
    }*/
}
