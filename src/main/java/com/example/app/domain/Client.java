package com.example.app.domain;

import com.example.core.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CLIENT")
public class Client extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    private String name;
}
