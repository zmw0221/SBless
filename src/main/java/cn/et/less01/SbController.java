package cn.et.less01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.et.less01.dao.cookRepository;
import cn.et.less01.entity.Result;
import cn.et.less01.entity.TreeNode;

@RestController
@EnableAutoConfiguration
public class SbController {
	
	@Autowired
	JdbcTemplate jt;
	@Autowired
	cookRepository cr;
	


	
	@RequestMapping("/hello")
	public Map hello(){
		Map map= new HashMap();
		map.put("id", 1);
		map.put("name", "后裔");
		return map;
	}
	
	@RequestMapping("/saveCook")
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
	
	@RequestMapping("/queryCk")
	public Cook queryCook(){
		Cook c=cr.findOne(2);
		return c;
	}
	
	@RequestMapping("/queryCook/{id}")
	public Map getCook(@PathVariable String id){
		List<Map<String,Object>> e=jt.queryForList("select * from cook where fid="+id);
		return e.get(0);
	}
	
	@RequestMapping("/queryk")
	public List<Map<String, Object>> getC(){
		List<Map<String,Object>> e=jt.queryForList("select * from cook");
		return e;
	}
	
	@RequestMapping("/Cooking")
	public List<Map<String, Object>> Cooking(){
		List<Map<String,Object>> e=jt.queryForList("select * from cooking where kid=1");
		return e;
	}
	
	@RequestMapping("/delete/{fid}")
	public Result deleteCook(@PathVariable Integer fid){
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
	
	
	public static void main(String[] args) {
		SpringApplication.run(SbController.class, args);
	}
}
