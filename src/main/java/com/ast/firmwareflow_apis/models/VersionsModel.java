package com.ast.firmwareflow_apis.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "versions")
public class VersionsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "project", referencedColumnName = "id", nullable = false)
    private ProjectsModel projectsModel;

}
