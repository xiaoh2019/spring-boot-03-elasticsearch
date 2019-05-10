package com.cyzs.springboot03elasticsearch.repository;

import com.cyzs.springboot03elasticsearch.bean.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author xiaoH
 * @create 2019-05-09-22:11
 */
public interface ArticleRepository extends ElasticsearchRepository<Article,Integer> {

}
