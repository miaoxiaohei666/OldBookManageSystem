package ccnu.cs.c2.g8.oldbookmanagesystem.controller;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.middle.Sort;
import ccnu.cs.c2.g8.oldbookmanagesystem.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SortController {
    @Autowired
    SortService sortService;

    @RequestMapping(value = "/admin/sort/add")
    public String sortAdd(Sort sort) {
        try {
            if (sortService.addSort(sort)) return "/index";
        } catch (Exception e) {
            System.out.println("sortAdd wrong!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping(value = "/admin/sort/delete")
    public String sortDelete(@RequestParam(name = "sname") String sname) {
        try {
            if (sortService.deleteSortbySname(sname)) return "redirect:/BookSort";
        } catch (Exception e) {
            System.out.println("sortDelete wrong!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping(value = "/admin/sort/all")
    public String getAllSorts(Model model) {
        try {
            model.addAttribute("getAllBookSort", sortService.getAllSort());
            return "/BookSort";
        } catch (Exception e) {
            System.out.println("getAllSorts wrong!");
            e.printStackTrace();
        }
        return "/error";
    }

    @RequestMapping(value = "/user/sort/allsortsbygrade")
    public String geAllSortBySgrade(Model model, @RequestParam(name = "sgrade") String sgrade) {
        try {
            model.addAttribute("getBookPublish", sortService.getAllSortBySgrade(sgrade));
            return "/index";
        } catch (Exception e) {
            System.out.println("geAllSortbySgrade wrong!");
            e.printStackTrace();
        }
        return "/error";
    }
}
