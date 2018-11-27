package com.walkd.dmzing.dto.review;

import com.walkd.dmzing.domain.Type;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewCountDto {

    @ApiModelProperty(example = "history", position = 1)
    private String typeName;

    @ApiModelProperty(example = "312", position = 2)
    private Long conut;

    @ApiModelProperty(example = "dmzing.png", position = 3)
    private String imageUrl;

    @ApiModelProperty(example = "1", position = 4)
    private Long courseId;

    @ApiModelProperty(example = "DATE", position = 5)
    private Type type;
}
