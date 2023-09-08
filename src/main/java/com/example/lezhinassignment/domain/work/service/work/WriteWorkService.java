package com.example.lezhinassignment.domain.work.service.work;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.user.service.facade.UserFacade;
import com.example.lezhinassignment.domain.work.presentation.dto.request.WriteWorkRequest;
import com.example.lezhinassignment.domain.work.entity.Work;
import com.example.lezhinassignment.domain.work.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WriteWorkService {

    private final WorkRepository workRepository;
    private final UserFacade userFacade;

    public void writeWork(WriteWorkRequest request) {
        User user = userFacade.currentUser();

        workRepository.save(
                Work.builder()
                        .user(user)
                        .title(request.getTitle())
                        .workType(request.getWorkType())
                        .price(request.getPrice())
                        .build());
    }

}
