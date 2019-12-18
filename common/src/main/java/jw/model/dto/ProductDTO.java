package jw.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDTO {
    private int productId;
    private String description;
    private double price;
    private ProductRatingDTO productRatingDTO;
}
