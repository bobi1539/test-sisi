package tes.sis.testsisi.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "m_cement")
public class MCement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "variant")
    private String variant;

    @Column(name = "price")
    private Float price;

    @Column(name = "stock")
    private Integer stock;
}
