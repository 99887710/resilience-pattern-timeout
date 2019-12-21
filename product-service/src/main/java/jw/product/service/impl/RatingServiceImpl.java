package jw.product.service.impl;

import jw.model.dto.ProductRatingDTO;
import jw.product.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RatingServiceImpl implements RatingService {

    @Value("${rating.service.url}")
    private String ratingServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ProductRatingDTO getRatings(int productId) {
        String url = this.ratingServiceUrl + "/" + productId;
        ProductRatingDTO productRatingDTO = new ProductRatingDTO();
        try{
            productRatingDTO = this.restTemplate.getForObject(url, ProductRatingDTO.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return productRatingDTO;
    }
}
