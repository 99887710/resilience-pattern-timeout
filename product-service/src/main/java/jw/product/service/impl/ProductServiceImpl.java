package jw.product.service.impl;

import jw.model.dto.ProductDTO;
import jw.model.dto.ProductRatingDTO;
import jw.product.service.ProductService;
import jw.product.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private Map<Integer, ProductDTO> map;

    @Autowired
    private RatingService ratingService;

    @PostConstruct
    private void init(){
        this.map = new HashMap<>();
        this.map.put(1, this.getProduct(1, "The eminem show", 12.12));
        this.map.put(2, this.getProduct(2, "Blood on the dance floor", 12.45));
    }

    @Override
    public ProductDTO getProduct(int productId) {
        ProductDTO dto = this.map.get(productId);
        ProductRatingDTO productRating = this.ratingService.getRatings(productId);
        dto.setProductRatingDTO(productRating);
        return dto;
    }

    private ProductDTO getProduct(int productId, String description, double price){
        ProductDTO dto = ProductDTO.builder()
                .productId(productId)
                .description(description)
                .price(price).build();
        return dto;
    }
}
