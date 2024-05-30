package com.jpms.codinggame.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@Table(name = "user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;

    @Column(unique = true)
    private String nickName;

    @Column
    @Enumerated(EnumType.STRING)
    private Tier tier;


    @Column
    private String password;

    @Column
    private String email;

    @Column //누적점수
    private int score;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    private String address;

    @OneToMany(mappedBy = "user")
    private List<Qna> qnaList;

    @OneToMany(mappedBy = "user")
    private List<Comment> commentList;
}
