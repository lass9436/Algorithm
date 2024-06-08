import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * BOJ 홀짝
 * 
 * 아니 뭐 이딴 문제를 냈지? 일단 수열의 규칙을 찾아야한다.
 * 1 구간에서는 1
 * 2 구간에서는 2, 4
 * 3 구간에서는 5, 7, 9
 * 4 구간에서는 10, 12, 14, 16
 * 5 구간에서는 17, 19, 21, 23, 25
 * 6 구간에서는 26, 28, 30, 32, 34, 36
 * 7 구간에서는 37, 39, 41, 43, 45, 47, 49
 * 일단 이 문제 만든 사람은 천재가 확실하다.
 * 여기까지 수열을 적어보면 규칙이 보안다.
 * 임의의 N 개의 구간에서 N^2 이하로 N 개의 숫자가 있다는 것이다.
 * 그럼 임의의 인덱스 index 에서 N 구간에 있는지를 구할 수 있을까?
 * 1 + 2 + 3 + ... + N < index 라고 한다면,
 * 해당 구간 N 까지는 index 가 존재하지 않는다.
 * 그럼 누적합을 구할 수 있으면 바로 index 에서 해당 수열의 값을 가질수 있다.
 * 그런데 조건이 1 <= N (index) <= 10^100 이므로 말도 안되는 범위를 가지고 있다.
 * long 으로도 해결이 안 될 것이 뻔하므로 BigInteger 를 사용하도록 하자.
 * 근데 어? 어차피 대충 제곱근 근처인데 그것만 보면 되지 않나 싶은데,
 * 그 제곱근을 구하는게 매우 어렵다.
 * 해당 인덱스의 제곱근을 구하는게 이 문제의 핵심인데 그 제곱근 자체를 이분탐색으로 구해서 시간을 줄여야한다.
 * BigInteger 기 때문에 for 로 증가시키면서 제곱근을 찾으려고하면 안봐도 터질 것이다.
 * 그리고 구간을 찾았으면 mid 자체가 매우 크므로 연산을 통해 바로 찾아야한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger index = new BigInteger(br.readLine());
        BigInteger start = BigInteger.ONE;
        BigInteger end = index.add(BigInteger.ZERO);
        BigInteger mid = BigInteger.ZERO;
        BigInteger sum = BigInteger.ZERO;
        while (start.compareTo(end) <= 0) {
            mid = start.add(end).divide(BigInteger.TWO);
            sum = mid.multiply(mid.add(BigInteger.ONE)).divide(BigInteger.TWO);
            if (sum.subtract(mid).compareTo(index) < 0 && index.compareTo(sum) <= 0) {
                break;
            } else if (sum.compareTo(index) < 0) start = mid.add(BigInteger.ONE);
            else end = mid.subtract(BigInteger.ONE);
        }

        BigInteger distance = sum.subtract(index);
        BigInteger maxNumber = mid.multiply(mid);
        BigInteger number = maxNumber.subtract(distance.multiply(BigInteger.TWO));
        bw.write(number.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

