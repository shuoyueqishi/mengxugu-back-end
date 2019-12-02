package com.xlt.myproject.service.api;

import com.xlt.myproject.model.Member;
import com.xlt.myproject.model.MemberResponse;
import com.xlt.myproject.model.Page;

public interface ImemberService {
    MemberResponse findMemberPageList(Member member, Page page);
}
