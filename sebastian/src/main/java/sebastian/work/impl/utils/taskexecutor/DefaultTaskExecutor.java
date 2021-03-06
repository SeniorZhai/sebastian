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

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RestrictTo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Default Task Executor for executing common tasks in WorkManager
 * @hide
 */

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
public class DefaultTaskExecutor implements TaskExecutor {
    // 单线程Executor
    private final ExecutorService mBackgroundExecutor = Executors.newSingleThreadExecutor();
    private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());

    @Override
    public void postToMainThread(Runnable r) {
        mMainThreadHandler.post(r);
    }

    @Override
    public void executeOnBackgroundThread(Runnable r) {
        mBackgroundExecutor.execute(r);
    }
}
