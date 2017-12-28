package cn.et.less02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.et.less02.entity.Result;
import cn.et.less02.entity.TreeNode;
import cn.et.less02.entity.cook.Cook;
import cn.et.less02.mapper.CookMapper;
import cn.et.less02.service.TreeNodeService;


@RestController
public class SbController {
	
	@Autowired
	CookMapper cm;
	@Autowired
	TreeNodeService ts;
	
	@RequestMapping("/qcook")
	public List<Cook> queryCook(Integer id,Integer page,Integer rows){
		
		return ts.queryCook(id, page, rows);
}
	
	@RequestMapping("/queryCookIng")
	public List<TreeNode> queryTreeNode(Integer id){
			if(id==null){
				id=0;
			}
			return ts.queryTreeNode(id);
	}
	
	@RequestMapping(value="/Cookdelete/{fid}")
	public Result deleteFood(@PathVariable Integer fid,Integer page,Integer rows) {
		Result r= new Result();
		r.setCode(1);
		try{
			ts.deleteCook(fid);
		}catch(Exception e){
			r.setCode(0);
			r.setMessaga(e.getMessage());
		}
		return r;
		
	}
}
