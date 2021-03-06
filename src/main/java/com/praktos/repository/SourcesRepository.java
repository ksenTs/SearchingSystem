package com.praktos.repository;

import com.praktos.entity.Sources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SourcesRepository extends JpaRepository<Sources,Integer> {

    @Query(value = "((select id, name, author, publisher, year, type, link, path, tags, similarity(name, :name) similarity from Sources where similarity(name, :name)>0.1) union (select id, name, author, publisher, year, type, link, path, tags, similarity(name, :name) similarity from Sources where lower(name) like concat('%', :name, '%'))) order by similarity desc", nativeQuery = true)
    List<Sources> findSourcesByName(@Param("name") String name);

    @Query(value = "((select id, name, author, publisher, year, type, link, path, tags, similarity(author, :author) similarity from Sources where similarity(author, :author)>0.5) union (select id, name, author, publisher, year, type, link, path, tags, similarity(author, :author) similarity from Sources where lower(author) like concat('%', :author, '%'))) order by similarity desc", nativeQuery = true)
    List<Sources> findSourcesByAuthor(@Param("author") String author);

    @Query(value = "((select id, name, author, publisher, year, type, link, path, tags, similarity(publisher, :publisher) similarity from Sources where lower(publisher) like concat('%', :publisher, '%')) union (select id, name, author, publisher, year, type, link, path, tags, similarity(publisher, :publisher) similarity from Sources where similarity(publisher, :publisher)>0.1)) order by similarity desc", nativeQuery = true)
    List<Sources> findSourcesByPublisher(@Param("publisher") String publisher);

    @Query(value = "select id, name, author, publisher, year, type, link, path, tags from Sources where year = :year", nativeQuery = true)
    List<Sources> findSourcesByYear(@Param("year") String year);

    @Query(value = "((select id, name, author, publisher, year, type, link, path, tags, similarity(tags, :tags) similarity from Sources where lower(tags) like concat('%', :tags, '%')) union (select id, name, author, publisher, year, type, link, path, tags, similarity(tags, :tags) similarity from Sources where similarity(tags, :tags)>0.1)) order by similarity desc", nativeQuery = true)
    List<Sources> findSourcesByTags(@Param("tags") String tags);

    List<Sources> findSourcesById(Integer id);

    List<Sources> findAll();

    @Query("select distinct author from Sources ORDER BY author")
    List<Object> getAuthorsList();

    @Query("select distinct publisher from Sources ORDER BY publisher")
    List<Object> getPublishersList();

    @Query("select distinct year from Sources ORDER BY year")
    List<Object> getYearsList();
}