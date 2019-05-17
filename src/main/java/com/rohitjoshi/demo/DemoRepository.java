package com.rohitjoshi.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends PagingAndSortingRepository<DemoEntity, String> {

    @Query("SELECT d.testColumn, COUNT(d.testColumn) FROM demoEntity d GROUP BY d.testColumn")
    Page<Object[]> testGroupByQuery(Pageable pageable);
}
