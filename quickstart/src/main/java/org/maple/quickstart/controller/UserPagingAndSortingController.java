package org.maple.quickstart.controller;

import org.maple.quickstart.dao.UserPagingAndSortingRepository;
import org.maple.quickstart.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther Mapleins
 * @date 2019-07-16 15:31
 * @Description
 */
@Controller
@RequestMapping("userPas")
public class UserPagingAndSortingController {

    @Autowired
    private UserPagingAndSortingRepository userPagingAndSortingRepository;

    @GetMapping("page")
    @ResponseBody
    public Page<User> getAllUserByPage() {
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.Direction.DESC, "id");
        return userPagingAndSortingRepository.findAll(pageRequest);
    }

    @GetMapping("sort")
    @ResponseBody
    public Iterable<User> getAllUserBySort() {
        return userPagingAndSortingRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
    }

}
