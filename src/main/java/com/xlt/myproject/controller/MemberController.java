package com.xlt.myproject.controller;

import com.xlt.myproject.model.Member;
import com.xlt.myproject.model.MemberResponse;
import com.xlt.myproject.model.Page;
import com.xlt.myproject.service.api.ImemberService;
import com.xlt.myproject.service.impl.MemberServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="memberController")
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberServiceImpl memberServiceImpl;

    @RequestMapping(value = "/list/{pageSize}/{currentPage}", method = RequestMethod.GET, produces="application/json")
    public MemberResponse getMemberPageList(@Param("member") Member member, @PathVariable("pageSize")int pageSize, @PathVariable("currentPage") int currentPage) {
        Page page = new Page();
        page.setPageSize(pageSize);
        page.setCurrentPage(currentPage);
        return memberServiceImpl.findMemberPageList(member,page);
    }
}
