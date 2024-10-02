import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_Q_10972_P {
    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = arr(br.readLine());

        if (perm()) {
            printArr(nums);
        } else {
            System.out.println("-1");
        }
    }

    public static int[] arr(String input) { // 입력 문자열을 정수 배열로 변환
        String[] parts = input.split(" ");
        int[] result = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            result[i] = Integer.parseInt(parts[i]);
        }

        return result;
    }

    public static void printArr(int[] arr) { // 결과 출력을 위한 함수
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean perm() {
        // 배열의 마지막부터 첫번째 감소하는 위치를 찾는 데 i 사용
        int i = nums.length - 1;
        
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--; // 감소하는 부분을 찾기 위해 i를 감소시킴
        }
        
        if (i <= 0) return false; // i가 0보다 작거나 같으면 더 이상 다음 순열이 없다는 뜻

        // 교환할 가장 작은 값을 찾는 데 j 사용
        int j = nums.length - 1;
        
        while (nums[j] <= nums[i - 1]) {
            j--; // nums[i-1]보다 큰 값을 찾기 위해 j를 감소
        }

        // i-1 위치와 j 위치의 값 교환
        swap(i - 1, j);

        // i부터 끝까지의 배열을 뒤집어 다음 순열을 만듦
        j = nums.length - 1;
        
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }

    private static void swap(int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}