package mihnea.projects.prj.service;

import mihnea.projects.prj.dto.BookDTO;
import mihnea.projects.prj.dto.PublisherDTO;
import mihnea.projects.prj.model.Book;
import mihnea.projects.prj.model.Publisher;
import mihnea.projects.prj.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Long GetCount() {
        return publisherRepository.count();
    }

    public void DeletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }

    public Set<Publisher> GetAllPublishers() {
        return (Set<Publisher>) publisherRepository.findAll();
    }

    public PublisherDTO GetPublisherById(Long id) {
        Optional<Publisher> optionalPublisher = publisherRepository.findById(id);
        if (optionalPublisher.isPresent()) {
            Publisher publisher = optionalPublisher.get();
            PublisherDTO dto = new PublisherDTO(publisher);
            return dto;
        } else {
            return new PublisherDTO();
        }
    }

    public void AddPublisher(Publisher dto) {
        Publisher publisher = new Publisher();
        publisher.setAddressLine1(dto.getAddressLine1());
        publisher.setCity(dto.getCity());
        publisher.setName(dto.getName());
        publisher.setState(dto.getState());
        publisher.setZip(dto.getZip());
        publisher.setBooks(new HashSet<>());
        publisherRepository.save(publisher);
    }

    public void EditPublisher(Long id, Publisher publisher) {
        Optional<Publisher> optionalPublisher = publisherRepository.findById(id);
        if (optionalPublisher.isPresent()) {
            Publisher publisherEdited = optionalPublisher.get();
            publisherEdited.setName(publisher.getName());
            publisherEdited.setAddressLine1(publisher.getAddressLine1());
            publisherEdited.setCity(publisher.getCity());
            publisherEdited.setState(publisher.getState());
            publisherEdited.setZip(publisher.getZip());
            publisherEdited.setBooks(publisher.getBooks());
            publisherRepository.save(publisherEdited);
        }
    }


}
