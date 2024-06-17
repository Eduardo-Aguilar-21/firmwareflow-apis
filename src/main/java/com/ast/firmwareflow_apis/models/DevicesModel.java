package com.ast.firmwareflow_apis.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "devices")
public class DevicesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "projects", referencedColumnName = "id", nullable = true)
    private ProjectsModel projectsModel;
}
