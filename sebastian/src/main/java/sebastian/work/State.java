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
 * The current status of a unit of work.
 * work状态
 */
public enum State {

    /**
     * The status for work that is enqueued (hasn't completed and isn't running)
     * 排队中 没完成 没运行
     */
    ENQUEUED,

    /**
     * The status for work that is currently being executed
     * 运行中
     */
    RUNNING,

    /**
     * The status for work that has completed successfully
     * 成功
     */
    SUCCEEDED,

    /**
     * The status for work that has completed in a failure state
     * 错误
     */
    FAILED,

    /**
     * The status for work that is currently blocked because its prerequisites haven't finished
     * successfully
     * 阻止 其先决条件没有完成
     */
    BLOCKED,

    /**
     * The status for work that has been cancelled and will not execute
     * 取消
     */
    CANCELLED;

    /**
     * Returns {@code true} if this State is considered finished.
     * 是否结束 成功、失败、取消
     * @return {@code true} for {@link #SUCCEEDED}, {@link #FAILED}, and {@link #CANCELLED} States
     */
    public boolean isFinished() {
        return (this == SUCCEEDED || this == FAILED || this == CANCELLED);
    }
}
