package generator.mapper;

import generator.domain.PrpdTagConfig;

/**
* @author cxc
* @description 针对表【PRPD_TAG_CONFIG(燃气险标签配置表)】的数据库操作Mapper
* @createDate 2023-05-10 17:14:09
* @Entity generator.domain.PrpdTagConfig
*/
public interface PrpdTagConfigMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PrpdTagConfig record);

    int insertSelective(PrpdTagConfig record);

    PrpdTagConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PrpdTagConfig record);

    int updateByPrimaryKey(PrpdTagConfig record);

}
