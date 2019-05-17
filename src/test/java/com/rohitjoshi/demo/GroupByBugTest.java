package com.rohitjoshi.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class GroupByBugTest {

    @Autowired
    private DemoRepository demoRepository;

    @Test
    public void groupByBugTest() {
        for (int i = 0; i < 5; i++) {
            DemoEntity demoEntity = new DemoEntity();
            demoEntity.id = String.valueOf(i);
            demoEntity.testColumn = "test";
            demoRepository.save(demoEntity);
        }

        Page<Object[]> result = demoRepository.testGroupByQuery(PageRequest.of(0, 1));
        assertEquals(result.getTotalElements(), 1);
        assertEquals(result.getTotalPages(), 1);
    }
}
