package com.xlt.myproject.controller;

import com.xlt.myproject.model.Member;
import com.xlt.myproject.model.MemberResponse;
import com.xlt.myproject.model.Page;
import com.xlt.myproject.service.api.ImemberService;
import com.xlt.myproject.service.impl.MemberServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces="application/json")
    public MemberResponse deleteMemberById(@PathVariable("id")int id) {
        return memberServiceImpl.deleteMember(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces="application/json")
    public MemberResponse updateMember(@RequestBody Member member) {
        return memberServiceImpl.updateMember(member);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces="application/json")
    public MemberResponse addMember(@RequestBody()Member member) {
        return memberServiceImpl.addNewMember(member);
    }
}
