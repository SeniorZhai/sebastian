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
 * The type of network required by a unit of work.
 * 网络状态
 */
public enum NetworkType {

    /**
     * A network is not required for this work.
     * 不需要网络
     */
    NOT_REQUIRED,

    /**
     * Any working network connection is required for this work.
     * 任何可用网络
     */
    CONNECTED,

    /**
     * An unmetered network connection is required for this work.
     * 不计费网络 如WIFI
     */
    UNMETERED,

    /**
     * A non-roaming network connection is required for this work.
     * 非漫游网络
     */
    NOT_ROAMING,

    /**
     * A metered network connection is required for this work.
     * 计费网络 如4G
     */
    METERED
}
