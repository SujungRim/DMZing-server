package com.walkd.dmzing.domain;

import com.walkd.dmzing.dto.course.CourseDetailDto;
import com.walkd.dmzing.dto.course.CourseMainDto;
import com.walkd.dmzing.dto.course.PlaceDto;
import com.walkd.dmzing.exception.NotEnoughMoneyException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Course {

    public static final Long DEFAULT_COURSE_ID = 1l;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Type type;

    private String title;

    private String mainDescription;

    private String subDescription;

    private String imageUrl;

    private String lineImageUrl;

    @JoinColumn(name = "course_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Place> places;

    private Level level;

    private Double estimatedTime;

    private Long price;

    @Builder
    public Course(Type type, String title, String mainDescription, String subDescription, String imageUrl, String lineImageUrl, Level level, Double estimatedTime, Long price) {
        this.type = type;
        this.title = title;
        this.mainDescription = mainDescription;
        this.subDescription = subDescription;
        this.imageUrl = imageUrl;
        this.lineImageUrl = lineImageUrl;
        this.level = level;
        this.estimatedTime = estimatedTime;
        this.price = price;
    }

    public CourseMainDto toCourseMainDto(Long pickCount, Boolean isPurchased) {
        return CourseMainDto.builder()
                .id(id)
                .title(type.getTypeName())
                .imageUrl(imageUrl)
                .lineImageUrl(lineImageUrl)
                .mainDescription(mainDescription)
                .subDescription(subDescription)
                .price(price)
                .pickCount(pickCount)
                .isPurchased(isPurchased)
                .build();
    }

    public CourseDetailDto toCourseDetailDto(Long count) {
        return CourseDetailDto.builder()
                .id(id)
                .title(type.getTypeName())
                .imageUrl(imageUrl)
                .lineImageUrl(lineImageUrl)
                .mainDescription(mainDescription)
                .subDescription(subDescription)
                .price(price)
                .level(level.getLevelName())
                .estimatedTime(estimatedTime)
                .places(places.stream().map(place -> place.toPlaceDto().deleteDetailInfo()).collect(Collectors.toList()))
                .reviewCount(count)
                .build();
    }

    public CourseDetailDto toCourseDetailDto(Long count, MissionHistory missionHistory) {
        return CourseDetailDto.builder()
                .id(id)
                .title(type.getTypeName())
                .imageUrl(imageUrl)
                .lineImageUrl(lineImageUrl)
                .mainDescription(mainDescription)
                .subDescription(subDescription)
                .price(price)
                .level(level.getLevelName())
                .estimatedTime(estimatedTime)
                .places(makePlaceList(missionHistory))
                .reviewCount(count)
                .build();
    }

    private List<PlaceDto> makePlaceList(MissionHistory missionHistory) {
        List<Place> sortedPlaces = places.stream().sorted(Comparator.comparing(Place::getSequence)).collect(Collectors.toList());

        if (missionHistory == null)
            return new ArrayList<PlaceDto>(Arrays.asList(sortedPlaces.get(0).toPlaceDto().deleteInfo()));

        Place currentPlace = sortedPlaces.stream()
                .filter(place -> place.equals(missionHistory.getPlace()))
                .collect(Collectors.toList()).get(0);

        return currentPlace.toPlaceDtos(sortedPlaces.stream().map(place -> place.toPlaceDto()).collect(Collectors.toList()));
    }

    public Long isEnoughMoney(Long dp) {
        Long money = dp - price;

        if (money < 0) throw new NotEnoughMoneyException();

        return money;
    }
}
