package cn.iocoder.mall.user.biz.dao;

import cn.iocoder.mall.user.biz.dataobject.UserAddressDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户 地址
 *
 * @author Sin
 * @time 2019-04-06 13:29
 */
@Repository
public interface UserAddressMapper {

    int insert(UserAddressDO userAddressDO);

    int updateById(
            @Param("id") Integer id,
            @Param("userAddressDO") UserAddressDO userAddressDO
    );

    List<UserAddressDO> selectByUserIdAndDeleted(
            @Param("deleted") Integer deleted,
            @Param("userId") Integer userId
    );

    UserAddressDO selectByUserIdAndId(
            @Param("userId")  Integer userId,
            @Param("id") Integer id
    );

    UserAddressDO selectHasDefault(
            @Param("deleted")Integer deleted,
            @Param("userId") Integer userId,
            @Param("hasDefault") Integer hasDefault
    );
}
