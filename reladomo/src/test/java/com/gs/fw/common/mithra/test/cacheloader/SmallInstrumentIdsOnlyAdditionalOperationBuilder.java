/*
 Copyright 2016 Goldman Sachs.
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 */

package com.gs.fw.common.mithra.test.cacheloader;


import com.gs.fw.common.mithra.attribute.IntegerAttribute;
import com.gs.fw.common.mithra.cacheloader.AdditionalOperationBuilder;
import com.gs.fw.common.mithra.finder.Operation;
import com.gs.fw.common.mithra.finder.RelatedFinder;

import java.sql.Timestamp;

public class SmallInstrumentIdsOnlyAdditionalOperationBuilder implements AdditionalOperationBuilder
{
    @Override
    public Operation buildOperation(Timestamp businessDate, RelatedFinder relatedFinder)
    {
        IntegerAttribute instrumentId = (IntegerAttribute) relatedFinder.getAttributeByName("instrumentId");
        return instrumentId.lessThan(3);
    }

    @Override
    public boolean isBusinessDateInvariant()
    {
        return true;
    }
}
