package cn.iocoder.mall.user.biz.convert;

import cn.iocoder.mall.user.api.bo.UserBO;
import cn.iocoder.mall.user.api.dto.UserUpdateDTO;
import cn.iocoder.mall.user.biz.dataobject.UserDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-23T17:19:22+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
public class UserConvertImpl implements UserConvert {

    @Override
    public UserBO convert(UserDO userDO) {
        if ( userDO == null ) {
            return null;
        }

        UserBO userBO = new UserBO();

        userBO.setId( userDO.getId() );
        userBO.setMobile( userDO.getMobile() );
        userBO.setNickname( userDO.getNickname() );
        userBO.setAvatar( userDO.getAvatar() );
        userBO.setStatus( userDO.getStatus() );
        userBO.setCreateTime( userDO.getCreateTime() );

        return userBO;
    }

    @Override
    public UserDO convert(UserUpdateDTO userUpdateDTO) {
        if ( userUpdateDTO == null ) {
            return null;
        }

        UserDO userDO = new UserDO();

        userDO.setId( userUpdateDTO.getId() );
        userDO.setNickname( userUpdateDTO.getNickname() );
        userDO.setAvatar( userUpdateDTO.getAvatar() );

        return userDO;
    }

    @Override
    public List<UserBO> convert(List<UserDO> userDOs) {
        if ( userDOs == null ) {
            return null;
        }

        List<UserBO> list = new ArrayList<UserBO>( userDOs.size() );
        for ( UserDO userDO : userDOs ) {
            list.add( convert( userDO ) );
        }

        return list;
    }
}
