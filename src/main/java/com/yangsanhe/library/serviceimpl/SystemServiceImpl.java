package com.yangsanhe.library.serviceimpl;

import com.yangsanhe.library.dao.LibraryMapper;
import com.yangsanhe.library.entity.Library;
import com.yangsanhe.library.error.CommonError;
import com.yangsanhe.library.error.CustomException;
import com.yangsanhe.library.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangsanhe
 * @date 2019-12-27 15:15:37
 */
@Service
public class SystemServiceImpl implements SystemService {

    private final LibraryMapper libraryMapper;

    @Autowired
    public SystemServiceImpl(LibraryMapper libraryMapper) {
        this.libraryMapper = libraryMapper;
    }

    @Override
    public Library getLibraryInfo() {
        return libraryMapper.selectByPrimaryKey(1);
    }

    @Override
    public void updateLibraryInfo(Library library) throws CustomException {
        if(library == null || library.getLiraryId() == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        if(libraryMapper.updateByPrimaryKeySelective(library)==0){
            throw new CustomException(CommonError.BUSY_SERVER);
        }
    }
}
