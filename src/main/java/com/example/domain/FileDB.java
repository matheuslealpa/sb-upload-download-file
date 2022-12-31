package com.example.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="FILES")
public class FileDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NonNull
    private String name;

    @NonNull
    private String type;

    @NonNull
    @Lob
    private byte[] data;
}
