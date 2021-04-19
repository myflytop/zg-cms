package com.oly.cms.system.service.impl;

import java.util.List;

import com.oly.cms.system.mapper.CmsConfigBackMapper;
import com.oly.cms.system.model.po.CmsConfigBack;
import com.oly.cms.system.service.ICmsConfigBackService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 配置文件备份Service业务层处理
 * 
 * @author 止戈
 * @date 2021-04-04
 */
@Service
public class CmsConfigBackServiceImpl implements ICmsConfigBackService {
    @Autowired
    private CmsConfigBackMapper cmsConfigBackMapper;

    /**
     * 查询配置文件备份
     * 
     * @param configGroup 配置文件备份ID
     * @return 配置文件备份
     */
    @Override
    public CmsConfigBack selectCmsConfigBackById(String configGroup) {
        return cmsConfigBackMapper.selectCmsConfigBackById(configGroup);
    }

    /**
     * 查询配置文件备份列表
     * 
     * @param cmsConfigBack 配置文件备份
     * @return 配置文件备份
     */
    @Override
    public List<CmsConfigBack> selectCmsConfigBackList(CmsConfigBack cmsConfigBack) {
        return cmsConfigBackMapper.selectCmsConfigBackList(cmsConfigBack);
    }

    /**
     * 新增配置文件备份
     * 
     * @param cmsConfigBack 配置文件备份
     * @return 结果
     */
    @Override
    public int insertCmsConfigBack(CmsConfigBack cmsConfigBack) {
        cmsConfigBack.setCreateTime(DateUtils.getNowDate());
        return cmsConfigBackMapper.insertCmsConfigBack(cmsConfigBack);
    }

    /**
     * 修改配置文件备份
     * 
     * @param cmsConfigBack 配置文件备份
     * @return 结果
     */
    @Override
    public int updateCmsConfigBack(CmsConfigBack cmsConfigBack) {
        cmsConfigBack.setUpdateTime(DateUtils.getNowDate());
        return cmsConfigBackMapper.updateCmsConfigBack(cmsConfigBack);
    }

    /**
     * 删除配置文件备份对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCmsConfigBackByIds(String ids) {
        return cmsConfigBackMapper.deleteCmsConfigBackByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除配置文件备份信息
     * 
     * @param configGroup 配置文件备份ID
     * @return 结果
     */
    @Override
    public int deleteCmsConfigBackById(String configGroup) {
        return cmsConfigBackMapper.deleteCmsConfigBackById(configGroup);
    }

    @Override
    public boolean isExist(String backGroup, String configKey) {

        return cmsConfigBackMapper.isExist(backGroup, configKey) > 0 ? true : false;
    }
}
