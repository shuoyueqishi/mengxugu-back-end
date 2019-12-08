package com.xlt.myproject.service.api;

import com.xlt.myproject.model.Member;
import com.xlt.myproject.model.MemberResponse;
import com.xlt.myproject.model.Page;
import com.xlt.myproject.service.impl.MemberServiceImpl;

import java.util.List;

public interface ImemberService {
    MemberResponse findMemberPageList(Member member, Page page);

    MemberResponse deleteMember(int id);

    MemberResponse addNewMember(Member member);

    MemberResponse updateMember(Member member);
}
