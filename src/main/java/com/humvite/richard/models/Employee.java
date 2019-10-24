package com.humvite.richard.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="employees")
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(callSuper = true)
@Getter @Setter
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Name may not be null")
    private String name;

    @NotNull(message = "Designation may not be null")
    private String designation;

    @NotNull(message = "Expertise may not be null")
    private String expertise;
}