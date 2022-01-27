package com.appknot.mentore.model

/**
 *
 * @author Ethan on 2022-01-26
 */
data class IssueData(
    val landscape: Int = 0,
    override val id: String?,
    override val x: Float?,
    override val y: Float?,
    override val width: Float?,
    override val height: Float?,
    override val alpha: Float?,
    override val layer: Int?,
    override val delay: Int?,
    override val radius: Int?,
    override val didscroll: String?,
    override val notouch: Int?,
    override val lock: Int?,
    override val onload: String?
) : DefaultData()