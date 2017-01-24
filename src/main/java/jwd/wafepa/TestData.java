package jwd.wafepa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Author;
import jwd.wafepa.model.Book;
import jwd.wafepa.model.Club;
import jwd.wafepa.model.Player;
import jwd.wafepa.service.AuthorService;
import jwd.wafepa.service.BookService;
import jwd.wafepa.service.ClubService;
import jwd.wafepa.service.PlayerService;

@Component
public class TestData {

	@Autowired
	private AuthorService authorService;

	@Autowired
	private BookService bookService;

	@Autowired
	private ClubService clubService;

	@Autowired
	private PlayerService playerService;

	@PostConstruct
	public void init() {
		// for (int i = 0; i < 20; i++) {
		// Author author = new Author("firstname_" + i, "lastname_" + i);
		// author = authorService.save(author);
		// for (int j = 0; j < 3; j++) {
		// Book book = new Book("naslov_" + j, "isbn_00" + j);
		// book.setAuthor(author);
		// bookService.save(book);
		// }
		// }

		for (int i = 0; i < 21; i++) {
			Club club = new Club("klub_" + i);
			Club saved = clubService.save(club);
			for (int j = 0; j <= 12; j++) {
				Player player = new Player("imeIgraca_" + j, "prezimeIgraca_" + j, club);
				playerService.save(player);
			}
		}
	}

}
