import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tc = br.readLine().toInt()
    
    for (t in 1..tc) {
        val k = br.readLine().toInt()
        val n = br.readLine().toInt()
        
        val dp = Array(15) { IntArray(15) }

        // 0층 초기화
        for (i in 1..n) {
            dp[0][i] = i
        }

        // 1층 이상 계산
        for (floor in 1..k) {
            for (room in 1..n) {
                dp[floor][room] = dp[floor-1][room] + dp[floor][room-1]
            }
        }
        
        println(dp[k][n])
    }
}