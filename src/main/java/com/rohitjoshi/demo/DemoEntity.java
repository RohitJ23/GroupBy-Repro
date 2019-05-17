package com.rohitjoshi.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "demoEntity")
@Table(name = "demo_entity")
public class DemoEntity {
    @Id
    public String id;

    @Column(name = "test_column")
    public String testColumn;
}
