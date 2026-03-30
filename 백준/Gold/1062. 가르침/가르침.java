import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] words;
    static int[] candidates;   // antic 제외한 21개 알파벳
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new int[N];

        int baseMask = 0;
        baseMask |= 1 << ('a' - 'a');
        baseMask |= 1 << ('n' - 'a');
        baseMask |= 1 << ('t' - 'a');
        baseMask |= 1 << ('i' - 'a');
        baseMask |= 1 << ('c' - 'a');

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int mask = 0;
            for (int j = 0; j < word.length(); j++) {
                mask |= 1 << (word.charAt(j) - 'a');
            }
            words[i] = mask;
        }

        if (K < 5) {
            System.out.println(0);
            return;
        }

        if (K == 26) {
            System.out.println(N);
            return;
        }

        candidates = new int[21];
        int idx = 0;
        for (int i = 0; i < 26; i++) {
            if (i == ('a' - 'a') || i == ('n' - 'a') || i == ('t' - 'a')
                    || i == ('i' - 'a') || i == ('c' - 'a')) {
                continue;
            }
            candidates[idx++] = i;
        }

        comb(0, 0, K - 5, baseMask);

        System.out.println(answer);
    }

    static void comb(int start, int depth, int targetDepth, int mask) {
        if (depth == targetDepth) {
            answer = Math.max(answer, countReadable(mask));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            comb(i + 1, depth + 1, targetDepth, mask | (1 << candidates[i]));
        }
    }

    static int countReadable(int mask) {
        int count = 0;
        for (int word : words) {
            if ((word & mask) == word) {
                count++;
            }
        }
        return count;
    }
}
