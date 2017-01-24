package jwd.wafepa.service;

import org.springframework.data.domain.Page;

import jwd.wafepa.model.Player;

public interface PlayerService {

	Player findOne(Long playerID);

	Page<Player> findAll(Integer page);

	Iterable<Player> findAll();

	Player save(Player player);

	Player delete(Long playerID);

	Page<Player> findByFirstname(String firstname, Integer page);

	Page<Player> findByLastname(String lastname, Integer page);

	Page<Player> findByFirstnameAndLastname(String firstname, String lastname, Integer page);

}
