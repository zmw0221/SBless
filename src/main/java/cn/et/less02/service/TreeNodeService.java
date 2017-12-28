package cn.et.less02.service;

import java.util.List;

import cn.et.less02.entity.TreeNode;
import cn.et.less02.entity.cook.Cook;

public interface TreeNodeService {
	
	public List<TreeNode> queryTreeNode(Integer id);
	
	public List<Cook> queryCook(Integer id,Integer page,Integer rows);
	
	public void deleteCook(Integer fid);

	
}
