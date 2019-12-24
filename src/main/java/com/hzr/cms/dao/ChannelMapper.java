/**
 * 
 */
package com.hzr.cms.dao;

import java.util.List;

import com.hzr.cms.domain.Channel;

/**
 * 说明:栏目dao层接口
 * 
 * @author 
 * @version 1.0
 *
 */
public interface ChannelMapper {

	public void insert(Channel channel);

	public void deleteById(int id);

	public Channel selectById(int id);
	
	public List<Channel> selectAll();
	
}
