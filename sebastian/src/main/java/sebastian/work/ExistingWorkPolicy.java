/*
 * Copyright 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sebastian.work;

/**
 * An enum that determines what to do with existing {@link OneTimeWorkRequest}s with the same unique
 * name in case of a collision.
 */
public enum ExistingWorkPolicy {

    /**
     * If there is existing pending work with the same unique name, cancel and delete it.  Then,
     * insert the newly-specified work.
     * 如果存在相同任务替换它
     */
    REPLACE,

    /**
     * If there is existing pending work with the same unique name, do nothing.  Otherwise, insert
     * the newly-specified work.
     * 有相同任务 什么都不做
     */
    KEEP,

    /**
     * If there is existing pending work with the same unique name, append the newly-specified work
     * as a child of all the leaves of that work sequence.  Otherwise, insert the newly-specified
     * work as the start of a new sequence.
     * 有相同任务时 以新加入的任务为第一个任务
     */
    APPEND
}
