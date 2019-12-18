package jw.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProductRatingDTO {

    private double avgRating;
    private List<ReviewsDTO> reviews;

    public ProductRatingDTO() {
        this.avgRating = 0;
        this.reviews = Collections.emptyList();
    }

    public double getAvgRating() {
        return avgRating;
    }

    public List<ReviewsDTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewsDTO> reviews) {
        this.reviews = reviews;
        this.avgRating = reviews
                            .stream()
                            .mapToInt(ReviewsDTO::getRating)
                            .average()
                            .orElse(0);
    }
}
