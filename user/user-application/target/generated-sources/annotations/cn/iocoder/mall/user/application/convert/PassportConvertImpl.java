package cn.iocoder.mall.user.application.convert;

import cn.iocoder.mall.user.api.bo.OAuth2AccessTokenBO;
import cn.iocoder.mall.user.application.vo.users.UsersAccessTokenVO;
import cn.iocoder.mall.user.application.vo.users.UsersMobileRegisterVO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-23T17:19:25+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
public class PassportConvertImpl implements PassportConvert {

    @Override
    public UsersMobileRegisterVO convert(OAuth2AccessTokenBO oauth2AccessTokenBO) {
        if ( oauth2AccessTokenBO == null ) {
            return null;
        }

        UsersMobileRegisterVO usersMobileRegisterVO = new UsersMobileRegisterVO();

        usersMobileRegisterVO.setAccessToken( oauth2AccessTokenBO.getAccessToken() );
        usersMobileRegisterVO.setRefreshToken( oauth2AccessTokenBO.getRefreshToken() );
        usersMobileRegisterVO.setExpiresIn( oauth2AccessTokenBO.getExpiresIn() );

        return usersMobileRegisterVO;
    }

    @Override
    public UsersAccessTokenVO convert2(OAuth2AccessTokenBO result) {
        if ( result == null ) {
            return null;
        }

        UsersAccessTokenVO usersAccessTokenVO = new UsersAccessTokenVO();

        usersAccessTokenVO.setAccessToken( result.getAccessToken() );
        usersAccessTokenVO.setRefreshToken( result.getRefreshToken() );
        usersAccessTokenVO.setExpiresIn( result.getExpiresIn() );

        return usersAccessTokenVO;
    }
}
