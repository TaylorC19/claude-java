package com.example.claude_java.db;

import com.example.claude_java.model.FormSubmission;
import java.util.List;
import java.util.Optional;

public interface DbAgent {
    
    FormSubmission save(FormSubmission submission);
    
    List<FormSubmission> findAll();
    
    Optional<FormSubmission> findById(Long id);
    
    void deleteById(Long id);
    
    FormSubmission update(FormSubmission submission);
    
    int count();
}