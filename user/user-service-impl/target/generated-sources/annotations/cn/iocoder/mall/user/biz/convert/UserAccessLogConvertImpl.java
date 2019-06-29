package cn.iocoder.mall.user.biz.convert;

import cn.iocoder.mall.user.api.dto.UserAccessLogAddDTO;
import cn.iocoder.mall.user.biz.dataobject.UserAccessLogDO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-23T17:19:22+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
public class UserAccessLogConvertImpl implements UserAccessLogConvert {

    @Override
    public UserAccessLogDO convert(UserAccessLogAddDTO adminAccessLogAddDTO) {
        if ( adminAccessLogAddDTO == null ) {
            return null;
        }

        UserAccessLogDO userAccessLogDO = new UserAccessLogDO();

        userAccessLogDO.setUserId( adminAccessLogAddDTO.getUserId() );
        userAccessLogDO.setUri( adminAccessLogAddDTO.getUri() );
        userAccessLogDO.setQueryString( adminAccessLogAddDTO.getQueryString() );
        userAccessLogDO.setMethod( adminAccessLogAddDTO.getMethod() );
        userAccessLogDO.setUserAgent( adminAccessLogAddDTO.getUserAgent() );
        userAccessLogDO.setIp( adminAccessLogAddDTO.getIp() );
        userAccessLogDO.setStartTime( adminAccessLogAddDTO.getStartTime() );
        userAccessLogDO.setResponseTime( adminAccessLogAddDTO.getResponseTime() );

        return userAccessLogDO;
    }
}
