/* 
 * Copyright 2016 OpenMarket Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.matrix.androidsdk.rest.model.crypto;

import android.text.TextUtils;
import java.util.Map;

/**
 This class represents the response to /keys/upload request made by uploadKeys.
 */
public class KeysUploadResponse {

    /**
     The count per algorithm as returned by the homeserver: a map (algorithm->count).
     */
    public Map<String, Integer> oneTimeKeyCounts;

    /**
     * Helper methods to extract information from 'oneTimeKeyCounts'
     * @param algorithm the expected algorithm
     * @return the time key counts
     */
    public Integer oneTimeKeyCountsForAlgorithm(String algorithm) {
        Integer res = null;

        if ((null != oneTimeKeyCounts) && !TextUtils.isEmpty(algorithm)) {
            res = oneTimeKeyCounts.get(algorithm);
        }

        return res;
    }
}
