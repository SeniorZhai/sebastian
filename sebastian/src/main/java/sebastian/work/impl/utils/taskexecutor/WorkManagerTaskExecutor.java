/*
 * Copyright 2017 The Android Open Source Project
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

package sebastian.work.impl.utils.taskexecutor;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/**
 * A static class that serves as a central point to execute common tasks in WorkManager.
 * This is used for business logic internal to WorkManager and NOT for worker processing.
 * Adapted from {@link android.arch.core.executor.ArchTaskExecutor}
 * @hide
 */

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
public class WorkManagerTaskExecutor implements TaskExecutor {
    private static WorkManagerTaskExecutor sInstance;
    // 默认的任务执行器
    private final TaskExecutor mDefaultTaskExecutor = new DefaultTaskExecutor();
    private TaskExecutor mTaskExecutor = mDefaultTaskExecutor;

    /**
     * Returns an instance of the task executor.
     * @return The singleton WorkManagerTaskExecutor.
     */
    public static synchronized WorkManagerTaskExecutor getInstance() {
        if (sInstance == null) {
            sInstance = new WorkManagerTaskExecutor();
        }
        return sInstance;
    }

    private WorkManagerTaskExecutor() {
    }

    /**
     * Overrides the task executor used by {@link sebastian.work.impl.WorkManagerImpl}.
     *
     * @param taskExecutor The instance of the {@link TaskExecutor}.
     * 设置TaskExecutor
     */
    public void setTaskExecutor(@Nullable TaskExecutor taskExecutor) {
        mTaskExecutor = taskExecutor == null ? mDefaultTaskExecutor : taskExecutor;
    }

    // 在主线程中执行
    @Override
    public void postToMainThread(Runnable r) {
        mTaskExecutor.postToMainThread(r);
    }

    // 在后台执行
    @Override
    public void executeOnBackgroundThread(Runnable r) {
        mTaskExecutor.executeOnBackgroundThread(r);
    }
}
