package com.walkd.dmzing.service;

import com.walkd.dmzing.domain.Type;
import com.walkd.dmzing.dto.review.PhotoReviewDto;
import com.walkd.dmzing.exception.NotFoundCourseException;
import com.walkd.dmzing.exception.NotFoundUserException;
import com.walkd.dmzing.repository.CourseRepository;
import com.walkd.dmzing.repository.PhotoReviewRepository;
import com.walkd.dmzing.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhotoReviewService {

    private final PhotoReviewRepository photoReviewRepository;

    private final UserRepository userRepository;

    private final CourseRepository courseRepository;

    @Transactional
    public void createPhotoReviewDto(PhotoReviewDto photoReviewDto, String email) {
        photoReviewRepository.save(photoReviewDto
                .toEntity(userRepository.findByEmail(email).orElseThrow(NotFoundUserException::new),
                        courseRepository.findById(photoReviewDto.getCourseId()).orElseThrow(NotFoundCourseException::new)));
    }

    public List<PhotoReviewDto> showPhotoReviewDtos(Long id, Type type) {
        if (id == 0) {
            return photoReviewRepository.findTop30ByCourse_TypeOrderByIdDesc(type)
                    .stream()
                    .map(photoReview -> photoReview.toDto())
                    .collect(Collectors.toList());
        }
        return photoReviewRepository.findTop30ByIdAndCourse_TypeLessThanOrderByIdDesc(id, type)
                .stream()
                .map(photoReview -> photoReview.toDto())
                .collect(Collectors.toList());
    }

}
