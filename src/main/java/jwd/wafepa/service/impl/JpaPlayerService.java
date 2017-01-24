package jwd.wafepa.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Player;
import jwd.wafepa.repository.PlayerRepository;
import jwd.wafepa.service.PlayerService;

@Service
@Transactional
public class JpaPlayerService implements PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public Player findOne(Long playerID) {
		return playerRepository.findOne(playerID);
	}

	@Override
	public Page<Player> findAll(Integer page) {
		return playerRepository.findAll(new PageRequest(page, 10));
	}

	@Override
	public Iterable<Player> findAll() {
		return playerRepository.findAll();
	}

	@Override
	public Player save(Player player) {
		return playerRepository.save(player);
	}

	@Override
	public Player delete(Long playerID) {
		Player retVal = playerRepository.findOne(playerID);
		playerRepository.delete(playerID);
		return retVal;
	}

	@Override
	public Page<Player> findByFirstname(String firstname, Integer page) {
		return playerRepository.findByFirstnameContains(firstname, new PageRequest(page, 10));
	}

	@Override
	public Page<Player> findByLastname(String lastname, Integer page) {
		return playerRepository.findByLastnameContains(lastname, new PageRequest(page, 10));
	}

	@Override
	public Page<Player> findByFirstnameAndLastname(String firstname, String lastname, Integer page) {
		return playerRepository.findByFirstnameContainsAndLastnameContains(firstname, lastname,
				new PageRequest(page, 10));
	}

}
