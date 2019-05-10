package com.cyzs.springboot03elasticsearch;

import com.cyzs.springboot03elasticsearch.bean.Article;
import com.cyzs.springboot03elasticsearch.repository.ArticleRepository;
import io.searchbox.client.JestClient;

import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03ElasticsearchApplicationTests {

    @Autowired
	JestClient jestClient;

    @Autowired
    ArticleRepository articleRepository;

    @Test
	public void index(){
		Article article = new Article();
		article.setId(1);
		article.setAuthor("罗贯中");
		article.setTitle("三国演义");
		articleRepository.index(article);
	}

	@Test
	public void search1(){
		Article one = articleRepository.findOne(1);
		System.out.println(one);
	}

    //建立索引
	@Test
	public void contextLoads() {

		Article article = new Article(2, "罗贯中", "三国演义", "第一回");

		Index index = new Index.Builder(article).index("cyzs").type("book").build();
		try {
			jestClient.execute(index);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	//搜索
	@Test
	public void search(){
		String json ="{\n" +
				"    \"query\" : {\n" +
				"        \"match\" : {\n" +
				"            \"author\" : \"罗贯中\"\n" +
				"        }\n" +
				"    }\n" +
				"}";
		Search search = new Search.Builder(json).addIndex("cyzs").addType("book").build();

		try {
			SearchResult result = jestClient.execute(search);
			System.out.println(result.getJsonString()+"==========");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
