package gssb.rdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gssb.rdb.model.Memo;
import gssb.rdb.repository.MemoRepository;

@RestController
@RequestMapping(path="/tx")
public class TxMemoController {

	@Autowired MemoRepository repository;
	
	// メモを１つ作成して、その後でエラーを発生させるメソッド
	private void create(Memo memo) {
		repository.save(memo);
		repository.save(new Memo()); // text の NotEmpty でエラー。
	}
	
	// トランザクションを管理する。
	@Transactional
    @RequestMapping(path="/on/memos", method=RequestMethod.POST)
    public void txOn(@RequestBody Memo memo) {
        create(memo);
    }
	
	// トランザクションを管理しない。
	@RequestMapping(path="/off/memos", method=RequestMethod.POST)
    public void txOff(@RequestBody Memo memo) {
		create(memo);
    }
}
