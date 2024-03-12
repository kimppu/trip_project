package com.example.travelproject.domain.user.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "BoardEntity")
@Table(name = "board")
public class BoardEntity {
    @Id
    @NotBlank
    private String num;
    @NotBlank
    private String name;
    @NotBlank
    private String pwd;
    private String email;
    @NotBlank
    private String subject;
    @NotBlank
    private String content;
    private String ipaddr;
    private String hitcount;
    private String date;
}
