package mihnea.projects.prj.controller;

import mihnea.projects.prj.dto.BookDTO;
import mihnea.projects.prj.dto.PublisherDTO;
import mihnea.projects.prj.model.Book;
import mihnea.projects.prj.model.Publisher;
import mihnea.projects.prj.service.BookService;
import mihnea.projects.prj.service.PublisherService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping(value = "/count")
    public Long GetCount() {
        return publisherService.GetCount();
    }

    @GetMapping(value = "/routing")
    public String CheckRoute() {
        return "Working";
    }

    @DeleteMapping(value = "/delete/{id}")
    public void DeleteBook(@PathVariable(value = "id") Long id) {
        publisherService.DeletePublisher(id);
    }

    @GetMapping(value = "/getAll")
    public Set<Publisher> GetAllBooks() {
        return publisherService.GetAllPublishers();
    }

    @GetMapping(value = "/{id}")
    public PublisherDTO GetPublisherById(@PathVariable(value = "id") Long id) {
        return publisherService.GetPublisherById(id);
    }

    @PostMapping(value = "/create")
    public void AddPublisher(@RequestBody Publisher dto) {
        publisherService.AddPublisher(dto);
    }

    @PutMapping(value = "/edit/{id}")
    public void EditPublisher(@PathVariable(value="id") Long id, @RequestBody Publisher dto) {
        publisherService.EditPublisher(id,dto);
    }
}
