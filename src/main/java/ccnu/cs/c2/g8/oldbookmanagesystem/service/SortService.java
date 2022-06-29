package ccnu.cs.c2.g8.oldbookmanagesystem.service;

import ccnu.cs.c2.g8.oldbookmanagesystem.dao.BookDao;
import ccnu.cs.c2.g8.oldbookmanagesystem.dao.SortDao;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Sort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SortService {
    @Autowired
    private SortDao sortDao;
    @Autowired
    private BookDao bookDao;

    public boolean getAllSort(){
        boolean flag=false;
        try{
            sortDao.getAll();
            flag=true;
        }catch (Exception e){
            System.out.println("getAllSort wrong!");
            e.printStackTrace();
        }
        return flag;
    }

    public List<Book> getAllBook(Integer sno){
            return bookDao.getBookBySno(sno);
    }

    public boolean addSort(Sort sort){
        boolean flag=false;
        try{
            sortDao.save(sort);
            flag=true;
        }catch (Exception e){
            System.out.println("addSort wrong!");
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteSortbySname(String sname){
        boolean flag=false;
        try{
            Sort sort=new Sort();
            sort.setSname(sname);
            sort.setSno(sortDao.getSortBySname(sname));
            sortDao.delete(sort);
            flag=true;
        }catch (Exception e){
            System.out.println("deleteSort wrong!");
            e.printStackTrace();
        }
        return flag;
    }

}
