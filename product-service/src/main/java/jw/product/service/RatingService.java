package jw.product.service;

import jw.model.dto.ProductRatingDTO;

public interface RatingService {
    ProductRatingDTO getRatings(int productId);
}
