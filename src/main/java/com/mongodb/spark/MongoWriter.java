/*
 * Copyright (c) 2008-2015 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mongodb.spark;

import java.util.Iterator;

/**
 * Interface for classes writing partitions to mongo collections.
 *
 * @param <T> the class of objects in the partition
 */
public interface MongoWriter<T> {
    /**
     * Possible write modes:
     *
     * SIMPLE:                 insertion
     * BULK_ORDERED_REPLACE:   upsert with replacement
     * BULK_ORDERED_UPDATE:    upsert with update
     * BULK_UNORDERED_REPLACE: upsertion with replacement
     * BULK_UNORDERED_UPDATE:  upsertion with update
     */
    enum WriteMode {
        SIMPLE, BULK_ORDERED_REPLACE, BULK_ORDERED_UPDATE, BULK_UNORDERED_REPLACE, BULK_UNORDERED_UPDATE
    }

    /**
     * Write the elements of the iterator to a location.
     *
     * @param iterator typically the elements of an RDD partition
     */
    void write(final Iterator<T> iterator);
}