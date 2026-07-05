
# 1301. Number of Paths with Max Score

from pprint import pprint
class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        n = len(board)
        MOD = 10**9 + 7
        score_map = [[[0, 0] for _ in range(n + 1)] for _ in range(n + 1)]
        for i in range(n + 1):
            score_map[i][n][0] = -sys.maxsize - 1
            score_map[n][i][0] = -sys.maxsize - 1

        # pprint(score_map)

        for r in range(n - 1, -1, -1):
            for c in range(n - 1, -1, -1):
                curr_score = board[r][c][0]
                if curr_score in ["S"]:
                    score_map[r][c][1] = 1
                    continue
                elif curr_score == "E":
                    curr_score = 0
                elif curr_score == "X":
                    score_map[r][c][0] = -sys.maxsize - 1
                    continue
                else:
                    curr_score = int(curr_score)

                neighbor_score = max(
                    score_map[r + 1][c][0],
                    score_map[r][c + 1][0],
                    score_map[r + 1][c + 1][0],
                )
                neighbor_path = 0
                if neighbor_score == score_map[r + 1][c][0]:
                    neighbor_path += score_map[r + 1][c][1]
                if neighbor_score == score_map[r][c + 1][0]:
                    neighbor_path += score_map[r][c + 1][1]
                if neighbor_score == score_map[r + 1][c + 1][0]:
                    neighbor_path += score_map[r + 1][c + 1][1]

                # print(f"{score_map[r + 1][c][0]}, {score_map[r][c + 1][0]}, {score_map[r + 1][c + 1][0]}")
                # print(f"{r}:{c} ({curr_score}) -> {neighbor_score} {neighbor_path}")
                score_map[r][c][0] = curr_score + neighbor_score
                if score_map[r][c][0] > 0:
                    score_map[r][c][0] %= MOD
                score_map[r][c][1] = neighbor_path % MOD

        # pprint(score_map)
        
        if score_map[0][0][0] < 0:
            return [0, 0]
        return [score_map[0][0][0], score_map[r][c][1]]