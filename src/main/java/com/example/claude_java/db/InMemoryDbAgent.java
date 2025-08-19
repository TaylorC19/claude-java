package com.example.claude_java.db;

import com.example.claude_java.model.FormSubmission;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryDbAgent implements DbAgent {
    
    private final List<FormSubmission> submissions = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    
    @Override
    public FormSubmission save(FormSubmission submission) {
        if (submission.getId() == null) {
            submission.setId(idGenerator.getAndIncrement());
            submissions.add(submission);
        } else {
            update(submission);
        }
        return submission;
    }
    
    @Override
    public List<FormSubmission> findAll() {
        return new ArrayList<>(submissions);
    }
    
    @Override
    public Optional<FormSubmission> findById(Long id) {
        return submissions.stream()
                .filter(submission -> submission.getId().equals(id))
                .findFirst();
    }
    
    @Override
    public void deleteById(Long id) {
        submissions.removeIf(submission -> submission.getId().equals(id));
    }
    
    @Override
    public FormSubmission update(FormSubmission submission) {
        Optional<FormSubmission> existing = findById(submission.getId());
        if (existing.isPresent()) {
            FormSubmission existingSubmission = existing.get();
            existingSubmission.setName(submission.getName());
            existingSubmission.setEmail(submission.getEmail());
            existingSubmission.setMessage(submission.getMessage());
            existingSubmission.setSubmittedAt(submission.getSubmittedAt());
            return existingSubmission;
        }
        return submission;
    }
    
    @Override
    public int count() {
        return submissions.size();
    }
}