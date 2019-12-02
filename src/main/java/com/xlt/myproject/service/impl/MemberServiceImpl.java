package com.xlt.myproject.service.impl;

import com.xlt.myproject.constant.Constant;
import com.xlt.myproject.mapper.ImemberDao;
import com.xlt.myproject.model.Member;
import com.xlt.myproject.model.MemberResponse;
import com.xlt.myproject.model.Page;
import com.xlt.myproject.service.api.ImemberService;
import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberService")
@MapperScan("com.xlt.myproject.mapper")
public class MemberServiceImpl implements ImemberService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private ImemberDao memberDao;
    @Override
    public MemberResponse findMemberPageList(Member member, Page page) {
        MemberResponse response = new MemberResponse();
        logger.info("MemberServiceImpl.findMemberPageList input info:"+member);
        try{
            int totals = memberDao.findMemberPageListCount(member);
            page.setTotal(totals);
            int totalPages = page.getTotalPages();
            logger.info("totalPages="+totalPages);
            List<Member> list = memberDao.findMemberPageList(member,page);
            response.setResult(list);
            response.setPage(page);
            response.setCode("success");
            response.setStatus(Constant.Status.SUCCESS);
            response.setMessage(list.size()+" member infos has found in this query.");
        }catch (ApplicationException e) {
            logger.error("memberDao.findMemberPageList encounter error:",e);
            response.setCode("error.code.findMemberPageList.001");
            response.setStatus(Constant.Status.FAIL);
            response.setMessage("memberDao.findMemberPageList encounter error:"+e.toString());
        }
        return response;
    }
}
