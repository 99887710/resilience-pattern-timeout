package jw.rating.service;

import jw.model.dto.ProductRatingDTO;
import jw.model.dto.ReviewsDTO;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class RatingServiceImpl implements RatingService {

    Map<Integer, ProductRatingDTO> map = new HashMap<>();

    @PostConstruct
    public void init(){
        //init dummy reviewDTO objects
        ReviewsDTO review1 = ReviewsDTO.builder()
                .productId(1)
                .userFirstname("Kevin")
                .userLastname("Durant")
                .rating(3)
                .comment("nice product").build();
        ProductRatingDTO productRatingDTO1 = ProductRatingDTO.builder()
                .reviews(Arrays.asList(review1)).build();
        
        ReviewsDTO review2 = ReviewsDTO.builder()
                .productId(2)
                .userFirstname("Theresa")
                .userLastname("May")
                .rating(5)
                .comment("fancy product").build();
        ProductRatingDTO productRatingDTO2 = ProductRatingDTO.builder()
                .reviews(Arrays.asList(review2)).build();

        map.put(1, productRatingDTO1);
        map.put(2, productRatingDTO2);
    }

    @Override
    public ProductRatingDTO getProductRating(int productId) {

        return map.getOrDefault(productId, ProductRatingDTO.builder().build());
    }

    private ReviewsDTO createProductReview(int productId, String firstName, String lastName, int rating, String comment) {
        return ReviewsDTO.builder()
                .productId(productId)
                .userFirstname(firstName)
                .userLastname(lastName)
                .rating(rating)
                .comment(comment).build();
    }
}
