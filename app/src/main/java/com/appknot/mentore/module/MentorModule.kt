package com.appknot.mentore.module

import android.content.res.XmlResourceParser
import com.appknot.mentore.model.IssueData
import com.appknot.mentore.model.PageFormationData
import com.appknot.mentore.parse
import org.xmlpull.v1.XmlPullParser

/**
 *
 * @author Ethan on 2022-01-26
 */
class MentorModule(private val mentorListener: MentorListener) {

    fun readXmlData(parser: XmlResourceParser) {
        try {
            while (parser.eventType != XmlPullParser.END_DOCUMENT) {
                when (parser.eventType) {
                    // 데이터 전달 (따로 시작을 알리지 않음)
                    XmlPullParser.START_TAG -> putData(parser)

                    /**
                     * 종료 태그 전달
                     * TODO::현재 페이지 테스트만 진행 중, object까지 읽은 후 페이지별로 정리한 후 adapter에 추가 예정
                     */
                    XmlPullParser.END_TAG -> mentorListener.closeTagListener(parser.name)
                }
                parser.next()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * parser 데이터 읽고 listener에 전달
     */
    private fun putData(parser: XmlResourceParser) {
        var json = "{"

        for (i in 0 until parser.attributeCount) {
            json += " ${parser.getAttributeName(i)}: ${parser.getAttributeValue(i)}"
            json += if (i != parser.attributeCount - 1) {
                ",\n"
            } else {
                "\n}"
            }
        }

        when (parser.name) {
            TAG_ISSUE -> mentorListener.issueListener(json.parse(IssueData::class.java))
            TAG_PAGE_FORMATION -> mentorListener.pageListener(json.parse(PageFormationData::class.java))
        }
    }

    companion object {
        const val TAG_APPKNOT = "appknot"
        const val TAG_INFO = "info"
        const val TAG_ISSUE = "issue"
        const val TAG_PAGE_FORMATIONS = "pageFormations"
        const val TAG_PAGE_FORMATION = "pageFormation"
        const val TAG_PAGE_OBJECTS = "pageObjects"
        const val TAG_PAGE_OBJECT = "page"
        const val TAG_VIDEO = "video"
        const val TAG_IMAGE = "image"
        const val TAG_WEB = "web"
        const val TAG_PDF = "pdf"
        const val TAG_TEXT = "text"
        const val TAG_GESTURE_RECOGNIZER = "gestureRecognizer"
        const val TAG_FRAME = "frame"
        const val TAG_OPTIONAL = "optional"
        const val TAG_VR = "vrview"
        const val TAG_EVENTS = "events"
        const val TAG_EVENT = "event"
    }
}