package com.ha.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "academy", uniqueConstraints = {@UniqueConstraint(
		name = "NAME_AGE_UNIQUE",
		columnNames = {"NAME", "AGE"}
)})
@ToString
@EqualsAndHashCode
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 10)
    private String name;
    private String address;

    @Builder
    public Academy(String name, String address) {
        this.name = name;
        this.address = address;
    }
}