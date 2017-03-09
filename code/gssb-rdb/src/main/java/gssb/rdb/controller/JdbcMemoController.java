package gssb.rdb.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/jdbc/memos")
public class JdbcMemoController {

	@Autowired JdbcTemplate jdbc;
	
	// リクエストパラメータ text を insert。
	@RequestMapping(method=RequestMethod.POST)
	public Map<String, Long> create(@RequestParam String text) {
		Long id = jdbc.queryForObject(
			"insert into memo (text) values (?) returning id",
			new Object[] {text},
			(rs, num) -> rs.getLong("id")
		);
		return Collections.singletonMap("id", id);
	}
	
	// リクエストＵＲＬ末尾のＩＤと等しいデータを select。
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Map<String, Memo> read(@PathVariable Long id) {
		Memo memo = jdbc.queryForObject(
			"select id, text from memo where id = ?",
			new Object[] {id},
			(rs, num) -> new Memo(rs.getLong("id"), rs.getString("text"))
		);
		return Collections.singletonMap("memo", memo);
	}

	public static class Memo {
		public Long id;
		public String name;
		public Memo(Long id, String name) {
		  this.id = id;
		  this.name = name;
		}
	}
}
