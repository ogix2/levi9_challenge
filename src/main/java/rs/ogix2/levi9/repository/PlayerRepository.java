package rs.ogix2.levi9.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ogix2.levi9.model.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByPlayerName(String playerName);

}