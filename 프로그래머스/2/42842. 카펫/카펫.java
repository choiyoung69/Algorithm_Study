class Solution {
    public int[] solution(int brown, int yellow) {
        for(int width = 1; width <= 5000; width++) {
            for(int height = 1; height <= width; height++) {
                if(width + height == brown / 2 + 2) {
                    if(width * height == brown + yellow) {
                        return new int[] {width, height};
                    }
                }
            }
        }
        
        return null;
    }
}