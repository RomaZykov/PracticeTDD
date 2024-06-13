package com.github.johnnysc.practicetdd

import kotlin.math.max

interface MyStack {
    class FIFO<T>(private val maxCount: Int) : MyStack {

        private var popCalled = 0
        private var pushCalled = 0
        private val mutableList = mutableListOf<CustomObject>()

        init {
            if (this.maxCount <= 0) {
                throw IllegalStateException()
            }
        }

        override fun push(item: CustomObject): List<CustomObject> {
            ++pushCalled
            mutableList.add(item)
            return mutableList
        }

        override fun pop(): CustomObject {
            ++popCalled
            if ((maxCount == 1 && mutableList.isEmpty()) || popCalled > maxCount) {
                throw IllegalStateException()
            }
            val savedObject = mutableList.first()
            mutableList.removeFirst()
            --popCalled
            return savedObject
        }
    }

    class LIFO<T>(private val maxCount: Int) : MyStack {

        private var popCalled = 0
        private var pushCalled = 0
        private val mutableList = mutableListOf<CustomObject>()

        init {
            if (this.maxCount <= 0) {
                throw IllegalStateException()
            }
        }

        override fun push(item: CustomObject): List<CustomObject> {
            ++pushCalled
            mutableList.add(item)
            return mutableList
        }

        override fun pop(): CustomObject {
            ++popCalled
            if ((maxCount == 1 && mutableList.isEmpty()) || popCalled > maxCount) {
                throw IllegalStateException()
            }
            val savedObject = mutableList.last()
            mutableList.removeLast()
            --popCalled
            return savedObject
        }
    }

    fun pop(): CustomObject

    fun push(item: CustomObject): List<CustomObject>
}

data class CustomObject(val id: String)
