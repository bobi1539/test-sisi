package tes.sis.testsisi.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "t_sale")
public class TSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cement_id")
    private MCement cement;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private MCustomer customer;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private MDriver driver;

    @Column(name = "destination_address")
    private String destinationAddress;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Float price;

    @Column(name = "total_price")
    private Double totalPrice;
}
