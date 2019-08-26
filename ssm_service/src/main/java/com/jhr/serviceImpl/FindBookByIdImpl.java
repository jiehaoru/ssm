package com.jhr.serviceImpl;

import com.jhr.bo.BookBO;
import com.jhr.dao.BookMapper;
import com.jhr.FindBookById;
import com.jhr.po.Book;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <br>
 * 标题：
 * 描述：
 *
 * @author jhr
 * @create 2019/08/20 11:33
 */
@Service
public class FindBookByIdImpl implements FindBookById {
    @Autowired
    private BookMapper bookMapper;


    @Override
    public BookBO findBookById(BookBO bookBO) {
        BookBO bo=new BookBO();
        Integer bookId=0 ;
        if(bookBO.getBookId()!=null){
            bookId =bookBO.getBookId();
        }
        Book book = bookMapper.selectByPrimaryKey(bookId);
        BeanUtils.copyProperties(book,bo);
        return bo;
    }
}
