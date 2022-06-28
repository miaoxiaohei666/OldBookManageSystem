package ccnu.cs.c2.g8.oldbookmanagesystem.biz;

import ccnu.cs.c2.g8.oldbookmanagesystem.dao.BookDao;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class BookBiz {
    @Autowired
    private BookDao bookDao;

    public boolean addbook(Book book){
        boolean flag = false;
        try{
            bookDao.save(book);
            flag=true;
        }catch(Exception e){
            System.out.println("新增失败!");
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deletebook(String Bno){
        boolean flag = false;
        try{
            bookDao.deleteById(Integer.valueOf(Bno));
            flag=true;
        }catch(Exception e){
            System.out.println("删除失败!");
            e.printStackTrace();
        }
        return flag;
    }

    public boolean updateBprice(String bno, Double price){
        boolean flag = false;
        try{
            bookDao.updateBookBpriceByUno(bno, price);
            flag=true;
        }catch(Exception e){
            System.out.println("修改失败!");
            e.printStackTrace();
        }
        return flag;
    }

    public boolean updateBdescribe(String bno, String describe){
        boolean flag = false;
        try{
            bookDao.updateBookBdescribeByUno(bno, describe);
            flag=true;
        }catch(Exception e){
            System.out.println("修改失败!");
            e.printStackTrace();
        }
        return flag;
    }

    public boolean updateBstate(String bno, boolean state){
        boolean flag = false;
        try{
            bookDao.updateBookBstateByUno(bno, state);
            flag=true;
        }catch(Exception e){
            System.out.println("修改失败!");
            e.printStackTrace();
        }
        return flag;
    }

}
