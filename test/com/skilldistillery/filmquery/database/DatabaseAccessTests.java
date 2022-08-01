package com.skilldistillery.filmquery.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

class DatabaseAccessTests {
  private DatabaseAccessor db;

  @BeforeEach
  void setUp() throws Exception {
    db = new DatabaseAccessorObject();
  }

  @AfterEach
  void tearDown() throws Exception {
    db = null;
  }
  
  @Test
  void test_getFilmById_returns_film_with_id() {
    Film film = db.findFilmById(1);
    assertNotNull(film);
  }
  
  @Test
  void test_getFilmById_returns_correct_film_with_id() {
    Film film = db.findFilmById(1);
    assertEquals("ACADEMY DINOSAUR", film.getTitle());
  }

  @Test
  void test_getFilmById_with_invalid_id_returns_null() {
    Film film = db.findFilmById(-42);
    assertNull(film);
  }
  
  @Test
  void findFilmByKeyword_returns_list_of_films_with_valid_search_term() {
	  List<Film> films = db.findFilmByKeyword("dino");
	  assertNotNull(films);
  }
  
  @Test
  void findFilmByKeyword_returns_correct_list_of_films_with_valid_search_term() {
	  List<String> correctTitles = new ArrayList<String>(Arrays.asList("CENTER DINOSAUR", "ACADEMY DINOSAUR", "DINOSAUR SECRETARY"));
	  List<Film> films = db.findFilmByKeyword("dino");
	  List<String> filmTitles = new ArrayList<String>();
	  for (Film film : films) {
		  filmTitles.add(film.getTitle());
	  }
	  assertEquals(correctTitles, filmTitles);
  }
  
  @Test
  void findFilmByKeyword_returns_empty_list_with_invalid_search_term() {
	  List<Film> films = db.findFilmByKeyword("asdfghjkqwerty");
	  assertTrue(films.size() == 0);
  }
  
  @Test
  void getFilmInventory_returns_map_of_inventory_for_valid_film_id() {
	  Map<String, Set<Integer>> inventory = db.getFilmInventory(1);
	  assertNotNull(inventory);
  }
  
  @Test
  void getFilmInventory_returns_empty_map_for_invalid_film_id() {
	  Map<String, Set<Integer>> inventory = db.getFilmInventory(-42);
	  assertTrue(inventory.size() == 0);
  }
  
  @Test
  void findActorById_returns_actor_with_valid_actor_id() {
	  Actor actor = db.findActorById(1);
	  assertNotNull(actor);
  }
  
  @Test
  void findActorById_returns_null_with_invalid_actor_id() {
	  Actor actor = db.findActorById(-42);
	  assertNull(actor);
  }
  
  @Test
  void findActorsByFilmId_returns_list_of_actor_with_valid_film_id() {
	  List<Actor> actors = db.findActorsByFilmId(1);
	  assertNotNull(actors);
  }
  
  @Test
  void findActorsByFilmId_returns_empty_list_with_invalid_film_id() {
	  List<Actor> actors = db.findActorsByFilmId(-42);
	  assertTrue(actors.size() == 0);
  }
  
}
