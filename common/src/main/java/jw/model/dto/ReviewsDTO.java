package jw.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewsDTO {
    private String userFirstname;
    private String userLastname;
    private int rating;
    private int productId;
    private String comment;
}
