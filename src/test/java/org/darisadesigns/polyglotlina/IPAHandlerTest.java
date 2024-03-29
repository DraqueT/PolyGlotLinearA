/*
 * Copyright (c) 2019, draque
 * All rights reserved.
 *
 * Licensed under: Creative Commons Attribution-NonCommercial 4.0 International Public License
 *  See LICENSE.TXT included with this code to read the full license agreement.

 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.darisadesigns.polyglotlina;

import java.lang.reflect.Field;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author draque
 */
public class IPAHandlerTest {
    
    public IPAHandlerTest() {
    }

    @Test
    public void testPlayAllSounds() throws Exception {
        System.out.println("test all sound assets");
        IPAHandler handler = new IPAHandler(null);
        
        Class<?> classs = handler.getClass();
        Field field = classs.getDeclaredField("charMap");
        field.setAccessible(true);
        Map<String, String> charMap = (Map<String, String>)field.get(handler);
        
        field = classs.getDeclaredField("soundRecorder");
        field.setAccessible(true);
        SoundRecorder soundRecorder = (SoundRecorder)field.get(handler);
        
        String results = "";
        String expectedResults = "";
        
        // only test playing the first sounds of each library (just test the rest exist)
        String firstSound = (String)charMap.values().toArray()[0];
        soundRecorder.playAudioFile(PGTUtil.ipaSoundsLocation + PGTUtil.ucla_location + firstSound + PGTUtil.wavSuffix);
        soundRecorder.playAudioFile(PGTUtil.ipaSoundsLocation + PGTUtil.ucla_location + firstSound + PGTUtil.wavSuffix);
        
        for (String soundName : charMap.values()) {
            String sound = "";
            try {
                System.out.println(PGTUtil.ucla_location + soundName + PGTUtil.wavSuffix);
                sound = PGTUtil.ipaSoundsLocation + PGTUtil.ucla_location + soundName + PGTUtil.wavSuffix;
                assertNotEquals(sound, null);
            } catch (Exception e) {
                System.out.println("FAILED: " + sound);
                results += sound + e.getLocalizedMessage() + "\n";
            }
        }
        
        for (String soundName : charMap.values()) {
            String sound = "";
            try {
                System.out.println(PGTUtil.wiki_location + soundName + PGTUtil.wavSuffix);
                sound = PGTUtil.ipaSoundsLocation + PGTUtil.wiki_location + soundName + PGTUtil.wavSuffix;
                assertNotEquals(sound, null);
            } catch (Exception e) {
                System.out.println("FAILED: " + sound);
                results += sound + e.getLocalizedMessage() + "\n";
            }
        }
        
        assertEquals(expectedResults, results);
    }
    
}
