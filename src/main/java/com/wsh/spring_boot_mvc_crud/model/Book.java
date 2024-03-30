package com.wsh.spring_boot_mvc_crud.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    Integer id;
    String title;
    String author;
}
