package com.hustarico.entity;


import com.hustarico.model.BookStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private int yearOfPublication;
    @Enumerated(EnumType.STRING)
    private BookStatus status;
    private Long borrowerId;


}
