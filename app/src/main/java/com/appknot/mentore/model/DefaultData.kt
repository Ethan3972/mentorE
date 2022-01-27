package com.appknot.mentore.model

import java.io.Serializable

/**
 *
 * @author Ethan on 2022-01-26
 */
abstract class DefaultData: Serializable {
    abstract val id: String?
    abstract val x: Float?
    abstract val y: Float?
    abstract val width: Float?
    abstract val height: Float?
    abstract val alpha: Float?
    abstract val layer: Int?
    abstract val delay: Int?
    abstract val radius: Int?
    abstract val didscroll: String?
    abstract val notouch: Int?
    abstract val lock: Int?
    abstract val onload: String?
}