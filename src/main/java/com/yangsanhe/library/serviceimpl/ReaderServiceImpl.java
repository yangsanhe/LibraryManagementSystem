package com.yangsanhe.library.serviceimpl;

import com.yangsanhe.library.dao.ReaderMapper;
import com.yangsanhe.library.dao.ReaderTypeMapper;
import com.yangsanhe.library.entity.Reader;
import com.yangsanhe.library.entity.ReaderType;
import com.yangsanhe.library.error.CommonError;
import com.yangsanhe.library.error.CustomException;
import com.yangsanhe.library.service.ReaderService;
import com.yangsanhe.library.vo.ReaderTableVO;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangsanhe
 * @date 2019-12-30 11:17:09
 */
@Service
public class ReaderServiceImpl implements ReaderService {
    private final ReaderMapper readerMapper;
    private final ReaderTypeMapper readerTypeMapper;

    @Autowired
    public ReaderServiceImpl(ReaderMapper readerMapper, ReaderTypeMapper readerTypeMapper) {
        this.readerMapper = readerMapper;
        this.readerTypeMapper = readerTypeMapper;
    }

    @Override
    public void insertReader(Reader reader) throws CustomException {
        if(reader == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        if(readerMapper.insertSelective(reader) == 0){
            throw new CustomException(CommonError.BUSY_SERVER);
        }
    }

    @Override
    public void deleteReader(String readerbarcode) throws CustomException {
        if(readerbarcode == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        if(readerMapper.deleteByPrimaryKey(readerbarcode)==0){
            throw new CustomException(CommonError.BUSY_SERVER);
        }
    }

    @Override
    public void editReader(Reader reader) throws CustomException {
        if(reader == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        if(readerMapper.updateByPrimaryKeySelective(reader)==0){
            throw new CustomException(CommonError.BUSY_SERVER);
        }
    }

    @Override
    public void insertReaderType(ReaderType readerType) throws CustomException {
        if(readerType == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        if(readerTypeMapper.insertSelective(readerType)==0){
            throw new CustomException(CommonError.BUSY_SERVER);
        }
    }

    @Override
    public void deleteReaderType(Integer id) throws CustomException {
        if(id == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        if(readerTypeMapper.deleteByPrimaryKey(id)==0){
            throw new CustomException(CommonError.BUSY_SERVER);
        }
    }

    @Override
    public void editReaderType(ReaderType readerType) throws CustomException {
        if(readerType == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        if(readerTypeMapper.updateByPrimaryKeySelective(readerType)==0){
            throw new CustomException(CommonError.BUSY_SERVER);
        }
    }

    @Override
    public List<ReaderTableVO> queryReader() throws CustomException {
        List<ReaderTableVO> readerTableVOS = new ArrayList<>();
        List<Reader> readers = readerMapper.queryAllreaders();
        for (Reader reader : readers) {
            ReaderType bookType = readerTypeMapper.selectByPrimaryKey(reader.getReadertype());
            readerTableVOS.add(this.readerConverter(reader,bookType));
        }
        return readerTableVOS;
    }

    @Override
    public List<ReaderType> queryReaderType() throws CustomException {
        return readerTypeMapper.queryAllTypes();
    }

    private ReaderTableVO readerConverter(Reader reader, ReaderType readerType) throws CustomException{
        if(reader == null || readerType == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        ReaderTableVO readerTableVO = new ReaderTableVO();
        try {
            BeanUtils.copyProperties(readerTableVO,reader);
            BeanUtils.copyProperties(readerTableVO,readerType);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return readerTableVO;
    }

}
