package com.xlt.myproject.service.api;

import com.xlt.myproject.model.Member;
import com.xlt.myproject.model.MemberResponse;

public interface ImemberService {
    MemberResponse findMemberPageList(Member member);
}
