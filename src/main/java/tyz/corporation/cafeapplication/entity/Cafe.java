package tyz.corporation.cafeapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tyz.corporation.cafeapplication.entity.type.Status;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cafe")
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "cafe_cities", joinColumns = @JoinColumn(name = "cafe_id"))
    private List<String> city = new ArrayList<>();
    private String name;
    private String photo;
    @OneToOne
    private Menu menu;
}
