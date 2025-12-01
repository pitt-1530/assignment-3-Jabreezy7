package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class PlaylistRecommenderTest {

    @Test
    public void testClassifyEnergyNull() {
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.classifyEnergy(null));
    }

    @Test
    public void testClassifyEnergy0() {
        List<Integer> bpms = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.classifyEnergy(bpms));
    }

    @Test
    public void testClassifyEnergyHigh() {
        List<Integer> bpms = new ArrayList<>();
        bpms.add(140);
        bpms.add(140);

        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(bpms));
    }

    @Test
    public void testClassifyEnergyMedium() {
        List<Integer> bpms = new ArrayList<>();
        bpms.add(139);
        bpms.add(139);

        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(bpms));
    }

    @Test
    public void testClassifyEnergyLow() {
        List<Integer> bpms = new ArrayList<>();
        bpms.add(99);
        bpms.add(99);

        assertEquals("LOW", PlaylistRecommender.classifyEnergy(bpms));
    }




    @Test
    public void testisValidTrackTitleNull() {

        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.isValidTrackTitle(null));
    }

    @Test
    public void testisValidTrackTitleValid() {
        String title = "stRangerThiNgsiNtro";

        assertTrue(PlaylistRecommender.isValidTrackTitle(title));
    }

    @Test
    public void testisValidTrackTitleSpecialCharacter() {
        String title = "!stRangerThiNgsiNtro";

        assertFalse(PlaylistRecommender.isValidTrackTitle(title));
    }

    @Test
    public void testisValidTrackTitleShort() {
        String title = "   ";

        assertFalse(PlaylistRecommender.isValidTrackTitle(title));
    }


    @Test
    public void testisValidTrackTitleLong() {
        String title = "abcdefghijklmnopqrstuvwxyzabcde";

        assertFalse(PlaylistRecommender.isValidTrackTitle(title));
    }


    @Test
    public void testNormalizeVolumeInBounds(){
        int volume = 67;
        assertEquals(67, PlaylistRecommender.normalizeVolume(volume));
    }

    @Test
    public void testNormalizeVolumeBelowBound(){
        int volume = -1;
        assertEquals(0, PlaylistRecommender.normalizeVolume(volume));
    }

    @Test
    public void testNormalizeVolumeAboveBound(){
        int volume = 101;
        assertEquals(100, PlaylistRecommender.normalizeVolume(volume));
    }


}
