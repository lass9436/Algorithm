# BOJ 14890 경사로
# 리팩토링중,,,!

import sys

input = sys.stdin.readline
n, L = list(map(int, input().split()))

dr = [0, 1]
dc = [0, 1]


def get_input():
    cells = []

    for _ in range(n):
        cells.append(list(map(int, input().split())))

    return cells


def move_down(cells, row, col):
    # 밟은 칸 수
    cnt = 1

    # 끝칸에 도달할 때까지
    # 높이가 바뀌면 cnt = 0
    while row < n - 1:
        # 같으면 진행
        if cells[row + 1][col] == cells[row][col]:
            cnt += 1
            row += 1
        # 한 칸 높으면 지금까지 연속으로 밟은 땅이 L이상일 때 진행
        elif cells[row + 1][col] - 1 == cells[row][col]:
            if L <= cnt:
                cnt = 1
                row += 1
            else:
                return 0
        # 한 칸 낮으면 한 칸 앞부터 연속으로 같은 높이가 L이상이면 진행
        elif cells[row + 1][col] + 1 == cells[row][col]:
            nr = row + 1
            n_cnt = 1
            while nr + 1 < n and cells[nr][col] == cells[nr + 1][col] and n_cnt < L:
                nr += 1
                n_cnt += 1
            if n_cnt >= L:
                cnt = 0
                row = nr
            else:
                return 0
        else:
            return 0

    return 1


def move_right(cells, row, col):
    # 밟은 칸 수
    cnt = 1

    # 끝칸에 도달할 때까지
    # 높이가 바뀌면 cnt = 0
    while col < n - 1:
        # 같으면 진행
        if cells[row][col + 1] == cells[row][col]:
            cnt += 1
            col += 1
        # 한 칸 높으면 지금까지 연속으로 밟은 땅이 L이상일 때 진행
        elif cells[row][col + 1] - 1 == cells[row][col]:
            if L <= cnt:
                cnt = 1
                col += 1
            else:
                return 0
        # 한 칸 낮으면 한 칸 앞부터 연속으로 같은 높이가 L이상이면 진행
        elif cells[row][col + 1] + 1 == cells[row][col]:
            nc = col + 1
            n_cnt = 1
            while nc + 1 < n and cells[row][nc + 1] == cells[row][nc] and n_cnt < L:
                nc += 1
                n_cnt += 1
            if n_cnt >= L:
                cnt = 0
                col = nc
            else:
                return 0
        else:
            return 0
    return 1


def solution(cells):
    cnt = 0

    for i in range(n):
        cnt += move_right(cells, i, 0)

    for i in range(n):
        cnt += move_down(cells, 0, i)

    return cnt


if __name__ == "__main__":
    print(solution(get_input()))