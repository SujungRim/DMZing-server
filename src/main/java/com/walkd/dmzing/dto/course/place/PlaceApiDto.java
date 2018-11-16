package com.walkd.dmzing.dto.course.place;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.walkd.dmzing.config.CommonConfig;
import com.walkd.dmzing.domain.Place;
import lombok.Builder;
import lombok.Getter;

import java.net.URI;

@Getter
@Builder
public class PlaceApiDto {
    public static final String URI = new StringBuilder().append("http://api.visitkorea.or.kr/openapi/service/rest")
            .append("/KorService/detailCommon?ServiceKey=%s")
            .append("&contentTypeId=%d&contentId=%d&MobileOS=")
            .append("AND&MobileApp=TourAPI3.0_Guide&defaultYN=Y&firstImageYN=Y")
            .append("&areacodeYN=Y&catcodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y&transGuideYN=Y&_type=json").toString();

    public static final String NEARPLACE_URI = new StringBuilder()
            .append("http://api.visitkorea.or.kr/openapi/service/rest/KorService/locationBasedList?ServiceKey=%s")
            .append("&contentTypeId=%d&mapX=%s&mapY=%s&radius=10000&listYN=Y")
            .append("&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=A&numOfRows=1&pageNo=1&_type=json").toString();

    private String firstimage;
    private String firstimage2;
    private String title;
    private Double mapx;
    private Double mapy;
    private String overview;
    private String addr1;

    public static PlaceApiDto createDto(JsonElement jsonElement, Gson gson){
        return gson.fromJson(CommonConfig.getJsonString(jsonElement), PlaceApiDto.class);
    }

    public Place toEntity(PlaceInfoApiDto placeInfoApiDto,PlaceSubDto placeSubDto){
        return Place.builder()
                .title(title)
                .mainImageUrl(firstimage)
                .subImageUrl(firstimage2)
                .latitude(mapx)
                .longitude(mapy)
                .description(overview.replace("<br>",""))
                .address(addr1)
                .parking(placeInfoApiDto.getParkingculture())
                .infoCenter(placeInfoApiDto.getInfocenterculture())
                .restDate(placeInfoApiDto.getRestdateculture())
                .letterImageUrl(placeSubDto.getLetterImageUrl())
                .hint(placeSubDto.getHint())
                .sequence(placeSubDto.getSequence())
                .reward(placeSubDto.getReward())
                .build();
    }
}
