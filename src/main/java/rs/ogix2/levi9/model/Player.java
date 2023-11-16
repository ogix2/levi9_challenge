package rs.ogix2.levi9.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "players")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String playerName;

    @Column
    private String position;

    @Column
    private int ftm;

    @Column
    private int fta;

    @Column
    private int twopm;

    @Column
    private int twopa;

    @Column
    private int threepm;

    @Column
    private int threepa;

    @Column
    private int reb;

    @Column
    private int blk;

    @Column
    private int ast;

    @Column
    private int stl;

    @Column
    private int tov;
}