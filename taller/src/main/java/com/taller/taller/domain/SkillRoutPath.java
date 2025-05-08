package com.taller.taller.domain;


import java.sql.Timestamp;

import com.taller.taller.domain.PrimaryKey.RoadPathSkillId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Skill_rout_path")
@Getter
@Setter
public class SkillRoutPath {

    @EmbeddedId
    private RoadPathSkillId id;

    @ManyToOne
    @MapsId("roadPath")  
    @JoinColumn(name = "road_path_id",nullable = false)
    private RoadPaths roadPath;

    @ManyToOne
    @MapsId("skill")     
    @JoinColumn(name = "skill_id",nullable = false)
    private Skills skill;

    private Timestamp created_at;
    private Timestamp updated_at;

    public SkillRoutPath() {}

    public SkillRoutPath(RoadPathSkillId id, RoadPaths roadPath, Skills skill, Timestamp created_at,
            Timestamp updated_at) {
        this.id = id;
        this.roadPath = roadPath;
        this.skill = skill;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

}
