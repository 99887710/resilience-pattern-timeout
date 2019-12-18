package jw.rating.controller;

import jw.model.dto.ProductRatingDTO;
import jw.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @GetMapping("/ratings/{productId}")
    public ProductRatingDTO getRatin(@PathVariable int productId){
        return ratingService.getProductRating(productId);
    }

}
