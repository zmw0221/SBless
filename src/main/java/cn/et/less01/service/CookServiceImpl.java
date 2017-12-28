package cn.et.less01.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cn.et.less01.Cook;
import cn.et.less01.dao.cookRepository;
import cn.et.less01.entity.Result;

@Service
public class CookServiceImpl implements CookService {
	
	@Autowired
	JdbcTemplate jt;
	@Autowired
	cookRepository cr;
	
	public Result deleteCook(Integer fid) {
		Result r= new Result();
		r.setCode(1);
		try{
			cr.delete(fid);
		}catch(Exception e){
			r.setCode(0);
			r.setMessaga(e.getMessage());
		}
		return r;
	}
	
	public Result saveCook(Cook cook){
		
		Result r= new Result();
		r.setCode(1);
		try{
			System.out.println(cook.getFid());
			cr.save(cook);
		}catch(Exception e){
			r.setCode(0);
			r.setMessaga(e.getMessage());
			System.out.println("报错了");
		}
		return r;
	}
	
	public List<Map<String, Object>> query(){
		List<Map<String,Object>> e=jt.queryForList("select * from cook");
		return e;
	}
}
