package com.yangsanhe.library.service;

import com.yangsanhe.library.entity.Admin;
import com.yangsanhe.library.entity.Bookshelf;
import com.yangsanhe.library.entity.Library;
import com.yangsanhe.library.error.CustomException;
import com.yangsanhe.library.vo.AdminTableVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author yangsanhe
 * @date 2019-12-27 15:15:07
 */
@Service
public interface SystemService {

    /**
     * 获取图书馆信息
     * @return library
     */
    Library getLibraryInfo();

    /**
     * 更新图书馆信息
     * @param library 图书馆
     * @throws CustomException 自定义异常 {@link CustomException}
     */
    void updateLibraryInfo(Library library) throws CustomException;

    void insertManager(Admin admin) throws CustomException;

    List<AdminTableVO> queryManager() throws CustomException;

    String getPasswordByAdminName(String username) throws CustomException;

    Set<String> getAuthByAdminName(String username) throws CustomException;

    void insertBookshelf(Bookshelf bookshelf) throws CustomException;

    void deleteBookshelf(Integer id) throws CustomException;

    void editBookshelf(Bookshelf bookshelf) throws CustomException;

    List<Bookshelf> queryBookShelf() throws CustomException;

}
