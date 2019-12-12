package jw.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private int productId;
    private String description;
    private double price;
    private ProductRatingDTO productRatingDTO;
}
