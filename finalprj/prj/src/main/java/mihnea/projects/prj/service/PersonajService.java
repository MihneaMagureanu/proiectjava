package mihnea.projects.prj.service;

import mihnea.projects.prj.dto.PersonajDTO;
import mihnea.projects.prj.dto.PersonajOutDTO;
import mihnea.projects.prj.model.Book;
import mihnea.projects.prj.model.Personaj;
import mihnea.projects.prj.repository.BookRepository;
import mihnea.projects.prj.repository.PersonajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonajService {

    private final PersonajRepository personajRepository;
    private final BookRepository bookRepository;

    @Autowired
    public PersonajService(PersonajRepository personajRepository, BookRepository bookRepository) {
        this.personajRepository = personajRepository;
        this.bookRepository = bookRepository;
    }

    public Long GetCount() {
        return personajRepository.count();
    }

    public void DeletePersonaj(Long id) {
        personajRepository.deleteById(id);
    }

    public Set<Personaj> GetAllPersonaje() {
        return (Set<Personaj>) personajRepository.findAll();
    }

    public PersonajDTO GetPersonajById(Long id) {
        Optional<Personaj> optionalPersonaj = personajRepository.findById(id);
        if (optionalPersonaj.isPresent()) {
            Personaj personaj = optionalPersonaj.get();
            PersonajDTO dto = new PersonajDTO(personaj);
            return dto;
        } else {
            return new PersonajDTO();
        }
    }

    public void AddPersonaj( PersonajOutDTO dto) {
        Personaj personaj = new Personaj();
        Optional<Book> b = bookRepository.findById(dto.getBook());
        if (b.isPresent()) {
            Book book = b.get();
            personaj.setBook(book);
            personaj.setName(dto.getName());
            personajRepository.save(personaj);
        }

    }

    public void EditPersonaj(Long id, Personaj personaj) {
        Optional<Personaj> optionalPersonaj = personajRepository.findById(id);
        if (optionalPersonaj.isPresent()) {
            Personaj personajEdited = optionalPersonaj.get();
            personajEdited.setName(personaj.getName());
            personajEdited.setBook(personaj.getBook());
            personajRepository.save(personajEdited);
        }
    }

    /*public List<PersonajDTO> GetPersonajByBookId(Long book_id) {
        List<Personaj> personajList = personajRepository.FindByBookId(book_id);
        List<PersonajDTO> personajDTOList = new ArrayList<>();
        for (Personaj p : personajList) {
            personajDTOList.add(new PersonajDTO(p));
        }

        return personajDTOList;
    }*/

}
