package cn.et.less01.service;

import java.util.List;
import java.util.Map;

import cn.et.less01.Cook;
import cn.et.less01.entity.Result;

public interface CookService {
	public Result deleteCook(Integer fid);
	
	public Result saveCook(Cook cook);
	
	public List<Map<String, Object>> query();
}
