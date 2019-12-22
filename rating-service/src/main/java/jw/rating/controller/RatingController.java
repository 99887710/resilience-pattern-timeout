package jw.rating.controller;

import jw.model.dto.ProductRatingDTO;
import jw.rating.service.RatingService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("v1")
@Slf4j
public class RatingController {

    public static final int MIN = 10;
    public static final int MAX = 5000;
    @Autowired
    RatingService ratingService;

    @GetMapping("/ratings/{productId}")
    public ProductRatingDTO getRating(@PathVariable int productId) throws InterruptedException{
        int processTime = ThreadLocalRandom.current().nextInt(MIN, MAX);
        log.info("This request will be completed in {} ms", processTime);
        Thread.sleep(processTime);
        return ratingService.getProductRating(productId);
    }

}
