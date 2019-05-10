package com.cyzs.springboot03elasticsearch.bean;

import io.searchbox.annotations.JestId;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author xiaoH
 * @create 2019-05-09-17:48
 */
@Document(indexName = "cyzs",type = "article")
public class Article implements Serializable {

    //@JestId
    private Integer id;
    private String author;
    private String title;
    private String content;

    public Article() {
        super();
    }

    public Article(Integer id, String author, String title, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
