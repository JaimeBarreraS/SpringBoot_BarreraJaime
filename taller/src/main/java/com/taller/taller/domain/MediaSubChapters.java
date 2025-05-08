package com.taller.taller.domain;

import java.sql.Timestamp;

import com.taller.taller.domain.PrimaryKey.MediaTypesId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "media_sub_chapters")
@Getter
@Setter
public class MediaSubChapters {

    @EmbeddedId
    private MediaTypesId id;

    @ManyToOne
    @MapsId("mediaType")
    @JoinColumn(name = "media_id", nullable = false)
    private MediaTypes mediaType;

    @ManyToOne
    @MapsId("subChapter")
    @JoinColumn(name = "subchapter_id", nullable = false)
    private SubChapters subChapter;

    private Timestamp created_at;
    private Timestamp updated_at;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String summary;

    public MediaSubChapters() {
    }

    public MediaSubChapters(MediaTypesId id, MediaTypes mediaType, SubChapters subChapter, Timestamp created_at,
            Timestamp updated_at, String description, String summary) {
        this.id = id;
        this.mediaType = mediaType;
        this.subChapter = subChapter;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.description = description;
        this.summary = summary;
    }
}
