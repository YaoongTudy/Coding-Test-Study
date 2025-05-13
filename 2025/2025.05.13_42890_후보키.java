import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        int n = relation.length; // 튜플 개수
        int m = relation[0].length; // 속성 개수
        
        // 후보키를 하나씩 담기 위한 리스트
        List<Integer> candidateKeys = new ArrayList<>();
        
        // 비트마스킹 
        for (int bitmask = 1; bitmask < (1 << m); bitmask++) { 
            Set<String> tuples = new HashSet<>();
            
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    if ((bitmask & (1 << j)) > 0) {
                        sb.append(relation[i][j]).append(",");
                    }
                }
                tuples.add(sb.toString());
            }
        
            if (tuples.size() == n) { // 유일성 체크
                
                boolean isMinimal = true;
                for (int key : candidateKeys) { // 후보키를 하나씩 순회
                    if ((key & bitmask) == key) {
                        isMinimal = false;
                        break;
                    }
                }
                
                if (isMinimal) {
                    candidateKeys.add(bitmask);
                }
                
            }
        }
        
        
        return candidateKeys.size();
    }
}
