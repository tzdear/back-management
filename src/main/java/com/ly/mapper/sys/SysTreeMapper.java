package com.ly.mapper.sys;

import java.util.List;

import com.ly.po.SysTree;

public interface SysTreeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysTree record);

    int insertSelective(SysTree record);

    SysTree selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysTree record);

    int updateByPrimaryKey(SysTree record);

	/**
	 * @Title: selectTreeByRoleId
	 * @author: linyan
	 * @Description: 
	 * @param id
	 * @return
	*/
	List<SysTree> selectTreeByRoleId(Integer id);

	/**
	 * @Title: selectAllTree
	 * @author: linyan
	 * @Description: 
	 * @return
	*/
	List<SysTree> selectAllTree();

	/**
	 * @Title: selectTreeByTreeNo
	 * @author: linyan
	 * @Description: 
	 * @param treeNo
	 * @return
	*/
	List<SysTree> selectTreeByTreeNo(Integer treeNo);

	/**
	 * @Title: selectByTreeParentId
	 * @author: linyan
	 * @Description: 
	 * @param parentId
	 * @return
	*/
	List<SysTree> selectByTreeParentId(Integer parentId);
}