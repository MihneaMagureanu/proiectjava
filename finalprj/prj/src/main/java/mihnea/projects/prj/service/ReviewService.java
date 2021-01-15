package mihnea.projects.prj.service;

import mihnea.projects.prj.dto.ReviewDTO;
import mihnea.projects.prj.dto.ReviewOutDTO;
import mihnea.projects.prj.model.Book;
import mihnea.projects.prj.model.Review;
import mihnea.projects.prj.repository.BookRepository;
import mihnea.projects.prj.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    public ReviewService(ReviewRepository reviewRepository, BookRepository bookRepository) {
        this.reviewRepository = reviewRepository;
        this.bookRepository =bookRepository;
    }

    public Long GetCount() {
        return reviewRepository.count();
    }

    public void DeleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public Set<Review> GetAllAuthors() {
        return (Set<Review>) reviewRepository.findAll();
    }

    public ReviewDTO GetReviewById(Long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
            ReviewDTO dto = new ReviewDTO(review);
            return dto;
        } else {
            return new ReviewDTO();
        }
    }

    public void AddReview( ReviewOutDTO dto) {
        Review review = new Review();
        review.setText(dto.getText());
        review.setTitle(dto.getTitle());
        review.setGrade(dto.getGrade());
        //review.setBook(dto.getBook());
        Optional<Book> b = bookRepository.findById(dto.getBook_id());
        if (b.isPresent()) {
            Book book = b.get();
            review.setBook(book);
            reviewRepository.save(review);
        }
        review.setTitle(dto.getTitle());
        review.setGrade(dto.getGrade());
        reviewRepository.save(review);
    }

    public void EditReview(Long id, Review review) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if (optionalReview.isPresent()) {
            Review reviewEdited = optionalReview.get();
            reviewEdited.setGrade(review.getGrade());
            reviewEdited.setTitle(review.getTitle());
            reviewEdited.setText(review.getText());
            reviewEdited.setBook(review.getBook());
            reviewRepository.save(reviewEdited);
        }
    }
}
