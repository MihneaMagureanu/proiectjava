package mihnea.projects.prj.controller;

import mihnea.projects.prj.dto.ReviewDTO;
import mihnea.projects.prj.dto.ReviewOutDTO;
import mihnea.projects.prj.model.Review;
import mihnea.projects.prj.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping(value = "/count")
    public Long GetCount() {
        return reviewService.GetCount();
    }

    @GetMapping(value = "/routing")
    public String CheckRoute() {
        return "Working";
    }

    @GetMapping(value = "/delete/{id}")
    public void DeleteReview(@PathVariable(value = "id") Long id) {
        reviewService.DeleteReview(id);
    }

    @GetMapping(value = "/getAll")
    public Set<Review> GetAllAuthors() {
        return reviewService.GetAllAuthors();
    }

    @GetMapping(value = "/{id}")
    public ReviewDTO GetReviewById(@PathVariable(value = "id") Long id) {
        return reviewService.GetReviewById(id);
    }

    @PostMapping(value = "/create")
    public void AddReview(@RequestBody ReviewOutDTO dto) {
        reviewService.AddReview(dto);
    }

    @PutMapping(value = "/edit/{id}")
    public void EditReview(@PathVariable(value="id") Long id, @RequestBody Review dto) {
        reviewService.EditReview(id,dto);
    }
}
