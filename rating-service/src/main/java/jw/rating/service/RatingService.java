package jw.rating.service;

import jw.model.dto.ProductRatingDTO;

public interface RatingService {

    ProductRatingDTO getProductRating(int productId);
}
