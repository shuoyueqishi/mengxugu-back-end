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
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.security.auth.login.FailedLoginException;
import java.util.List;

@Service("memberService")
@MapperScan("com.xlt.myproject.mapper")
public class MemberServiceImpl implements ImemberService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private ImemberDao memberDao;

    @Override
    public MemberResponse addNewMember(Member member) {
        MemberResponse response = new MemberResponse();
        if (StringUtils.isEmpty(member.getCardNumber()) || StringUtils.isEmpty(member.getName())) {
            response.setStatus(Constant.Status.FAIL);
            response.setMessage("Card Number and Name can't be empty.");
            return response;
        }
        try {
            List<Member> list = memberDao.findMemberByNumAndName(member);
            if (CollectionUtils.isEmpty(list)) {
                memberDao.addMember(member);
                response.setStatus(Constant.Status.SUCCESS);
                response.setMessage("Add new employee successfully.");
            } else {
                response.setStatus(Constant.Status.FAIL);
                response.setMessage("Card Number:"+member.getCardNumber()+", Name:"+member.getName()+" has exist in the system.");
            }
        } catch (ApplicationException e) {
            logger.error("Query database encounter error in addNewMember:",e);
            response.setStatus(Constant.Status.FAIL);
            response.setMessage("Query database encounter error in addNewMember");
        }
        return response;
    }

    @Override
    public MemberResponse updateMember(Member member) {
        MemberResponse response = new MemberResponse();
        if (member.getId() == null) {
            response.setStatus(Constant.Status.FAIL);
            response.setMessage("Id can't be empty for updating member info.");
            return response;
        }
        try {
            memberDao.updateMember(member);
            response.setMessage("update member info successfully.");
            response.setStatus(Constant.Status.SUCCESS);
        } catch(ApplicationException e) {
            response.setStatus(Constant.Status.FAIL);
            response.setMessage("update database encounter error.");
            logger.error("update database encounter error:",e);
        }
        return response;
    }

    @Override
    public MemberResponse deleteMember(int id) {
        MemberResponse response = new MemberResponse();
        try{
            memberDao.deleteMemberById(id);
            response.setMessage("Delete member by id: "+id+" successfully.");
            response.setStatus(Constant.Status.SUCCESS);
        }catch (ApplicationException e) {
            logger.error("MemberServiceImpl.deleteMember encounter error:",e);
            response.setMessage("Fail to delete member by id:"+id);
            response.setStatus(Constant.Status.FAIL);
        }
        return response;
    }

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
