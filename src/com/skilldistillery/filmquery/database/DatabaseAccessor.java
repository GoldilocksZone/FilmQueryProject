package com.skilldistillery.filmquery.database;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
  public Film findFilmById(int filmId);
  public List<Film> findFilmByKeyword(String keyword);
  public Map<String, Set<Integer>> getFilmInventory(int filmId);
  public Actor findActorById(int actorId);
  public List<Actor> findActorsByFilmId(int filmId);

}
