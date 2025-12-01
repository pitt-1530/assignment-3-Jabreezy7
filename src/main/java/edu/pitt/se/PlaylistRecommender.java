package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        if(bpms == null || bpms.size() == 0){
            throw new IllegalArgumentException("List is null or empty");
        }

        int sum = 0;
        for(int bpm: bpms){
            sum += bpm;
        }
        int average = sum / bpms.size();

        if(average >= 140){
            return "HIGH";
        }

        if(average >= 100 && average <= 139){
            return "MEDIUM";
        }

        return "LOW";
    
    }

    public static boolean isValidTrackTitle(String title) {
        if(title == null){
            throw new IllegalArgumentException("title is null");
        }
        int charCount = 0;

        for(int i = 0; i < title.length(); i++){
            char c = title.charAt(i);
            if( ((int)c >= (int)'a' && (int)c <= (int)'z') ||
                ((int)c >= (int)'A' && (int)c <= (int)'Z') ){
                    charCount += 1;
                }

            else if(c != ' '){
                return false;
            }
        }

        if(charCount < 1 || charCount > 30){
            return false;
        }

        return true;
        
    }

    public static int normalizeVolume(int volumeDb) {
        if(volumeDb >= 0 && volumeDb <= 100){
            return volumeDb;
        }

        if(volumeDb < 0){
            return 0;
        }

        return 100;
    
    }
}
