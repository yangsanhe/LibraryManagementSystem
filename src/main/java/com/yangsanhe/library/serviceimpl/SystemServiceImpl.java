package com.yangsanhe.library.serviceimpl;

import com.yangsanhe.library.dao.AdminMapper;
import com.yangsanhe.library.dao.BookshelfMapper;
import com.yangsanhe.library.dao.LibraryMapper;
import com.yangsanhe.library.dao.PurviewMapper;
import com.yangsanhe.library.entity.Admin;
import com.yangsanhe.library.entity.Bookshelf;
import com.yangsanhe.library.entity.Library;
import com.yangsanhe.library.entity.Purview;
import com.yangsanhe.library.error.CommonError;
import com.yangsanhe.library.error.CustomException;
import com.yangsanhe.library.service.SystemService;
import com.yangsanhe.library.vo.AdminTableVO;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangsanhe
 * @date 2019-12-27 15:15:37
 */
@Service
public class SystemServiceImpl implements SystemService {

    private final LibraryMapper libraryMapper;

    private final AdminMapper adminMapper;

    private final PurviewMapper purviewMapper;

    private final BookshelfMapper bookshelfMapper;

    @Autowired
    public SystemServiceImpl(LibraryMapper libraryMapper, AdminMapper adminMapper, PurviewMapper purviewMapper, BookshelfMapper bookshelfMapper) {
        this.libraryMapper = libraryMapper;
        this.adminMapper = adminMapper;
        this.purviewMapper = purviewMapper;
        this.bookshelfMapper = bookshelfMapper;
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

    @Override
    public void insertManager(Admin admin) throws CustomException {
        if(admin == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        if(adminMapper.insertSelective(admin) == 0){
            throw new CustomException(CommonError.BUSY_SERVER);
        }
    }

    @Override
    public List<AdminTableVO> queryManager() throws CustomException {
        List<AdminTableVO> adminTableVOS = new ArrayList<>();
        List<Admin> adminList = adminMapper.queryAllAdmin();
        for (Admin admin : adminList) {
            Purview purview = purviewMapper.selectByPrimaryKey(admin.getId());
            adminTableVOS.add(this.managerConverter(admin,purview));
        }
        return adminTableVOS;
    }

    @Override
    public void insertBookshelf(Bookshelf bookshelf) throws CustomException {
        if(bookshelf == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        if(bookshelfMapper.insertSelective(bookshelf)==0){
            throw new CustomException(CommonError.BUSY_SERVER);
        }
    }

    @Override
    public void deleteBookshelf(Integer id) throws CustomException {
        if(id == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        if(bookshelfMapper.deleteByPrimaryKey(id)==0){
            throw new CustomException(CommonError.BUSY_SERVER);
        }
    }

    @Override
    public void editBookshelf(Bookshelf bookshelf) throws CustomException {
        if(bookshelf == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        if(bookshelfMapper.updateByPrimaryKeySelective(bookshelf)==0){
            throw new CustomException(CommonError.BUSY_SERVER);
        }
    }

    @Override
    public List<Bookshelf> queryBookShelf() throws CustomException {
        return bookshelfMapper.queryAllbookshelves();
    }

    private AdminTableVO managerConverter(Admin admin, Purview purview){
        if(admin == null || purview == null){
            throw new CustomException(CommonError.INVALID_PARAM);
        }
        AdminTableVO adminTableVO = new AdminTableVO();
        try {
            BeanUtils.copyProperties(adminTableVO,admin);
            BeanUtils.copyProperties(adminTableVO,purview);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return adminTableVO;
    }
}
