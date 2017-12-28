package cn.et.less02.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.less02.entity.Bibi;
import cn.et.less02.entity.BibiExample;
import cn.et.less02.entity.TreeNode;
import cn.et.less02.entity.cook.Cook;
import cn.et.less02.entity.cook.CookExample;
import cn.et.less02.entity.cooking.Cooking;
import cn.et.less02.entity.cooking.CookingExample;
import cn.et.less02.mapper.BibiMapper;
import cn.et.less02.mapper.CookMapper;
import cn.et.less02.mapper.CookingMapper;
import cn.et.less02.service.TreeNodeService;

@Service
public class TreeNodeServiceImpl implements TreeNodeService{
	
	@Autowired
	CookingMapper cm;
	@Autowired
	CookMapper ck;
	@Autowired
	BibiMapper bm;
	
	public List<TreeNode> queryTreeNode(Integer id){
		List<TreeNode> deptlist= new ArrayList<TreeNode>();
		
		BibiExample be= new BibiExample();
		be.createCriteria().andLidEqualTo(id);
		List<Bibi> bi=bm.selectByExample(be);
		for(Bibi b:bi){
			TreeNode td= new TreeNode();
			td.setId(b.getBid());
			td.setText(b.getBname());
			if(queryTreeNode(b.getBid()).size()==0){
				td.setState("open");
			}
			deptlist.add(td);
		}
		
		//发起sql语句查询总记录数
		CookingExample ce = new CookingExample();
		ce.createCriteria().andKidEqualTo(id);
		List<Cooking> ck= cm.selectByExample(ce);
		
		for(Cooking c:ck){
			TreeNode tn= new TreeNode();
			tn.setId(c.getCid());
			tn.setText(c.getCname());
			
			//判断当前节点是否还存在子节点
			if(queryTreeNode(c.getCid()).size()==0){
				tn.setState("open");
			}
			deptlist.add(tn);
		}
		return deptlist;
	}
	//根据传入的ID查询
	public List<Cook> queryCook(Integer id,Integer page,Integer rows){
		CookExample ee= new CookExample();
		//如果传入ID不为空就添加条件cid=id。没有就查所有
		if(id!=null)
			ee.createCriteria().andCidEqualTo(id);
		return ck.selectByExample(ee);
	}
	
	public void deleteCook(Integer fid){
		ck.deleteByPrimaryKey(fid);
	}
}
