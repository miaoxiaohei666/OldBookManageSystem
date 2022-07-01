package ccnu.cs.c2.g8.oldbookmanagesystem.controller;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Sort;
import ccnu.cs.c2.g8.oldbookmanagesystem.service.SortService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SortController {
    SortService sortService;

    @RequestMapping(value = "admin/sort/add", method = RequestMethod.POST)
    public String addnewsort(@RequestBody Sort sort){
        System.out.println("add new sort");
        boolean flag=sortService.addSort(sort);
        if(flag)
            return "admin/sort";
        else
            return "admin/sort/add";
    }

    @RequestMapping(value = "admin/sort/delete", method = RequestMethod.POST)
    public String deleteoldsort(@RequestParam(name = "sname") String sname){
        System.out.println("delete sort");
        boolean flag=sortService.deleteSortbySname(sname);
        if(flag)
            return "admin/sort";
        else
            return "adminsort/delete";
    }

    @RequestMapping(value = "admin/sort/all", method = RequestMethod.GET)
    public String getAllsorts(){
        System.out.println("get all sorts");
        List<Sort> sortlist=sortService.getAllSort();
        if(!sortlist.isEmpty())
            return "admin/sort";
        else
            return "admin/sort/all";
    }

    @RequestMapping(value = "user/sort/allbysno", method = RequestMethod.GET)
    public String getAllbySno(@RequestParam(name = "sno") Integer sno){
        System.out.println("get all by sno");
        List<Book> booklist=sortService.getAllBookBysno(sno);
        if(!booklist.isEmpty())
            return "user/sort";
        else
            return "user/sort/allbysno";
    }


    @RequestMapping(value = "user/sort/allsortsbygrade", method = RequestMethod.GET)
    public String geAllSortbySgrade(@RequestParam(name = "sgrade") String sgrade){
        System.out.println("get all sorts by sgrade");
        List<Sort> sortList=sortService.getAllSortBysgrade(sgrade);
        if(!sortList.isEmpty())
            return "user/sort";
        else
            return "user/sort/allsortsbygrade";
    }
}
