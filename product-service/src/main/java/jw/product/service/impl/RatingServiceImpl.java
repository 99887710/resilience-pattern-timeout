package jw.product.service.impl;

import jw.model.dto.ProductRatingDTO;
import jw.product.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.SocketTimeoutException;

@Service
public class RatingServiceImpl implements RatingService {

    @Value("${rating.service.url}")
    private String ratingServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @Retryable(
            value = {SocketTimeoutException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 1000)
    )
    public ProductRatingDTO getRatings(int productId) {
        String url = this.ratingServiceUrl + "/" + productId;
        ProductRatingDTO productRatingDTO = new ProductRatingDTO();
        return this.restTemplate.getForObject(url, ProductRatingDTO.class);
    }

    @Recover
    public ProductRatingDTO getRecoveryRatings() {
        return new ProductRatingDTO();
    }
}
