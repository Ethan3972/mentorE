package com.appknot.mentore.module

import com.appknot.mentore.model.IssueData
import com.appknot.mentore.model.PageFormationData

/**
 * xml 파싱 콜백
 * @author Ethan on 2022-01-26
 */
interface MentorListener {
    /**
     * 파싱 끝난 태그 콜백
     */
    fun closeTagListener(tag: String) {}

    /**
     * 이슈
     */
    fun issueListener(issue: IssueData) {}

    /**
     * 페이지
     */
    fun pageListener(pageFormation: PageFormationData) {}

    /**
     * 오브젝트
     */
    fun objectListener() {}

    /**
     * 이벤트
     */
    fun eventListener() {}

}