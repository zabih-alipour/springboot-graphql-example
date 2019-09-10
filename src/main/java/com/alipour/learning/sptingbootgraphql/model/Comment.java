package com.alipour.learning.sptingbootgraphql.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = {"post"})
@EqualsAndHashCode(exclude = {"post"}, callSuper = true)
public class Comment extends ParentEntity {
    private String content;
    private String commenterEmail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

}
