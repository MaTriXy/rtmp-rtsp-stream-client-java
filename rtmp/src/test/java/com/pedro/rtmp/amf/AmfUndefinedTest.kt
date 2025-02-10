/*
 * Copyright (C) 2024 pedroSG94.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pedro.rtmp.amf

import com.pedro.rtmp.amf.v0.AmfData
import com.pedro.rtmp.amf.v0.AmfUndefined
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

/**
 * Created by pedro on 10/9/23.
 */
class AmfUndefinedTest {

  @Test
  fun `GIVEN a buffer WHEN read buffer THEN get expected amf undefined`() {
    val buffer = byteArrayOf(0x06)

    val input = ByteArrayInputStream(buffer)
    val amfUndefined = AmfData.getAmfData(input)

    assertTrue(amfUndefined is AmfUndefined)
  }

  @Test
  fun `GIVEN a amf undefined WHEN write in a buffer THEN get expected buffer`() {
    val expectedBuffer = byteArrayOf(0x06)
    val output = ByteArrayOutputStream()

    val amfUndefined = AmfUndefined()
    amfUndefined.writeHeader(output)
    amfUndefined.writeBody(output)

    assertArrayEquals(expectedBuffer, output.toByteArray())
  }
}