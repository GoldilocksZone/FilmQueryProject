package com.skilldistillery.filmquery.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

//	private void test() {
//		Film film = db.findFilmById(1);
//		System.out.println(film);
//	}

	private void launch() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("+----------------+");
		System.out.println("+ Film Query App +");
		System.out.println("+----------------+");
		System.out.println();

		startUserInterface(scanner);

		scanner.close();
	}

	private void startUserInterface(Scanner scanner) {
		int userSelection;
		boolean run = true;
		List<Film> films;

		while (run) {
			films = new ArrayList<Film>();
			printMainMenu();
			userSelection = getUserSelection(scanner, new int[] { 1, 2, 9 });
			switch (userSelection) {
			case 1:
				films.add(lookUpFilmById(scanner));
				try {
					printFilm(films.get(0), f -> System.out.println(f.toString()));
					getFilmOption(scanner, films);
				} catch (NullPointerException npe) {}
				break;
			case 2:
				films = lookUpFilmByKeyword(scanner);
				try {
					for (Film film : films) {
						printFilm(film, f -> System.out.println(f.toString()));
					}
					getFilmOption(scanner, films);
				} catch (NullPointerException npe) {}
				break;
			case 9:
				run = false;
				break;
			default:
				System.out.println("Error. Program shutting down.");
				break;
			}
		}
	}

	private void printMainMenu() {
		System.out.println("Please select an option from the following menu:");
		System.out.println();
		System.out.println("1 - Look up film by id");
		System.out.println("2 - Look up film by key word or phrase");
		System.out.println("9 - Exit");
		System.out.println();
	}

	private void printFilmMenu() {
		System.out.println("Please select an option from the following menu:");
		System.out.println();
		System.out.println("1 - View all film details");
		System.out.println("9 - Return to main menu");
		System.out.println();
	}

	private void printFilm(Film film, Consumer<Film> c) {
		c.accept(film);
	}

	private int getUserSelection(Scanner scanner, int[] validResponses) {
		boolean validResponse = false;
		int response = 0;

		do {
			System.out.print("> ");
			try {
				response = scanner.nextInt();
				if (Arrays.binarySearch(validResponses, response) >= 0) {
					validResponse = true;
				} else {
					System.out.println("Invalid selection. Please try again.");
				}
			} catch (InputMismatchException ime) {
				System.out.println("Invalid selection. Please try again.");
			} finally {
				scanner.nextLine();
			}
		} while (!validResponse);

		return response;
	}

	private void getFilmOption(Scanner scanner, List<Film> films) {
		printFilmMenu();
		switch (getUserSelection(scanner, new int[] { 1, 9 })) {
		case 1:
			for (Film film : films) {
				printFilm(film, f -> System.out.print(f.toStringDetails()));
			}
			break;
		case 9:
			System.out.println("Exiting");
			break;
		default:
			System.out.println("Default");
			break;
		}
	}

	private Film lookUpFilmById(Scanner scanner) {
		int filmId = getFilmId(scanner);
		Film film = db.findFilmById(filmId);
		if (film == null) {
			System.out.println("Film not found.");
			return null;
		} else {
			return film;
		}
	}

	private int getFilmId(Scanner scanner) {
		boolean validResponse = false;
		int response = 0;

		System.out.print("Please enter a film id: ");
		do {
			System.out.print("> ");
			try {
				response = scanner.nextInt();
				if (response > 0) {
					validResponse = true;
				} else {
					System.out.println("Invalid selection. Please try again.");
				}
			} catch (InputMismatchException ime) {
				System.out.println("Invalid selection. Please try again.");
			} finally {
				scanner.nextLine();
			}
		} while (!validResponse);

		return response;
	}

	private List<Film> lookUpFilmByKeyword(Scanner scanner) {
		String keyword = getFilmKeyword(scanner);
		List<Film> films = db.findFilmByKeyword(keyword);
		if (films.isEmpty()) {
			System.out.println("No films found.");
			return null;
		} else {
			System.out.println(films.size() + " films found matching the given search criteria:\n");
			return films;
		}
	}

	private String getFilmKeyword(Scanner scanner) {
		boolean validResponse = false;
		String keyword = "";

		System.out.println("Please enter a search term or phrase: ");
		do {
			System.out.print("> ");
			try {
				keyword = scanner.nextLine();
				validResponse = true;
			} catch (Exception e) {
				System.out.println("Invalid selection. Please try again.");
			}
		} while (!validResponse);

		return keyword;
	}

}
