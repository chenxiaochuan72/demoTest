package 面试;

public class RoundScore {

    public static double computeRoundScore(int N, int M, int[][] probabilities) {
        int sum = N;
        int totalScore = 0;
        for (int j = 0; j < M; j++) {
            // 计算出不同加分机制人数
            int wins = probabilities[j][0] * sum / 100;
            int losses = probabilities[j][1] * sum / 100;
            int draws = probabilities[j][2] * sum / 100;
            int quits = probabilities[j][3] * sum / 100;
            // 保存每轮额外加分
            int bonus = 0;
            // 如果人数小于0.1 则则本轮晋级人员所有人员额外bonus加分floor(本轮淘汰人数/晋级下一轮人数)
            if ((wins + draws) > 0 && (wins + draws) / (losses + quits) <= 1.0 / 10) {
                bonus = (int) Math.floor((losses + quits) / (wins + draws));
            }
            // 总分数
            totalScore += (wins * (j + 1 + 1)) + quits + (bonus * (wins + draws));
            // 下一轮人数
            sum = wins + draws;

        }


        return (double) totalScore / N;
    }

    public static void main(String[] args) {
        // 此为测试数据case, 测试通过不代表可通过所有case！提交前请自行充分测试!
        int n = 1000;
        int m = 3;
        int[][] percents = {
                {70, 10, 10, 10},
                {5, 85, 0, 10},
                {0, 50, 50, 0}
        };
        System.out.println(computeRoundScore(n, m, percents));
    }
}
