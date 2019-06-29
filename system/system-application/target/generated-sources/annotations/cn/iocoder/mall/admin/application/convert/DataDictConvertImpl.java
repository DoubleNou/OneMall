package cn.iocoder.mall.admin.application.convert;

import cn.iocoder.common.framework.vo.CommonResult;
import cn.iocoder.mall.admin.api.bo.datadict.DataDictBO;
import cn.iocoder.mall.admin.application.vo.datadict.DataDictVO;
import cn.iocoder.mall.admin.application.vo.datadict.DataDictValueVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-23T00:47:02+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
public class DataDictConvertImpl implements DataDictConvert {

    @Override
    public DataDictVO convert(DataDictBO dataDictBO) {
        if ( dataDictBO == null ) {
            return null;
        }

        DataDictVO dataDictVO = new DataDictVO();

        dataDictVO.setId( dataDictBO.getId() );
        dataDictVO.setEnumValue( dataDictBO.getEnumValue() );
        dataDictVO.setValue( dataDictBO.getValue() );
        dataDictVO.setDisplayName( dataDictBO.getDisplayName() );
        dataDictVO.setSort( dataDictBO.getSort() );
        dataDictVO.setMemo( dataDictBO.getMemo() );

        return dataDictVO;
    }

    @Override
    public List<DataDictVO> convert(List<DataDictBO> dataDictBOs) {
        if ( dataDictBOs == null ) {
            return null;
        }

        List<DataDictVO> list = new ArrayList<DataDictVO>( dataDictBOs.size() );
        for ( DataDictBO dataDictBO : dataDictBOs ) {
            list.add( convert( dataDictBO ) );
        }

        return list;
    }

    @Override
    public CommonResult<List<DataDictVO>> convert(CommonResult<List<DataDictBO>> result) {
        if ( result == null ) {
            return null;
        }

        CommonResult<List<DataDictVO>> commonResult = new CommonResult<List<DataDictVO>>();

        commonResult.setCode( result.getCode() );
        commonResult.setMessage( result.getMessage() );
        commonResult.setData( convert( result.getData() ) );

        return commonResult;
    }

    @Override
    public CommonResult<DataDictVO> convert2(CommonResult<DataDictBO> result) {
        if ( result == null ) {
            return null;
        }

        CommonResult<DataDictVO> commonResult = new CommonResult<DataDictVO>();

        commonResult.setCode( result.getCode() );
        commonResult.setMessage( result.getMessage() );
        commonResult.setData( convert( result.getData() ) );

        return commonResult;
    }

    @Override
    public List<DataDictValueVO> convert2(List<DataDictBO> dataDictBOs) {
        if ( dataDictBOs == null ) {
            return null;
        }

        List<DataDictValueVO> list = new ArrayList<DataDictValueVO>( dataDictBOs.size() );
        for ( DataDictBO dataDictBO : dataDictBOs ) {
            list.add( dataDictBOToDataDictValueVO( dataDictBO ) );
        }

        return list;
    }

    protected DataDictValueVO dataDictBOToDataDictValueVO(DataDictBO dataDictBO) {
        if ( dataDictBO == null ) {
            return null;
        }

        DataDictValueVO dataDictValueVO = new DataDictValueVO();

        dataDictValueVO.setValue( dataDictBO.getValue() );
        dataDictValueVO.setDisplayName( dataDictBO.getDisplayName() );

        return dataDictValueVO;
    }
}
