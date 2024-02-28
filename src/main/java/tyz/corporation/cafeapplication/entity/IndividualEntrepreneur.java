package tyz.corporation.cafeapplication.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "individual_entrepreneurs")
public class IndividualEntrepreneur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String numberIE;
    private String numberPhone;
    @OneToOne
    private Cafe cafe;
}
