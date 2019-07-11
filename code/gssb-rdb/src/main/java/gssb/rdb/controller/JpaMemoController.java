package gssb.rdb.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gssb.rdb.model.Memo;
import gssb.rdb.repository.MemoRepository;

@RestController
@RequestMapping(path="/jpa/memos")
public class JpaMemoController {

  @Autowired MemoRepository repository;

  // リクエストの JSON を Memo にバインドして insert。
  @RequestMapping(method=RequestMethod.POST)
  public Map<String, Memo> create(@RequestBody Memo memo) {
    Memo result = repository.save(memo);
    return Collections.singletonMap("memo", result);
  }

  // リクエストパラメータ text の内容と等しいデータを select。
  @RequestMapping(method=RequestMethod.GET)
  public Map<String, Iterable<Memo>> read(@RequestParam String text) {
    Iterable<Memo> result = repository.findByText(text);
    return Collections.singletonMap("memos", result);
  }
}