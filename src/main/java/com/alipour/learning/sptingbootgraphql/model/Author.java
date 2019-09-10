package com.alipour.learning.sptingbootgraphql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = {"posts"})
@EqualsAndHashCode(exclude = {"posts"}, callSuper = true)
public class Author extends ParentEntity {
    private String name;
    private Integer age;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "author")
    @JsonIgnore
    private Set<Post> posts;


    public Author(Long id) {
        super(id);
    }

    public Author(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
