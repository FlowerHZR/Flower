/**
 * 
 */
package com.hzr.cms.service;

import java.util.List;

import com.hzr.cms.domain.Category;
import com.hzr.cms.domain.Channel;

/**
 * 说明:
 * 
 * @author 
 * @version 1.0
 *
 */
public interface ChannelCategoryService {
	
	//----------------------------------频道----------------------------

	public void saveChannel(Channel channel);

	public void removeChannel(int id);
	
	public Channel getChannel(int id);

	public List<Channel> getChannels();

	
	//----------------------------------分类----------------------------
	
	public void saveCategory(Category category) ;

	public void removeCategory(int id);
	
	public Category getCategory(int id);

	public List<Category> getCategories(int channelId);

	public List<Category> getCategories() ;
	
	
}
