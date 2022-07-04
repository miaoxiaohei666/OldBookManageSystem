package ccnu.cs.c2.g8.oldbookmanagesystem.service;

import ccnu.cs.c2.g8.oldbookmanagesystem.dao.BookDao;
import ccnu.cs.c2.g8.oldbookmanagesystem.dao.SortDao;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;
@Service
public class SortService {
    @Autowired
    private SortDao sortDao;
    @Autowired
    private BookDao bookDao;

    public List<Sort> getAllSort() {
        try {
            List<Sort> s=sortDao.findAll();
            System.out.println(s.isEmpty()+"sorts");
            return s;
        } catch (Exception e) {
            System.out.println("getAllSort wrong!");
            e.printStackTrace();
        }
        return null;
    }

    public List<Sort> getAllSortBySgrade(String sgrade){
        try{
            List<Sort> sortList=sortDao.getSortsBySgrade(sgrade);
            if(!sortList.isEmpty())
                return sortList;
        }catch (Exception e){
            System.out.println("getAllSortBysgrade wrong!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean addSort(Sort sort) {
        boolean flag = false;
        try {
            sortDao.save(sort);
            flag = true;
        } catch (Exception e) {
            System.out.println("addSort wrong!");
            e.printStackTrace();
        }
        return flag;
    }
    @Transactional
    public boolean deleteSortbySname(String sname) {
        boolean flag = false;
        try {
            Sort sort = sortDao.getSortBySname(sname);
            List<Book> book =bookDao.getBookBySno(sort.getSno());
            Iterator<Book> itr=book.listIterator();
            if(book.isEmpty()) {
                System.out.println(sort.getSno().toString());
                sortDao.deleteBySno(sort.getSno());
                flag = true;
            }
            else {
                while(itr.hasNext()){
                    Integer bno=itr.next().getBno();
                    System.out.println(bno.toString());
                    bookDao.deleteBookByBno(bno);
                }
            }
        } catch (Exception e) {
            System.out.println("deleteSort wrong!");
            e.printStackTrace();
        }
        return flag;
    }

}
