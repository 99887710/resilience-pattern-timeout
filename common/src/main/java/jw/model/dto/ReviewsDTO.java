package jw.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReviewsDTO {
    private String userFirstname;
    private String userLastname;
    private int rating;
    private int productId;
    private String comment;
}
