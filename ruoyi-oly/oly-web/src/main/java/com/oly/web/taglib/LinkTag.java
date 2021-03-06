package com.oly.web.taglib;

import com.oly.web.model.po.BlogLink;
import com.oly.web.service.cache.BlogCacheService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("linkTag")
public class LinkTag {
  @Autowired
  private BlogCacheService blogService;

  /**
   * 获取链接列表
   * 
   * @param groupName
   * @return
   */
  public List<BlogLink> listLink(String groupKey) {
   
    return blogService.listBlogLinks(groupKey);
  }

  /**
   * 获取链接通过ID
   * @param linkId
   * @return
   */
  public BlogLink getLinkById(Long linkId) {
   return blogService.getBlogLinkById(linkId);
  }

  /**
   * 组名分组
   * @param groupName
   * @return
   */
  public Map<String, List<BlogLink>> groupLink(String groupKey) {
    Map<String, List<BlogLink>> linkMap = blogService.listBlogLinks(groupKey).stream()
        .collect(Collectors.groupingBy(BlogLink::getGroupName));
    return linkMap;
  }

}
