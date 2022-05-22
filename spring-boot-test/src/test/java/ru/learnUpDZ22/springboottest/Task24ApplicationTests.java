package ru.learnUpDZ22.springboottest;

import Dao.entity.Author;
import Dao.entity.Book;
import Dao.entityservice.AuthorService;
import Dao.entityservice.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;;

@SpringBootApplication
public class Task24ApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(Task24ApplicationTests.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Task24ApplicationTests.class, args);

		AuthorService authorService = context.getBean(AuthorService.class);
		BookService bookService = context.getBean(BookService.class);

		Author authorASP = new Author();
		authorASP.setAuthorName("Alexandr Sergeevich Pushkin");
		Book bookD = new Book();
		bookD.setBookName("Dubrovskiy");
		bookD.setAuthorid(authorASP);
		bookD.setCost(1000);
		bookD.setReleaseYear(1841);
		bookD.setPagesNumber(224);
		Author authorNVG = new Author();
		authorNVG.setAuthorName("Nikolay Vasilyevich Gogol");
		Book bookDS = new Book();
		bookDS.setBookName("Dead Souls");
		bookDS.setAuthorid(authorNVG);
		bookDS.setCost(500.31);
		bookDS.setReleaseYear(1842);
		bookDS.setPagesNumber(313);
		authorService.createAuthor(authorASP);
		authorService.createAuthor(authorNVG);
		bookService.createBook(bookD);
		bookService.createBook(bookDS);

		log.info("Authors:{} ", authorService.getAuthors());
		log.info("Books:{} ", bookService.getBooks());
	}
}