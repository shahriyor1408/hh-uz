package com.company.hhuz.services.resume;

import com.company.hhuz.dtos.resume.ResumeCreateDto;
import com.company.hhuz.dtos.resume.ResumeDetails;
import com.company.hhuz.dtos.resume.ResumeUpdateDto;
import com.company.hhuz.repositories.ResumeRepository;
import com.company.hhuz.services.base.BaseService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeService implements BaseService {

    private final ResumeRepository repository;

    public ResponseEntity<Long> create(@Valid ResumeCreateDto dto) {
        return null;
    }

    public ResponseEntity<ResumeDetails> get(@NonNull Long id) {
        return null;
    }

    public ResponseEntity<List<ResumeDetails>> getAll(@NonNull Long userId) {
        return null;
    }

    public ResponseEntity<ResumeDetails> update(ResumeUpdateDto dto) {
        return null;
    }

    public ResponseEntity<Long> delete(Long id) {
        return null;
    }
}
