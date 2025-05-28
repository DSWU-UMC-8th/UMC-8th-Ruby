package umc.study.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;

public interface ReviewQueryService {
    Page<Review> getMyReviews(Long memberId, int page);
}

