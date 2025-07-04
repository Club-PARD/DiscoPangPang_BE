package com.pard.server.discoPangPang_BE.label.repo;


import com.pard.server.discoPangPang_BE.label.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface LabelRepo extends JpaRepository<Label, Long> {
    Optional<Label> findByLabelNameAndLabelCategory(String tagName, String tagCategory);
}
