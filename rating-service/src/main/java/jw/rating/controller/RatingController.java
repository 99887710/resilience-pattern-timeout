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
    public ProductRatingDTO getRating(@PathVariable int productId) throws InterruptedException{
        int processTime = 30 * 1000;
        System.out.println("This request will be completed in 30 secs");
        Thread.sleep(processTime);
        return ratingService.getProductRating(productId);
    }

}
