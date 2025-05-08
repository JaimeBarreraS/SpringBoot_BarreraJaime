package com.taller.taller.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "road_paths")
@Getter
@Setter
public class RoadPaths {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private boolean isactive;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String image_path;

    @OneToMany(mappedBy = "roadPath", cascade = CascadeType.ALL)
    private List<SkillRoutPath> roadPathSkills = new ArrayList<>();


    @Column(nullable = false)
    private String path_name;

    @Column(nullable = false)   
    private String description;

    public RoadPaths() {}

    public RoadPaths(Long id, boolean isactive, Timestamp created_at, Timestamp updated_at, String image_path,
            String path_name, String description) {
        this.id = id;
        this.isactive = isactive;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.image_path = image_path;
        this.path_name = path_name;
        this.description = description;
    }

}
