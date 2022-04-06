package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Team.findAll", query = "select t from Movie as t")
})
@Table(name = "MOVIE")
@Getter
@Setter
public class Movie {

    public Movie(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Actor> players = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie team = (Movie) o;
        return Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

}
